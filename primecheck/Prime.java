/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EB
 */
import java.util.*;

public class Prime {

    int i;

    public void Prime() {

    }

    public static boolean isPrime(int num) {
         //REQUIRES: num is an integer
        //EFFECTS: returns true if num is a prime number, and false if it is not.

        for (int i = 2; i * i <= (num); i++) {
            if ((num % i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    //REQUIRES: a is an integer read by System.in
   //EFFECTS: Checks boolean return value of isPrime(a); prints "prime" if true, and "Not a prime" if false

        int a;
        boolean check;

        Scanner scan1 = new Scanner(System.in);
        
        System.out.println("Please enter an integer: ");
        a = scan1.nextInt();

        check = isPrime(a);

        if (check == true) 
            System.out.println("prime");
         else 
            System.out.println("Not a prime");
        

    }
}
