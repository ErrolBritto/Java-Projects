/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe618.lab1;

/**
 *
 * @author EB
 */
public abstract class Passenger {

    String name;
    int age;

    public Passenger(int a, String n) {
        name = n;
        age = a;

    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    abstract public double applyDiscount(double p);

}
