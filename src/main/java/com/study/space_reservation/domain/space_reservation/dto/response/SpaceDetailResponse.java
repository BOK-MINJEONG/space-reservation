package com.study.space_reservation.domain.space_reservation.dto.response;

import com.study.space_reservation.domain.space_reservation.Space;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SpaceDetailResponse {
    // 공통 필드
    private Long id;
    private Space.SpaceType spaceType;

    // 카드형 필드
    private String name;
    private Integer capacity;
    private String imageUrl;
    private String mapName;
//    private String mapLocation;

    // 도면형 필드
    private String spaceNumber;

    public static SpaceDetailResponse from(Space space) {
        return SpaceDetailResponse.builder()
                .id(space.getId())
                .spaceType(space.getSpaceType())
                .name(space.getName())
                .capacity(space.getCapacity())
                .imageUrl(space.getImageUrl())
                .mapName(space.getMap().getName())
                // .mapLocation()
                .spaceNumber(space.getSpaceNumber())
                .build();
    }
}
