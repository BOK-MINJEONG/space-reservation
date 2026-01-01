package com.study.space_reservation.domain.space_reservation.dto.request;

import com.study.space_reservation.domain.space_reservation.Space;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SpaceCreateRequest {
    private String name;
    private int capacity;
    private String imageUrl;
    private String description;
    private String spaceNumber;
    private Space.SpaceType spaceType;
    private Long mapId;
}
