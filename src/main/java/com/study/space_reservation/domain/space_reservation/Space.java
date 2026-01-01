package com.study.space_reservation.domain.space_reservation;

import com.study.space_reservation.domain.map.Map;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer capacity;

    private String imageUrl;

    private String spaceNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SpaceType spaceType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "map_id")
    private Map map;

    @Getter
    public enum SpaceType {
        OFFICE("회의실"),
        DESK("오픈 데스크"),
        KITCHEN("공유 주방"),
        STUDIO("촬영실");

        private final String label;
        SpaceType(String label) { this.label = label; }
    }
}
