package com.potemkin.alfabattle.task3;

import com.potemkin.alfabattle.task3.model.Branch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDistance {

    private int calculateDistance(double lat, double lon, Branch branch) {
        int r = 6371000;
        lat = Math.toRadians(lat);
        lon = Math.toRadians(lon);
        double branchLat = Math.toRadians(branch.getLat());
        double branchLon = Math.toRadians(branch.getLon());
        double first = Math.pow(Math.sin((branchLat - lat)/2), 2);
        double second = Math.pow(Math.sin((branchLon - lon)/2), 2);
        double sq = first + Math.cos(branchLat)*Math.cos(lat)* second;
        double asin = Math.asin(Math.sqrt(sq));
        double result = asin * 2 * r;
        System.out.println(result);
        return (int)Math.round(result);
    }

    @Test
    public void test() {
        Branch branch = new Branch(631, "", 37.6227, 55.7695, "");
        int i = calculateDistance(55.773284, 37.624125, branch);
        Assertions.assertEquals(430, i);
    }
}
