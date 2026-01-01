package com.study.space_reservation.domain.space_reservation.controller;

import com.study.space_reservation.domain.space_reservation.dto.SpaceCreateRequest;
import com.study.space_reservation.domain.space_reservation.dto.SpaceResponse;
import com.study.space_reservation.domain.space_reservation.service.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spaces")
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
}
