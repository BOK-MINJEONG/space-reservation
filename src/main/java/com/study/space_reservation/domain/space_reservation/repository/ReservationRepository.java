package com.study.space_reservation.domain.space_reservation.repository;

import com.study.space_reservation.domain.space_reservation.Reservation;
import com.study.space_reservation.domain.space_reservation.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findBySpace_IdAndReservationDateAndStatusIn(Long spaceId, LocalDate reservationDate, Collection<ReservationStatus> statuses);

    // 겹치는 예약 존재 체크
    @Query(
            "select case when count(r) > 0 then true else false end " +
                    "from Reservation r " +
                    "where r.space.id = :spaceId " +
                    "  and r.reservationDate = :date " +
                    "  and r.status in :blockingStatuses " +
                    "  and :start < r.endAt " +
                    "  and :end   > r.startAt"
    )
    boolean existsOverlappingReservation(
            @Param("spaceId") Long spaceId,
            @Param("date") LocalDate date,
            @Param("start") LocalTime start,
            @Param("end") LocalTime end,
            @Param("blockingStatuses") Collection<ReservationStatus> blockingStatuses
    );
}
