package com.study.space_reservation.domain.space_reservation.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class ReservationCreateRequest {
    @NotNull private Long spaceId;
    @NotNull private LocalDate reservationDate;

    @NotNull @JsonFormat(pattern = "HH:mm")
    @Schema(type = "string", format = "time", example = "13:00")
    private LocalTime startAt;

    @NotNull @JsonFormat(pattern = "HH:mm")
    @Schema(type = "string", format = "time", example = "14:00")
    private LocalTime endAt;

    @NotNull private String purpose;
}
