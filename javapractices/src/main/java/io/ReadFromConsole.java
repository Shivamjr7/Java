package io;

import java.util.Scanner;

public class ReadFromConsole {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name :");
        String name = scanner.next();

        System.out.println("Please enter your age :");
        int age = scanner.nextInt();

        System.out.println("Name  "+ name +" age : "+ age);

    }


}
