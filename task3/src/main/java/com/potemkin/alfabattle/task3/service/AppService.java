package com.potemkin.alfabattle.task3.service;

import com.potemkin.alfabattle.task3.model.Branch;
import com.potemkin.alfabattle.task3.model.DistanceEntity;

public interface AppService {
    Branch getById(int id);
    DistanceEntity findNearest(double lat, double lon);
}
