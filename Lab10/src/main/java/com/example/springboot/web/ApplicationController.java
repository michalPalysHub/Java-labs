package com.example.springboot.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;

import java.awt.image.BufferedImage;
import java.io.*;


@RestController
public class ApplicationController {

    // http://localhost:8181/image


    @RequestMapping(value="/image", method=RequestMethod.POST)
    public String uploadImage(@RequestParam("file") MultipartFile file) throws Exception{
        InputStream input = new ByteArrayInputStream(file.getBytes());
        BufferedImage image = ImageIO.read(input);
        String id = Image.addImage(image);
        return String.format("{\n\tid: %s,\n\theight: %d, \n\twidth: %d\n}", id, image.getHeight(), image.getWidth());
    }

    @RequestMapping(value="/image/{id}/delete", method=RequestMethod.DELETE)
    public ResponseEntity removeImage(@PathVariable("id") String id){
        if (!Image.getImages().containsKey(id)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            Image.deleteImage(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @RequestMapping(value="/image/{id}", method=RequestMethod.GET, produces=MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> printImage(@PathVariable("id") String id) throws Exception{
        if (!Image.getImages().containsKey(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            BufferedImage image = Image.getImages().get(id);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", output);

            return new ResponseEntity<>(output.toByteArray(), HttpStatus.OK);
        }
    }

    @RequestMapping(value="/image/{id}/size", method=RequestMethod.GET)
    public ResponseEntity<String> getSize(@PathVariable("id") String id){
        if (!Image.getImages().containsKey(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            BufferedImage image = Image.getImages().get(id);
            return new ResponseEntity<>(String.format("{\n\theight: %d, \n\twidth: %d\n}", image.getHeight(), image.getWidth()), HttpStatus.OK);
        }
    }

    @RequestMapping(value="/image/{id}/scale/{percent}", method=RequestMethod.GET, produces=MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> scaleImage(@PathVariable("id") String id, @PathVariable("percent") double percent) throws Exception{
        if (!Image.getImages().containsKey(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            BufferedImage image = Image.scaleImage(id, percent);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", output);
            return new ResponseEntity<>(output.toByteArray(), HttpStatus.OK);
        }
    }

    @RequestMapping(value="/image/{id}/histogram", method=RequestMethod.GET)
    public ResponseEntity<String> getHistogram(@PathVariable("id") String id){
        if (!Image.getImages().containsKey(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new Histogram().get(Image.getImages().get(id)), HttpStatus.OK);
        }
    }

    @RequestMapping(value="/image/{id}/crop/{start}/{stop}/{width}/{height}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> cropImage(
            @PathVariable("id") String id,
            @PathVariable("start") int start,
            @PathVariable("stop") int stop,
            @PathVariable("width") int width,
            @PathVariable("height") int height
    ) throws Exception {
        if (!Image.getImages().containsKey(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            BufferedImage croppedImage = Image.cropImage(id, start, stop, width, height);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ImageIO.write(croppedImage, "jpg", output);
            return new ResponseEntity<>(output.toByteArray(), HttpStatus.OK);
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleError(IllegalArgumentException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
