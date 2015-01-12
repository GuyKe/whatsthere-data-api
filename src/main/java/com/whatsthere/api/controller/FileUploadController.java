package com.whatsthere.api.controller;

import com.whatsthere.api.data.User;
import com.whatsthere.api.exception.ImageToOldException;
import com.whatsthere.api.manager.ImageStore;
import com.whatsthere.api.transformers.MessageTransformer;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@Controller
@MultipartConfig(
        fileSizeThreshold   = 10,
        maxFileSize         = 10,
        maxRequestSize      = 5,
        location            = "/root/wt_data/")
@RequestMapping("/data")
public class FileUploadController {

    private final ImageStore imageStore;
    private static final String PATH_TO_FILE = "/whatsthere/files/images/";
    @Autowired
    private MessageTransformer toJsonTransformer;

    @Autowired
    public FileUploadController(ImageStore imageStore){
        this.imageStore = imageStore;

    }

    @RequestMapping(value="/image/upload", method=RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public  void handleFileUpload(@RequestParam("hashTagText") String hashTagText,
                                                 @RequestParam("file") MultipartFile file,
                                                 @RequestParam("timeStamp") String timeOfCapture,
                                                 @RequestParam("fbToken") String fbToken,
                                                 @RequestParam("location") String formattedLocation){

        String fileName = StringUtils.EMPTY;
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
    }

    @RequestMapping(value = "/image/getImage/hashtag", method = RequestMethod.GET)
    public @ResponseBody String getImageByHashtag(@RequestParam(value = "hashtag", required = true)String hashtag) {
        return toJsonTransformer.transform( imageStore.fetchImageByHashtag(hashtag));
    }

    @RequestMapping(value = "/image/download/byName", method = RequestMethod.GET)
    public void getFile(
            @RequestParam("fileName") String fileName,
        HttpServletResponse response) {
        response.setContentType("image/jpeg");
        try {
            InputStream is = new FileInputStream(PATH_TO_FILE + fileName);
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            throw new RuntimeException("IOError writing file to output stream");
        }
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