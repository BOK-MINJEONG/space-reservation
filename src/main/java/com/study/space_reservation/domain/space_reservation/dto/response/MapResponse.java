package com.study.space_reservation.domain.space_reservation.dto.response;

import com.study.space_reservation.domain.map.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MapResponse {
    private Long id;
    private String name;

    public static MapResponse from(Map map) {
        return new MapResponse(map.getId(), map.getName());
    }
}
