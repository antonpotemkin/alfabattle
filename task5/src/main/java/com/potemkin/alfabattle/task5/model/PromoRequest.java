package com.potemkin.alfabattle.task5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PromoRequest {
    List<Discount> loyaltyCardRules;

    public PromoRequest() {
        this.loyaltyCardRules = new ArrayList<>();
    }
}
