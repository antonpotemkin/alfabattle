package com.potemkin.alfabattle.task5.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestReceipt {
    int shopId;
    boolean loyaltyCard;
    Position[] positions;
}
