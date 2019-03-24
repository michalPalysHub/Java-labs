package com.company;

public class Prism extends Figure implements Printable{
    private Figure fig;
    private double height, area, volume;

    public Prism(){
        this.fig = null;
        this.height = 0;
        this.area = 0;
        this.volume = 0;
    }

    public Prism(Figure f, double h){
        this.fig = f;
        this.height = h;
        this.area = 0;
        this.volume = 0;
    }

    @Override
    public void print(){
        System.out.println("Graniastosłup prawidłowy o podstawie " + this.fig.name);
        System.out.println("Pole powierzchni: " + this.area);
        System.out.println("Objętość: " + this.volume);
    }

    @Override
    public double calculateArea(){
        this.area = 2*this.fig.calculateArea() + this.fig.calculatePerimeter()*this.height;
        return this.area;
    }

    @Override
    public double calculatePerimeter(){
        return 0;
    }

    public double calculateVolume(){
        this.volume = this.fig.calculateArea()*this.height;
        return this.volume;
    }
}