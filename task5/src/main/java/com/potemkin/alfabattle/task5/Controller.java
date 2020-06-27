package com.potemkin.alfabattle.task5;

import com.potemkin.alfabattle.task5.model.PromoRequest;
import com.potemkin.alfabattle.task5.model.RequestReceipt;
import com.potemkin.alfabattle.task5.model.ResponseReceipt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@Slf4j
public class Controller {

    @Autowired
    private AppService service;

    @PostMapping("/promo")
    public ResponseEntity postItems(@RequestBody(required = false) PromoRequest promoRequest) {
        if (Objects.nonNull(promoRequest)) {
            service.updateDiscounts(promoRequest.getLoyaltyCardRules());
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/receipt")
    public ResponseReceipt receipt(@RequestBody RequestReceipt requestReceipt) {
        log.info("post req {}", requestReceipt);
        return service.calculateReceipt(requestReceipt);
    }
}
