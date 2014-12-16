package com.whatsthere.api.data;

import com.whatsthere.api.utils.FileUtils;
import org.joda.time.LocalDateTime;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by guyk on 11/12/14.
 */
public class ImageFile {

    private String pathToFile;
    private final static String IMAGE_PATH="/whatsthere/files/images";
    private final static String IMAGE_SUFFIX = ".zip";
    Image image;

    public ImageFile(byte[] byteArray) throws IOException {
       try{
           pathToFile =  IMAGE_PATH + LocalDateTime.now().toString() + IMAGE_SUFFIX;
           File file = new File(pathToFile);
           BufferedOutputStream stream =
                new BufferedOutputStream(new FileOutputStream(file));
           stream.write(byteArray);
           stream.close();
           FileUtils.zipFile(file ,pathToFile);
       }catch (IOException e) {
           throw e;
       }
    }
    public Image getImage(){
        return this.image;
    }

    public String getPath(){
        return this.pathToFile;
    }

}
