package com.potemkin.alfabattle.task3.model;

import lombok.Data;

@Data
public class Predict {
    int id;
    String title;
    Double lon;
    Double lat;
    String address;
    int dayOfWeek;
    int hourOfDay;
    int predicting;
    public Predict(Branch branch, int dayOfWeek, int hourOfDay, int predicting) {
        this.id =  branch.id;
        this.address = branch.address;
        this.lat = branch.lat;
        this.lon = branch.lon;
        this.title = branch.title;
        this.dayOfWeek = dayOfWeek;
        this.hourOfDay = hourOfDay;
        this.predicting = predicting;
    }
}
