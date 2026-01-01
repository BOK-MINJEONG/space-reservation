package com.study.space_reservation.domain.space_reservation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class TimeSlotResponse {
    @JsonFormat(pattern = "HH:mm")
    private LocalTime time;

    private boolean isAvailable;
}
