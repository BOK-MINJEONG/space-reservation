package com.study.space_reservation.domain.space_reservation.controller;

import com.study.space_reservation.domain.space_reservation.dto.response.TimeSlotResponse;
import com.study.space_reservation.domain.space_reservation.service.ReservationService;
import com.study.space_reservation.domain.space_reservation.service.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/time")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<TimeSlotResponse>> getSlots(@RequestParam Long spaceId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(reservationService.getAvailableSlots(spaceId, date));
    }
}
