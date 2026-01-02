package com.study.space_reservation.domain.space_reservation.controller;

import com.study.space_reservation.domain.space_reservation.dto.request.SpaceCreateRequest;
import com.study.space_reservation.domain.space_reservation.dto.response.SpaceResponse;
import com.study.space_reservation.domain.space_reservation.service.ReservationService;
import com.study.space_reservation.domain.space_reservation.service.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {
    private final SpaceService spaceService;
    private final ReservationService reservationService;

    /** 공간 생성  */
    @PostMapping("/spaces")
    public ResponseEntity<String> create(@RequestBody SpaceCreateRequest request) {
        String result = spaceService.createSpace(request);
        return ResponseEntity.ok(result);
    }

    /** 모든 공간 조회 */
    @GetMapping("/spaces")
    public ResponseEntity<List<SpaceResponse>> getAllSpaces() {
        return ResponseEntity.ok(spaceService.findAllSpaces());
    }

    /** 전체 예약 목록 조회 (관리자 대시보드) */

    /** 예약 상태 변경 (관리자 대시보드) */
}
