package com.example.springboot.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    public void deleteImage(String id){
        images.remove(id);
    }

    @RequestMapping(value="/image", method=RequestMethod.POST)
    public String uploadImage(@RequestParam("file") MultipartFile file) throws Exception{
        InputStream input = new ByteArrayInputStream(file.getBytes());
        BufferedImage image = ImageIO.read(input);
        String id = addImage(image);
        return String.format("{\n\tid: %s,\n\theight: %d, \n\twidth: %d\n}", id, image.getHeight(), image.getWidth());
    }

    @RequestMapping(value="/image/{id}", method=RequestMethod.DELETE)
    public ResponseEntity removeImage(@PathVariable("id") String id){
        if (!images.containsKey(id)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            deleteImage(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @RequestMapping(value="/image/{id}/size", method=RequestMethod.GET)
    public ResponseEntity<String> getSize(@PathVariable("id") String id){
        if (!images.containsKey(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            BufferedImage image = images.get(id);
            return new ResponseEntity<>(String.format("{\n\theight: %d, \n\twidth: %d\n}", image.getHeight(), image.getWidth()), HttpStatus.OK);
        }
    }

    @RequestMapping(value="/image/{id}/histogram", method=RequestMethod.GET)
    public ResponseEntity<String> getHistogram(@PathVariable("id") String id){
        if (!images.containsKey(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new Histogram().get(images.get(id)), HttpStatus.OK);
        }
    }
}
