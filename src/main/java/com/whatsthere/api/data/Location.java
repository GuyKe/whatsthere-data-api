package com.whatsthere.api.data;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by guyk on 11/30/14.
 */

@Entity
@Table(name = "location")
@Resource
public class Location implements Comparable<Location> {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    // create and initialize a point with given name and
    // (latitude, longitude) specified in degrees
    public Location(int id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(){

    }
    @Override
    public int compareTo(Location that) {
        Double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
        Double lat1 = Math.toRadians(this.latitude);
        Double lon1 = Math.toRadians(this.longitude);
        Double lat2 = Math.toRadians(that.latitude);
        Double lon2 = Math.toRadians(that.longitude);

        // great circle distance in radians, using law of cosines formula
        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

        // each degree on a great circle of Earth is 60 nautical miles
        Double nauticalMiles = 60 * Math.toDegrees(angle);
        Double statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
        return Integer.parseInt(statuteMiles.toString());
    }



    public String toString() {
        return  latitude +", "+ longitude;
    }
}