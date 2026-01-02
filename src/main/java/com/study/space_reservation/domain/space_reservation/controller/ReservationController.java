package com.study.space_reservation.domain.space_reservation.controller;

import com.study.space_reservation.domain.space_reservation.dto.request.ReservationCreateRequest;
import com.study.space_reservation.domain.space_reservation.dto.response.TimeSlotResponse;
import com.study.space_reservation.domain.space_reservation.service.ReservationService;
import com.study.space_reservation.domain.space_reservation.service.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    /** 예약 생성 */
    @PostMapping("/reservations")
    public ResponseEntity<String> create(@RequestBody @Validated ReservationCreateRequest request) throws Exception {
        return ResponseEntity.ok(reservationService.createReservation(request));
    }

    /** 예약 상세 조회 (사용자) */


    /** 예약 취소 */
//    @PatchMapping
//    public ResponseEntity<String> cancel(@RequestParam Long spaceId) {
//
//    }

    /** 사용자별 예약 목록 조회 (사용자) */

    /** 전체 예약 목록 조회 (관리자 대시보드) */

    /** 예약 상태 변경 (관리자 대시보드) */
}
