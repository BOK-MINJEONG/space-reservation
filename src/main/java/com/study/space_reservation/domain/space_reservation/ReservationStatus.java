package com.study.space_reservation.domain.space_reservation;

import lombok.Getter;

@Getter
public enum ReservationStatus {
    PENDING("승인대기"),
    APPROVED("승인완료"),
    REJECTED("예약반려"),
    CANCELLED("취소");

    // 지난예약은 endAt < now로 대시보드 조회 시 계산

    private final String label;

    ReservationStatus(String label) {
        this.label = label;
    }
}
