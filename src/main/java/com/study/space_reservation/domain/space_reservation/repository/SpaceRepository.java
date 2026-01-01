package com.study.space_reservation.domain.space_reservation.repository;

import com.study.space_reservation.domain.space_reservation.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpaceRepository extends JpaRepository<Space, Long> {
    // fetch join을 사용하여 진짜 Map 객체를 가져옴 (프록시 객체X)
    @Query("select s from Space s join fetch s.map")
    List<Space> findAllWithMap();
}
