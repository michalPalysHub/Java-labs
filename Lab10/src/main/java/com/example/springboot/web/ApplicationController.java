package com.example.springboot.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ApplicationController {

    // http://localhost:8181/image

    private static Map<String, BufferedImage> images = new HashMap<>();
    private static final String template = "0000-%d";
    private final AtomicLong counter = new AtomicLong();

    public String addImage(BufferedImage image){
        String id = String.format(template, counter.incrementAndGet());
        images.put(id, image);

        return id;
    }

    @RequestMapping(value="/image", method=RequestMethod.POST)
    public String uploadImage(@RequestParam("file") MultipartFile file) throws Exception{
        InputStream input = new ByteArrayInputStream(file.getBytes());
        BufferedImage image = ImageIO.read(input);
        String id = addImage(image);
        return String.format("{\n\tid: %s,\n\theight: %d, \n\twidth: %d}", id, image.getHeight(), image.getWidth());
    }

}
