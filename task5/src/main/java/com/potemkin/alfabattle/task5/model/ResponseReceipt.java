package com.potemkin.alfabattle.task5.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ResponseReceipt {
    BigDecimal total;
    BigDecimal discount;
    List<ResponsePosition> positions;
}
