package com.study.space_reservation.domain.space_reservation;

import lombok.Getter;

@Getter
public enum ReservationStatus {
    APPROVED("승인완료"),
    REJECTED("예약반려"),
    COMPLETED("지난예약"); // 이용 시간이 지난 경우 혹은 이용 완료

    private final String label;

    ReservationStatus(String label) {
        this.label = label;
    }
}
