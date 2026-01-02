package com.study.space_reservation.domain.space_reservation.service;

import com.study.space_reservation.domain.space_reservation.Reservation;
import com.study.space_reservation.domain.space_reservation.ReservationStatus;
import com.study.space_reservation.domain.space_reservation.Space;
import com.study.space_reservation.domain.space_reservation.dto.request.ReservationCreateRequest;
import com.study.space_reservation.domain.space_reservation.dto.response.TimeSlotResponse;
import com.study.space_reservation.domain.space_reservation.repository.ReservationRepository;
import com.study.space_reservation.domain.space_reservation.repository.SpaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final SpaceRepository spaceRepository;
    private final Clock clock;

    // 슬롯 점유로 간주할 상태
    private static final List<ReservationStatus> BLOCKING_STATUSES =
            List.of(ReservationStatus.APPROVED, ReservationStatus.PENDING);


    /** 예약 시간(슬롯) 조회 */
    public List<TimeSlotResponse> getAvailableSlots(Long spaceId, LocalDate date) {
        List<Reservation> existingReservations = reservationRepository.findBySpace_IdAndReservationDateAndStatusIn(spaceId, date, BLOCKING_STATUSES);

        LocalDate today = LocalDate.now(clock);
        LocalTime now = LocalTime.now(clock);
        log.info("today = {}, now = {}", today, now);

        boolean isPastDate = date.isBefore(today);

        List<TimeSlotResponse> slots = new ArrayList<>(48);

        for (int i=0; i<48; i++) {
            LocalTime slotStart = LocalTime.of(i / 2, (i % 2) * 30);
            LocalTime slotEnd = slotStart.plusMinutes(30);

            boolean isOccupied = existingReservations.stream().anyMatch(res ->
                    slotStart.isBefore(res.getEndAt()) && slotEnd.isAfter(res.getStartAt()));

            boolean past = isPastDate || (date.equals(today) && slotStart.isBefore(now));
            boolean available = !isOccupied && !past;

            slots.add(new TimeSlotResponse(slotStart, available));
        }
        return slots;
    }

    /** 예약 생성 */
    @Transactional
    public String createReservation(ReservationCreateRequest request) throws Exception {
        validateTimePolicy(request);

        // space row를 비관락으로 잠금
        log.info("[LOCK 시작]");
        Space space;
        try {
            space = spaceRepository.findForUpdate(request.getSpaceId());
        } catch (Exception e) {
            throw new Exception("존재하지 않는 공간입니다.");
        }
        if (space == null) {
            throw new Exception("존재하지 않는 공간입니다.");
        }
        log.info("[LOCK 종료]");

        boolean conflict = reservationRepository.existsOverlappingReservation(
                request.getSpaceId(),
                request.getReservationDate(),
                request.getStartAt(),
                request.getEndAt(),
                BLOCKING_STATUSES
        );

        if (conflict) throw new Exception("이미 예약된 시간입니다.");

        // 예약 저장
        Reservation reservation = Reservation.builder()
                .reservationDate(request.getReservationDate())
                .startAt(request.getStartAt())
                .endAt(request.getEndAt())
                .purpose(request.getPurpose())
                .status(ReservationStatus.APPROVED)
                .space(space)
                .build();

        reservationRepository.save(reservation);

        return request.getStartAt().toString() + " : " + request.getEndAt().toString() + " 예약 성공";
    }

    private void validateTimePolicy(ReservationCreateRequest req) throws Exception {
        if (!req.getEndAt().isAfter(req.getStartAt())) {
            throw new Exception("endAt은 startAt보다 늦어야 합니다.");
        }

        // 30분 단위 강제
        if (!isThirtyMinuteAligned(req.getStartAt()) || !isThirtyMinuteAligned(req.getEndAt())) {
            throw new Exception("예약 시간은 30분 단위여야 합니다.");
        }

        // 자정 넘김 방지
        // 예: start=23:30 end=00:30 같은 케이스를 금지
        if (req.getEndAt().isBefore(req.getStartAt())) {
            throw new Exception("자정을 넘기는 예약은 지원하지 않습니다.");
        }

        // 과거 예약 방지(선택 정책)
        LocalDate today = LocalDate.now(clock);
        LocalTime now = LocalTime.now(clock);

        if (req.getReservationDate().isBefore(today)) {
            throw new Exception("과거 날짜는 예약할 수 없습니다.");
        }
        if (req.getReservationDate().isEqual(today) && req.getStartAt().isBefore(now)) {
            throw new Exception("이미 지난 시간은 예약할 수 없습니다.");
        }
    }

    private boolean isThirtyMinuteAligned(LocalTime t) {
        int m = t.getMinute();
        return (m == 0 || m == 30) && t.getSecond() == 0 && t.getNano() == 0;
    }
}
