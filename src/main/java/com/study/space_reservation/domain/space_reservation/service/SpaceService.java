package com.study.space_reservation.domain.space_reservation.service;

import com.study.space_reservation.domain.map.Map;
import com.study.space_reservation.domain.map.repository.MapRepository;
import com.study.space_reservation.domain.space_reservation.Space;
import com.study.space_reservation.domain.space_reservation.dto.SpaceCreateRequest;
import com.study.space_reservation.domain.space_reservation.dto.SpaceResponse;
import com.study.space_reservation.domain.space_reservation.repository.SpaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpaceService {
    private final MapRepository mapRepository;
    private final SpaceRepository spaceRepository;

    @Transactional
    public String createSpace(SpaceCreateRequest request) {
        // 1. 해당 거점(Map)이 존재하는지 확인
        Map map = mapRepository.findById(request.getMapId())
                .orElseThrow(() -> new IllegalArgumentException("해당 거점이 존재하지 않습니다."));

        // 2. 빌더 패턴으로 엔티티 생성
        Space space = Space.builder()
                .name(request.getName())
                .capacity(request.getCapacity())
                .imageUrl(request.getImageUrl())
                .description(request.getDescription())
                .spaceNumber(request.getSpaceNumber())
                .spaceType(request.getSpaceType())
                .map(map)
                .build();

        spaceRepository.save(space);

        return "저장 성공";
    }

    public List<SpaceResponse> findAllSpaces() {
        return spaceRepository.findAllWithMap().stream()
                .map(SpaceResponse::from)
                .collect(Collectors.toList());
    }
}
