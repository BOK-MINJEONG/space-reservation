package com.study.space_reservation.domain.space_reservation.service;

import com.study.space_reservation.domain.map.Map;
import com.study.space_reservation.domain.map.repository.MapRepository;
import com.study.space_reservation.domain.space_reservation.Space;
import com.study.space_reservation.domain.space_reservation.dto.request.SpaceCreateRequest;
import com.study.space_reservation.domain.space_reservation.dto.response.MapResponse;
import com.study.space_reservation.domain.space_reservation.dto.response.SpaceDetailResponse;
import com.study.space_reservation.domain.space_reservation.dto.response.SpaceResponse;
import com.study.space_reservation.domain.space_reservation.repository.SpaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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

    /** 공간 유형에 따른 가능한 위치 목록 조회 */
    public List<MapResponse> getAvailableMaps(Space.SpaceType spaceType, LocalDate reservationDate) {
        // 실제로는 reservationDate를 사용하여 해당 날짜에 운영하지 않는 건물을 제외하는 등의 로직이 추가될 수 있음
        List<Map> maps = spaceRepository.findDistinctMapsBySpaceType(spaceType);

        return maps.stream()
                .map(MapResponse::from)
                .collect(Collectors.toList());
    }

    /** 선택한 위치와 유형에 해당하는 공간 목록 조회 */
    public List<SpaceDetailResponse> getSpacesByMapAndType(Long mapId, Space.SpaceType spaceType) {
        List<Space> spaces = spaceRepository.findByMapIdAndSpaceTypeWithMap(mapId, spaceType);
        return spaces.stream()
                .map(SpaceDetailResponse::from)
                .collect(Collectors.toList());
    }
}
