package com.springyapi;

public class HaversineFormula {

    //  Average radius of the Earth in miles.
    public static final double RADIUS = 3958.8;

    public static final double LONDON_LAT = 51.5074;
    public static final double LONDON_LONG = 0.1278;


    //  A Java implementation of the Haversine formula for calculating distance.
    public static double haversine(double latitude2, double longitude2) {

        double latitude1 = LONDON_LAT;
        double longitude1 = LONDON_LONG;

        double dLat = Math.toRadians(latitude2 - latitude1);
        double dLon = Math.toRadians(longitude2 - longitude1);
        latitude1 = Math.toRadians(latitude1);
        latitude2 = Math.toRadians(latitude2);

        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(latitude1) * Math.cos(latitude2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return RADIUS * c;
    }
}
