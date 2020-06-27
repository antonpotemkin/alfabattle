package com.potemkin.alfabattle.task5.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ResponsePosition {
    String id;
    String name;
    BigDecimal price;
    BigDecimal regularPrice;
}
