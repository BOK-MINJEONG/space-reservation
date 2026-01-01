package com.study.space_reservation.domain.map;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class MapCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    private String icon;
    private String pin;
    private int category_rank;


    @OneToMany(mappedBy = "mapCategory", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Map> maps = new ArrayList<>();

    public MapCategory(String categoryName) {
        this.categoryName = categoryName;
        this.category_rank = 11;
    }

    public void setRank(int rank) {
        this.category_rank = rank;
    }
}
