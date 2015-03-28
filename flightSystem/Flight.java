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
public class Flight {

   int flightNumber;
   String origin;
   String destination;
   String departureTime;
   int capacity;
   int numberOfSeatsleft;
   double originalPrice;

    public Flight(int fn, String o, String ds, String dp, int c, double op) {
        if (ds.equals(o) == true) {
            throw new IllegalArgumentException("Destination cannot be same as origin!");
        }
        flightNumber = fn;
        origin = o;
        destination = ds;
        departureTime = dp;
        capacity = c;
        numberOfSeatsleft = c;
        originalPrice = op;
    }

    public boolean bookASeat() {
        if (numberOfSeatsleft > 0) {
            numberOfSeatsleft--;
            return true;

        }
        return false;
    }

    public double getPrice() {
        return originalPrice;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public int getNumberOfSeatsleft() {
        return numberOfSeatsleft;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setPrice(double p) {
        originalPrice = p;
    }

    public void setOrigin(String o) {
        origin = o;
    }

    public void setDestination(String d) {
        destination = d;
    }

    public void setDepartureTime(String d) {
        departureTime = d;
    }

    public void setFlightNumber(int fn) {
        flightNumber = fn;
    }

    public void setNumberOfSeatsleft(int s) {
        numberOfSeatsleft = s;
    }

    public void setCapacity(int c) {
        capacity = c;
    }

    @Override
    public String toString() {
        return ("Flight" + flightNumber +  ", " + origin + " to " + destination + ", " + departureTime +", "+ "original price: " + originalPrice + "$");
    }

}
