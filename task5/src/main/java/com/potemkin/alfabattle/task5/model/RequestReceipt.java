package com.potemkin.alfabattle.task5.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RequestReceipt {
    int shopId;
    boolean loyaltyCard;
    RequestPosition[] positions;
}
