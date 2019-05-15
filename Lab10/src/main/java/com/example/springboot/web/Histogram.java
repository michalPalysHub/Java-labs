package com.example.springboot.web;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Histogram {

    public List<Double> redCanal = new ArrayList<>();
    public List<Double> greenCanal = new ArrayList<>();
    public List<Double> blueCanal = new ArrayList<>();

    public Histogram() {
        for (int i = 0; i < 256; i++) {
            redCanal.add(0.);
            greenCanal.add(0.);
            blueCanal.add(0.);
        }
    }

    public String printHistogram(){
        String result = "{\n\tR: {";

        for (int r = 0; r < 256; r++){
            result += "\n\t\t" + r + ": " + redCanal.get(r) + ",";
        }

        result += "\n\t},\n\tG: {";

        for (int g = 0; g < 256; g++){
            result += "\n\t\t" + g + ": " + greenCanal.get(g) + ",";
        }

        result += "\n\t},\n\tB: {";

        for (int b = 0; b < 256; b++){
            result += "\n\t\t" + b + ": " + blueCanal.get(b) + ",";
        }

        result += "\n\t},\n}";

        return result;
    }

    public String get(BufferedImage image){

        /*
            getRGB() method returns an opaque sRGB color
            with the specified combined RGB value
            the red component in bits 16-23,
            the green component in bits 8-15,
            and the blue component in bits 0-7.
         */

        for (int i = 0; i < image.getWidth(); i++){
            for (int j = 0; j < image.getHeight(); j++){
                Color color = new Color(image.getRGB(i, j));

                int redIndex = color.getRed();
                int greenIndex = color.getGreen();
                int blueIndex = color.getBlue();

                this.redCanal.set(redIndex, redCanal.get(redIndex)+1);
                this.greenCanal.set(greenIndex, greenCanal.get(greenIndex)+1);
                this.blueCanal.set(blueIndex, blueCanal.get(blueIndex)+1);
            }
        }

        for (int k = 0; k < 256; k++){
            redCanal.set(k, redCanal.get(k)/ Collections.max(redCanal));
            greenCanal.set(k, greenCanal.get(k)/Collections.max(greenCanal));
            blueCanal.set(k, blueCanal.get(k) / Collections.max(blueCanal));
        }

        return printHistogram();
    }
}
