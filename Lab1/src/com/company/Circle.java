package com.company;

import java.lang.Math;

public class Circle extends Figure implements Printable {
    private double r, area, perimeter;

    public Circle() {
        this.r = 0;
        this.area = 0;
        this.perimeter = 0;
        this.name = "Circle";
    }

    public Circle(double r) {
        if ( r <= 0 ) throw new IllegalArgumentException();
        this.r = r;
        this.area = 0;
        this.perimeter = 0;
        this.name = "Circle";
    }

    @Override
    public void print() {
        System.out.println("\nDługość promienia okręgu: " + r);
        System.out.println("Pole powierzchni: " + area);
        System.out.println("Obwód: " + perimeter);
    }

    @Override
    public double calculateArea() {
        this.area = Math.PI*r*r;
        return this.area;
    }

    @Override
    public double calculatePerimeter() {
        this.perimeter = Math.PI*2*r;
        return this.perimeter;
    }
}
