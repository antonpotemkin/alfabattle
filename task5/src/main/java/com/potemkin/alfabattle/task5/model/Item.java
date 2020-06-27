package com.potemkin.alfabattle.task5.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    int id;
    String name;
    String groupId;
    double price;
}
