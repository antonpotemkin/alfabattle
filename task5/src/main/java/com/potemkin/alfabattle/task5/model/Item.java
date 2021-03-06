package com.potemkin.alfabattle.task5.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Item {
    String id;
    String name;
    String groupId;
    BigDecimal price;
}
