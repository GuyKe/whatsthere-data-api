package com.whatsthere.api.data;

/**
 * Created by guyk on 1/2/15.
 */
public class HashTag {



    private Location location;
    private String tagName;

    public HashTag(String tagName, Location location) {
        this.tagName = tagName;
        this.location = location;
    }


    public void setLocation(Location location) {
        this.location = location;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Location getLocation() {
        return location;
    }

    public String getTagName() {
        return tagName;
    }



}
