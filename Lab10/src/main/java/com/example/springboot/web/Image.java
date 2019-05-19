package com.example.springboot.web;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static java.awt.geom.AffineTransform.getScaleInstance;

public class Image {

    private static Map<String, BufferedImage> images = new HashMap<>();
    private static final String template = "0000-%d";
    private static final AtomicLong counter = new AtomicLong();

    public static Map<String, BufferedImage> getImages(){
        return images;
    }

    public static String addImage(BufferedImage image){
        String id = String.format(template, counter.incrementAndGet());
        images.put(id, image);
        return id;
    }

    public static void deleteImage(String id){
        images.remove(id);
    }

    public static BufferedImage scaleImage(String id, double percent){
        BufferedImage image = getImages().get(id);
        double scaledWidth = image.getWidth() * percent / 100;
        double scaledHeight = image.getHeight() * percent / 100;

        BufferedImage scaledImage = new BufferedImage((int) scaledWidth, (int) scaledHeight, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform(getScaleInstance(percent/100, (percent/100)));
        AffineTransformOp ato = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
        scaledImage = ato.filter(image, scaledImage);

        return scaledImage;
    }

    public static BufferedImage cropImage(String id, int x, int y, int width, int height){
        if (x < 0 || y < 0 || width < 0 || height < 0){
            throw new IllegalArgumentException("Values of the parameters must be bigger than 0!");
        }
        return getImages().get(id).getSubimage(x, y, width, height);
    }
}
