package com.whatsthere.api.controller;

import java.io.*;


import com.whatsthere.api.data.User;
import com.whatsthere.api.exception.ImageToOldException;
import com.whatsthere.api.manager.ImageStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;


@Controller
@MultipartConfig(
        fileSizeThreshold   = 10,
        maxFileSize         = 10,
        maxRequestSize      = 5,
        location            = "/root/wt_data/")
@RequestMapping("/data")
public class FileUploadController {

    private final ImageStore imageStore;
    private final String imagePath="/root/wt_data/";

    @Autowired
    public FileUploadController(ImageStore imageStore){
        this.imageStore = imageStore;

    }

    @RequestMapping(value="/image/upload", method=RequestMethod.POST)
    public @ResponseBody HttpStatus handleFileUpload(@RequestParam("hashTagText") String hashTagText,
                                                 @RequestParam("file") MultipartFile file,
                                                 @RequestParam("timeStamp") String timeOfCapture,
                                                 @RequestParam("fbToken") String fbToken,
                                                 @RequestParam("location") String formattedLocation){
        String fileName = "";
        if (!file.isEmpty()) {
            try {
               fileName =  imageStore.writeFile(file.getBytes());
            } catch (ImageToOldException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageStore.storeImage(fileName,hashTagText,timeOfCapture,fbToken,formattedLocation);
        }
        imageStore.fetchImageByHashtag(hashTagText);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/image/getImage/byHashtag" ,params = "tag", method = RequestMethod.GET)
    public HttpStatus getImageByTag(final String tag) {
        //Add response body
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/image/getImage/location" ,params = "location", method = RequestMethod.GET)
    public HttpStatus getImageByLocation(final String location) {
        //Add response body
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/image/fetch/userId" , params = "userId" , method = RequestMethod.GET)
    public HttpStatus getImageByUserId(final String userId) {
        return HttpStatus.OK;
    }


    @RequestMapping(value = "/image/fetch/tagByLocation" , params = "tag" , method = RequestMethod.GET)
    public HttpStatus getTagsByLocation(final String tag) {
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/user/store" , method = RequestMethod.POST)
    public ResponseEntity<User> storeUser(@RequestBody String user) {
        User userToStore = new User();
        return new ResponseEntity<User>(userToStore, HttpStatus.OK);
    }
}