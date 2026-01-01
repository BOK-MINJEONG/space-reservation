package com.study.space_reservation.domain.map;

import com.study.space_reservation.domain.map.dto.MapCreateDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String summary;

    @Column(columnDefinition = "varchar(2000)")
    private String content;

    private String location;

    private double latitude; // 위도
    private double longitude; // 경도

    private String operationHours;

    private String thumbnail;
    private String icon;

    private String buttonName;
    private String url;

    @Column(length = 1000)
    private String buttonImage;

    @Enumerated(EnumType.STRING)
    private OperationTime operationType;

    public enum OperationTime {
        afternoon, evening, all
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mapCategory_id")
    private MapCategory mapCategory;

    @Builder
    public Map(MapCreateDto mapCreateDto, OperationTime operationType) {
        this.location = mapCreateDto.getLocation();
        this.content = mapCreateDto.getContent();
        this.name = mapCreateDto.getName();
        this.summary = mapCreateDto.getSummary();
        this.latitude = mapCreateDto.getLatitude();
        this.longitude = mapCreateDto.getLongitude();
        this.operationHours = mapCreateDto.getOperationHours();
        this.thumbnail = mapCreateDto.getThumbnail();
        this.operationType = operationType;
        this.icon = mapCreateDto.getIcon();
        this.buttonName = mapCreateDto.getButtonName();
        this.buttonImage = mapCreateDto.getButtonImage();
        this.url = mapCreateDto.getUrl();
    }

    public void setMap(MapCreateDto mapCreateDto) {
        this.location = mapCreateDto.getLocation();
        this.content = mapCreateDto.getContent();
        this.name = mapCreateDto.getName();
        this.summary = mapCreateDto.getSummary();
        this.latitude = mapCreateDto.getLatitude();
        this.longitude = mapCreateDto.getLongitude();
        this.operationHours = mapCreateDto.getOperationHours();
        this.thumbnail = mapCreateDto.getThumbnail();
        this.icon = mapCreateDto.getIcon();
        this.buttonName = mapCreateDto.getButtonName();
        this.buttonImage = mapCreateDto.getButtonImage();
        this.url = mapCreateDto.getUrl();
    }

    public void setMapCategory(MapCategory mapCategory){
        this.mapCategory = mapCategory;
    }
}
