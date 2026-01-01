package com.study.space_reservation.domain.space_reservation.service;

import com.study.space_reservation.domain.space_reservation.Reservation;
import com.study.space_reservation.domain.space_reservation.ReservationStatus;
import com.study.space_reservation.domain.space_reservation.dto.response.TimeSlotResponse;
import com.study.space_reservation.domain.space_reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    private final Clock clock;

    // 슬롯 점유로 간주할 상태
    private static final List<ReservationStatus> BLOCKING_STATUSES =
            List.of(ReservationStatus.APPROVED, ReservationStatus.PENDING);


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
}
