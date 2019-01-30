package com.company;

import java.util.Scanner;

public class RectangleArea {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("a= ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.print("b= ");
        double b = Double.parseDouble(scanner.nextLine());
        double areaOfRectangle = (a*b);

        System.out.println("Rectangle's area = " +areaOfRectangle);

    }

}
