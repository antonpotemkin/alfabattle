package com.potemkin.alfabattle.task5;

import com.potemkin.alfabattle.task5.model.RequestReceipt;
import com.potemkin.alfabattle.task5.model.ResponseReceipt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
@Slf4j
public class Controller {

    @Autowired
    private AppService service;

    @GetMapping
    public String getHello() {
        return "Hello";
    }

    @PostMapping("/promo")
    public void postItems() {
    }

    @PostMapping("/receipt")
    public ResponseReceipt postItems(@RequestBody RequestReceipt requestReceipt) {
        log.info("post req {}", requestReceipt);
        return service.calculateReceipt(requestReceipt);
    }
}
