package com.company;

import java.util.Collections;
import java.util.Scanner;

public class SquareOfStars {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());

        String space = " ";

        for (int i = 1; i<=n; i++) {
            System.out.print("*");
        }

        System.out.println();

        for (int j = 1; j<=n-2; j++) {
            System.out.println("*" +String.join("", Collections.nCopies(n-2, space)) +"*");
        }

        for (int k = 1; k<=n; k++) {
            System.out.print("*");
        }

    }

}
