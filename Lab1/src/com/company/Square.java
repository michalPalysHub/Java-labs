package com.company;

public class Square extends Figure implements Printable {
    private double a, area, perimeter;

    public Square() {
        this.a = 0;
        this.area = 0;
        this.perimeter = 0;
        this.name = "Square";
    }

    public Square(double a) {
        if ( a <= 0 ) throw new IllegalArgumentException();
        this.a = a;
        this.area = 0;
        this.perimeter = 0;
        this.name = "Square";
    }

    public double getA(){
        return this.a;
    }

    @Override
    public void print() {
        System.out.println("\nDługość boku kwadratu: " + a);
        System.out.println("Pole powierzchni: " + area);
        System.out.println("Obwód: " + perimeter);
    }

    @Override
    public double calculateArea() {
        this.area = this.a*this.a;
        return this.area;
    }

    @Override
    public double calculatePerimeter() {
        this.perimeter = 4*this.a;
        return this.perimeter;
    }
}