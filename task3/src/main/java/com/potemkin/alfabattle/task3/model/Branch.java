package com.potemkin.alfabattle.task3.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Branch {
    int id;
    String title;
    Double lon;
    Double lat;
    String address;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                ", address='" + address + '\'' +
                '}';
    }
}
