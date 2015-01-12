package com.whatsthere.api.data;


import javax.annotation.Resource;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * Created by guyk on 11/5/14.
 */
@Entity
@Table(name = "image")
@Resource
public class Image {

    @Id
    @Column(name = "id")
    private long id;
    @Column
    private String locationOnStorage;
    @Column
    private String hashTagText;
    @Column
    private String fbToken;
    @Column
    private String formattedLocation;
    @Column
    private  String timeOfCapture;
    @Column
    private Timestamp modifyDate;


    public Image (String locationOnStorage, String hashTagText ,String fbToken,String formattedLocation,String timeOfCapture){
        this.setLocationOnStorage(locationOnStorage);
        this.setHashTagText(hashTagText);
        this.setFbToken(fbToken);
        this.setFormattedLocation(formattedLocation);
        this.setLocalDateTime(timeOfCapture);
        id = System.currentTimeMillis();
        java.util.Date date = new Date();
        modifyDate = new Timestamp(date.getTime());
    }

    public Image() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setLocalDateTime(String timeOfCapture) {
        this.timeOfCapture = timeOfCapture;
    }
    public String getTimeOfCapture() {
        return timeOfCapture;
    }

    public String getLocationOnStorage() {
        return locationOnStorage;
    }

    public void setHashTagText(String hashTagText) {
        this.hashTagText = hashTagText;
    }

    public void setLocationOnStorage(String fileName) {
        this.locationOnStorage = fileName;
    }

    public String getHashTagText() {
        return hashTagText;
    }

    public void setFbToken(String fbToken) {
        this.fbToken = fbToken;
    }
    public String getFbToken() {
        return fbToken;
    }

    public void setFormattedLocation(String formattedLocation) {
        this.formattedLocation = formattedLocation;
    }

    public String getFormattedLocation() {
        return formattedLocation;
    }

    public Timestamp getModifyDate() {
        return modifyDate;
    }



}
