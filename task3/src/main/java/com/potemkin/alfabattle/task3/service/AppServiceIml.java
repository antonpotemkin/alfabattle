package com.potemkin.alfabattle.task3.service;

import com.potemkin.alfabattle.task3.model.Branch;
import com.potemkin.alfabattle.task3.model.DistanceEntity;
import com.potemkin.alfabattle.task3.model.SqlException;
import com.potemkin.alfabattle.task3.repository.BranchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class AppServiceIml implements AppService {

    @Autowired
    private BranchRepository repository;

    @Override
    public Branch getById(int id) {
        try {
            return repository.getById(id);
        } catch (SQLException e) {
            throw new SqlException(e);
        }
    }

    @Override
    public DistanceEntity findNearest(double lat, double lon) {
        try {
            List<Branch> all = repository.getAll();
            DistanceEntity neasert = null;
            for (Branch branch : all) {
                int distance = calculateDistance(lat, lon, branch);
                if (Objects.isNull(neasert) || neasert.getDistance() > distance) {
                    neasert = new DistanceEntity(branch, distance);
                }
            }
            return neasert;
        } catch (SQLException e) {
            throw new SqlException(e);
        }
    }

    private int calculateDistance(double lat, double lon, Branch branch) {
        int r = 6371000;
        lat = Math.toRadians(lat);
        lon = Math.toRadians(lon);
        double branchLat = Math.toRadians(branch.getLat());
        double branchLon = Math.toRadians(branch.getLon());
        double first = Math.pow(Math.sin((branchLat - lat) / 2), 2);
        double second = Math.pow(Math.sin((branchLon - lon) / 2), 2);
        double sq = first + Math.cos(branchLat) * Math.cos(lat) * second;
        double asin = Math.asin(Math.sqrt(sq));
        double result = asin * 2 * r;
        System.out.println(result);
        return (int) Math.round(result);
    }


}
