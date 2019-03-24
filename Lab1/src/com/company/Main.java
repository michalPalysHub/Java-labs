package com.company;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int select;

        /*
        *wyświetlanie - wywoływanie print() - powinno się odbywać przy użyciu obiektu typu Printable()
         */


        do
        {
            System.out.println("\nWybierz figurę wpisując: 1, 2, 3, 4");
            System.out.println("\t1 - kwadrat,");
            System.out.println("\t2 - okrąg,");
            System.out.println("\t3 - trójkąt,");
            System.out.println("\t4 - graniastosłup prawidłowy");
            System.out.println("\n\t5 - wyjście z programu.");

            select = scanner.nextInt();

            switch (select) {
                case 1:
                    System.out.println("Wybrano kwadrat.\nPodaj długość boku: ");
                    Scanner scanner1 = new Scanner(System.in);
                    double side = scanner1.nextDouble();
                    try {
                        Square s1 = new Square(side);
                        s1.calculateArea();
                        s1.calculatePerimeter();
                        s1.print();
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out.println("Rzucono wyjątek: " + e);
                        System.out.println("Spróbuj ponownie.");
                    }
                    break;
                case 2:
                    System.out.println("Wybrano okrąg.\nPodaj długość promienia: ");
                    Scanner scanner2 = new Scanner(System.in);
                    double radius = scanner2.nextDouble();
                    try {
                        Circle c1 = new Circle(radius);
                        c1.calculateArea();
                        c1.calculatePerimeter();
                        c1.print();
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out.println("Rzucono wyjątek: " + e);
                        System.out.println("Spróbuj ponownie.");
                    }
                    break;
                case 3:
                    System.out.println("Wybrano trójkąt.\nPodaj długości boków: ");
                    Scanner scanner3 = new Scanner(System.in);
                    double sideA = scanner3.nextDouble();
                    double sideB = scanner3.nextDouble();
                    double sideC = scanner3.nextDouble();
                    try {
                        Triangle t1 = new Triangle(sideA, sideB, sideC);
                        t1.calculateArea();
                        t1.calculatePerimeter();
                        t1.print();
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out.println("Rzucono wyjątek: " + e);
                        System.out.println("Spróbuj ponownie.");
                    }
                    break;
                case 4:
                    System.out.println("Wybrano graniastosłup foremny. Wybierz figurę w podstawie: ");
                    System.out.println("\t1 - kwadrat,");
                    System.out.println("\t2 - okrąg,");
                    System.out.println("\t3 - trójkąt,");
                    Scanner scanner4 = new Scanner(System.in);
                    Scanner scanner5 = new Scanner(System.in);
                    int select2 = scanner4.nextInt();
                    if (select2 == 1){
                        System.out.println("Podaj długość boku kwadratu w podstawie i wysokość graniastosłupa.");
                        double a = scanner5.nextDouble();
                        double h = scanner5.nextDouble();
                        try {
                            Square s = new Square(a);
                            Prism p = new Prism(s, h);
                            p.calculateArea();
                            p.calculateVolume();
                            p.print();
                        }
                        catch (IllegalArgumentException e)
                        {
                            System.out.println("Rzucono wyjątek: " + e);
                            System.out.println("Spróbuj ponownie.");
                        }
                    }
                    else if (select2 == 2)
                    {
                        System.out.println("Podaj długość promienia okręgu podstawie i wysokość graniastosłupa.");
                        double r = scanner5.nextDouble();
                        double h = scanner5.nextDouble();
                        try {
                            Circle c = new Circle(r);
                            Prism p = new Prism(c, h);
                            p.calculateArea();
                            p.calculateVolume();
                            p.print();
                        }
                        catch (IllegalArgumentException e)
                        {
                            System.out.println("Rzucono wyjątek: " + e);
                            System.out.println("Spróbuj ponownie.");
                        }
                    }
                    else if (select2 == 3)
                    {
                        System.out.println("Podaj długość boku trójkąta w podstawie i wysokość graniastosłupa.");
                        double a = scanner5.nextDouble();
                        double h = scanner5.nextDouble();
                        try {
                            Triangle t = new Triangle(a, a, a);
                            Prism p = new Prism(t, h);
                            p.calculateArea();
                            p.calculateVolume();
                            p.print();
                        }
                        catch (IllegalArgumentException e)
                        {
                            System.out.println("Rzucono wyjątek: " + e);
                            System.out.println("Spróbuj ponownie.");
                        }
                    }
                    else
                    {
                        System.out.println("Nie ma takiej opcji. Spróbuj ponownie. ");
                    }
                    break;
                case 5:
                    System.out.println("Wyjście z programu.");
                    break;
                default:
                    System.out.println("Nie ma takiej opcji. Spróbuj ponownie.");
                    break;
            }
        }
        while (select != 5);

        scanner.close();
    }
}