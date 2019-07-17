package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("leva: ");
        double leva = Double.parseDouble(scanner.next());
        double euro = (leva / 1.95583);

        System.out.println(leva + " leva = " +String.format("%.2f", euro) +" euro");

    }
}
