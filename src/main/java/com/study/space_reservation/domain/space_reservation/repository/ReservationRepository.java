package com.study.space_reservation.domain.space_reservation.repository;

import com.study.space_reservation.domain.space_reservation.Reservation;
import com.study.space_reservation.domain.space_reservation.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findBySpace_IdAndReservationDateAndStatusIn(Long spaceId, LocalDate reservationDate, Collection<ReservationStatus> statuses);
}
