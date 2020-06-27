package com.potemkin.alfabattle.task3;

import com.potemkin.alfabattle.task3.model.Branch;
import com.potemkin.alfabattle.task3.model.DistanceEntity;
import com.potemkin.alfabattle.task3.service.AppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AppController {

    @Autowired
    private AppService service;

    @GetMapping("/branches/{id}")
    public Branch getById(@PathVariable int id) {
        log.info("getById {}", id);
        return service.getById(id);
    }

    @GetMapping("/branches")
    public DistanceEntity calculateDistance(@RequestParam(name = "lat") String lat, @RequestParam(name = "lon") String lon) {
        log.info("calculateDistance {}, {}",lat, lon);
        return service.findNearest(Double.parseDouble(lat), Double.parseDouble(lon));
    }
}
