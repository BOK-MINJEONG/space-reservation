package com.study.space_reservation.domain.space_reservation.repository;

import com.study.space_reservation.domain.map.Map;
import com.study.space_reservation.domain.space_reservation.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.List;

public interface SpaceRepository extends JpaRepository<Space, Long> {
    // fetch join을 사용하여 진짜 Map 객체를 가져옴 (프록시 객체X)
    @Query("select s from Space s join fetch s.map")
    List<Space> findAllWithMap();

    // 특정 공간 유형이 존재하는 위치(Map) 목록을 중복 없이 조회
    @Query("SELECT DISTINCT s.map FROM Space s WHERE s.spaceType = :spaceType")
    List<Map> findDistinctMapsBySpaceType(@Param("spaceType") Space.SpaceType spaceType);

    @Query("SELECT s FROM Space s " +
            "JOIN FETCH s.map " +
            "WHERE s.map.id = :mapId AND s.spaceType = :spaceType")
    List<Space> findByMapIdAndSpaceTypeWithMap(@Param("mapId") Long mapId, @Param("spaceType") Space.SpaceType spaceType);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select s from Space s where s.id = :id")
    Space findForUpdate(@Param("id") Long id);
}
