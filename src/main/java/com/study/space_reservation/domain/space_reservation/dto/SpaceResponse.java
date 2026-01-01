package com.study.space_reservation.domain.space_reservation.dto;

import com.study.space_reservation.domain.space_reservation.Space;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SpaceResponse {
    private Long id;
    private String name;
    private int capacity;
    private String label; // Enum의 "회의실" 같은 한글명
    private String spaceNumber;
    private String mapName; // Map 엔티티에서 이름을 가져옴

    public static SpaceResponse from(Space space) {
        return SpaceResponse.builder()
                .id(space.getId())
                .name(space.getName())
                .capacity(space.getCapacity())
                .label(space.getSpaceType().getLabel())
                .spaceNumber(space.getSpaceNumber())
                .mapName(space.getMap().getName())
                .build();
    }
}
