/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.Scanner;

/**
 *
 * @author EB
 */
public class OdometerTUIStart {

    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        int number;
        boolean check = true;
        String choice, result;
        int length = 9;
        LinkedDigitCounter Odometer = new LinkedDigitCounter(null);    createOdometer(Odometer, length); 
        while (check == true) {
            System.out.println("Enter i to increment Odometer");
            System.out.println("Enter d to decrement Odometer");
            System.out.println("Enter r to reset Odometer");
            System.out.println("Enter e to exit");
            choice = scan1.nextLine();
            switch (choice) {
                case "i":
                    System.out.println("By how much would you like to increment the Odometer?");
                    number = scan2.nextInt();
                    for (int i = 0; i < number; i++) {
                        Odometer.increment();
                        result = Odometer.count();
                        System.out.println(result);

                    }
                    break;
                case "d":
                    System.out.println("By how much would you like to decrement the Odometer?");
                    number = scan2.nextInt();
                    for (int i = 0; i < number; i++) {
                        Odometer.decrement();
                        result = Odometer.count();
                        System.out.println(result);
                    }
                    break;
                case "r":
                    Odometer.reset();
                    result = Odometer.count();
                    System.out.println(result);
                    break;
                case "e":
                    check = false;
                    break;

            }
        }

    }

    public static void createOdometer(LinkedDigitCounter a, int size) {

        if (size == 2) {
            DigitCounter b = new DigitCounter();
            a.left = b;
        } else {
            a.left = new LinkedDigitCounter(null);
            createOdometer((LinkedDigitCounter) a.left, size - 1);
        }

    }

}
