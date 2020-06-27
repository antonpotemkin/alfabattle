package com.potemkin.alfabattle.task3.model;

import lombok.Data;

@Data
public class DistanceEntity {
    int id;
    String title;
    Double lon;
    Double lat;
    String address;
    int distance;
    public DistanceEntity(Branch branch, int distance) {
        this.id =  branch.id;
        this.address = branch.address;
        this.lat = branch.lat;
        this.lon = branch.lon;
        this.title = branch.title;
        this.distance = distance;
    }
}
