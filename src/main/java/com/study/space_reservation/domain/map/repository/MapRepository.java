package com.study.space_reservation.domain.map.repository;

import com.study.space_reservation.domain.map.Map;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository extends JpaRepository<Map, Long> {
}
