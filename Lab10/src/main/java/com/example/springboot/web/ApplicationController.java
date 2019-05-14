package com.example.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ApplicationController {

   /* private static Map<String, BufferedImage> images = new HashMap<>();
    private static final String template = "0000-%d";
    private final AtomicLong counter = new AtomicLong();

    public String addImage(BufferedImage image){
        String id = String.format(template, counter.incrementAndGet());
        images.put(id, image);

        return id;
    }

    // http://localhost:8181/image

    @RequestMapping(value="/test")
    public String test(){
        return "testtt";
    }

    @RequestMapping(value="/image", method=RequestMethod.POST)
    public String uploadImage(@RequestParam("file") MultipartFile file, HttpServletRequest requestEntity, HttpServletResponse responseEntity) throws Exception{
        InputStream input = new ByteArrayInputStream(file.getBytes());
        BufferedImage image = ImageIO.read(input);
        String id = addImage(image);
        //return String.format("{\n\tid: %s,\n\theight: %d, \n\twidth: %d}", id, image.getHeight(), image.getWidth());
        return ";";
    }*/

    public static int id=100;
    private static Map<String, BufferedImage> pics=new HashMap<>();

    static String addImage(BufferedImage img){
        id++;
        String key=String.valueOf(id);
        pics.put(key,img);
        return key;
    }

    @RequestMapping(value = "/image", method = RequestMethod.POST)
    public String uploadFile(@RequestParam MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        InputStream in = new ByteArrayInputStream(file.getBytes());
        BufferedImage img = ImageIO.read(in);
        String id = addImage(img);
        return "{id : "+id+", height: "+img.getHeight()+", width: "+img.getWidth()+"}";
    }
}
