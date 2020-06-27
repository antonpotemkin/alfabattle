package com.potemkin.alfabattle.task5;

import com.potemkin.alfabattle.task5.model.RequestReceipt;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
public class Controller {

    @GetMapping
    public String getHello() {
        return "Hello";
    }

    @PostMapping("/promo")
    public void postItems() {

    }

    @PostMapping("/request")
    public void postItems(@RequestBody RequestReceipt requestReceipt) {
        if (Objects.nonNull(requestReceipt)) {

        }
    }
}
