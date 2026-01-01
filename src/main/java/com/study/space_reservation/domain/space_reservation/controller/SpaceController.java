package com.study.space_reservation.domain.space_reservation.controller;

import com.study.space_reservation.domain.space_reservation.Space;
import com.study.space_reservation.domain.space_reservation.dto.request.SpaceCreateRequest;
import com.study.space_reservation.domain.space_reservation.dto.response.MapResponse;
import com.study.space_reservation.domain.space_reservation.dto.response.SpaceDetailResponse;
import com.study.space_reservation.domain.space_reservation.dto.response.SpaceResponse;
import com.study.space_reservation.domain.space_reservation.service.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class SpaceController {
    private final SpaceService spaceService;

    // 공간 생성
    @PostMapping
    public ResponseEntity<String> create(@RequestBody SpaceCreateRequest request) {
        String result = spaceService.createSpace(request);
        return ResponseEntity.ok(result);
    }

    // 모든 공간 조회
    @GetMapping
    public ResponseEntity<List<SpaceResponse>> getAllSpaces() {
        return ResponseEntity.ok(spaceService.findAllSpaces());
    }

    /** 공간 유형에 따른 가능한 위치 목록 조회 */
    @GetMapping("/locations")
    public ResponseEntity<List<MapResponse>> getAllMaps(@RequestParam Space.SpaceType spaceType,
                                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reservationDate) {
        return ResponseEntity.ok(spaceService.getAvailableMaps(spaceType, reservationDate));
    }

    /** 선택한 위치와 유형에 해당하는 공간 목록 조회 */
    @GetMapping("/spaces")
    public ResponseEntity<List<SpaceDetailResponse>> getSpaces(@RequestParam Long mapId,
                                                               @RequestParam Space.SpaceType spaceType) {
        List<SpaceDetailResponse> response = spaceService.getSpacesByMapAndType(mapId, spaceType);
        return ResponseEntity.ok(response);
    }
}
