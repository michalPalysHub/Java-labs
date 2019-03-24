package com.company;

import java.lang.Math;

public class Triangle extends Figure implements Printable {
    private double a, b, c, area, perimeter;

    public Triangle() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.area = 0;
        this.perimeter = 0;
        this.name = "Triangle";
    }

    public Triangle(double A, double B, double C) {
        //sprawdzam warunek na istnienie trójkąta
        if (( A<=0 || B<=0 || C<=0 ) || ((A + B <= C)||(A + C <= B)||(B + C <= A))) throw new IllegalArgumentException();
        this.a = A;
        this.b = B;
        this.c = C;
        this.area = 0;
        this.perimeter = 0;
        this.name = "Triangle";
    }

    @Override
    public void print() {
        System.out.println("\nDługości boków trójkąta: " + a + ", " + b + ", " + c);
        System.out.println("Pole powierzchni: " + area);
        System.out.println("Obwód: " + perimeter);
    }

    @Override
    public double calculatePerimeter() {
        this.perimeter = this.a + this.b + this.c;
        return this.perimeter;
    }

    @Override
    public double calculateArea() {
        double p = 0.5*this.calculatePerimeter();
        this.area = Math.sqrt(p*(p - this.a)*(p - this.b)*(p - this.c));
        return this.area;
    }
}