package com.example.springboot.web;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Image {

    private static Map<String, BufferedImage> images = new HashMap<>();
    private static final String template = "0000-%d";
    private static final AtomicLong counter = new AtomicLong();

    public static String addImage(BufferedImage image){
        String id = String.format(template, counter.incrementAndGet());
        images.put(id, image);

        return id;
    }

    public static void deleteImage(String id){
        images.remove(id);
    }



    public static Map<String, BufferedImage> getImages(){
        return images;
    }
}
