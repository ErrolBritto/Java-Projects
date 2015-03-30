/**
* A Resistor models an ideal resistor that obeys Ohm's Law.
*
* @author Errol Britto
*/
package coe318.Lab1;
public class Resistor {
    double resist;
    double amps;
        //Instance (state) variables
//TODO Add instance variables (Hint: you only need 2!)
/**

* Create an ideal Resistor. The initial current through
and voltage across
* the Resistor are zero.
*
* @param resistance resistance in Ohms
*/
public Resistor(double resistance) {
    resist = resistance;
    //Set values of state variables
}
/**
* Returns the value of the resistor in Ohms.
*
* @return the resistance
*/
public double getResistance() {
    //FIX THIS so that it returns the actual resistance 
    return resist;
}



/** Returns the voltage across the resistor.
*
* @return the voltage
*/
public double getVoltage() {
//FIX THIS so that it returns the actual voltage
return amps * resist;
}
/**
* Sets the value of the voltage across the resistor.
*
* @param voltage the voltage to set
*/
public void setVoltage(double voltage) {
//FIX THIS
    amps = voltage/resist;
}
/**
* Returns the current through the Resistor.
*
* @return the current
*/
public double getCurrent() {
//FIX THIS
return amps;
}
/**
* Sets the value of the current through the resistor.
*
* @param current the current to set
*/
public void setCurrent(double current) {
//FIX THIS
 amps = current;
    }
/**
* Returns the power (in Watts) dissipated by the
Resistor.
*
* @return the power
*/
public double getPower() {
//FIX THIS
return amps*amps*resist;
}
/**
* A simple example of using a Resistor. <p> The output
should be:
* <pre>
* Creating a 50 Ohm resistor (r1)
coe318 Lab 1 (2013) Introduction to Netbeans and Java
Page 4 of 6 Version 2012.0
* Its resistance is 50.0 Ohms
* Its current is 0.0 Amps
* Its voltage is 0.0 Volts
* Its power is 0.0 Watts
* Creating a 100 Ohm resistor (r2)
* Its resistance is 100.0 Ohms
* Setting r1's current to 2 Amps
* Its current is 2.0 Amps
* Its voltage is 100.0 Volts
* Its power is 200.0 Watts
* Setting r1's voltage to 50 Volts
* Its current is 1.0 Amps
* Setting r2's current to 3 Amps
* Its voltage is 300.0 Volts
* </pre>
*
* @param args (Command line arguments not used.)
*/
public static void main(String[] args) {
Resistor r1, r2;
System.out.println("Creating a 50 Ohm resistor(r1)");
r1 = new Resistor(50.0);
System.out.println("Its resistance is "
+ r1.getResistance() + " Ohms");
System.out.println("Its current is "
+ r1.getCurrent() + " Amps");
System.out.println("Its voltage is "
+ r1.getVoltage() + " Volts");
System.out.println("Its power is "
+ r1.getPower() + " Watts");
System.out.println("Creating a 100 Ohm resistor(r2)");
r2 = new Resistor(100.0);
System.out.println("Its resistance is "
+ r2.getResistance() + " Ohms");
System.out.println("Setting r1's current to 2 Amps");
r1.setCurrent(2.0);
System.out.println("Its current is "
+ r1.getCurrent() + " Amps");
System.out.println("Its voltage is "
+ r1.getVoltage() + " Volts");
System.out.println("Its power is "
+ r1.getPower() + " Watts");
System.out.println("Setting r1's voltage to 50 Volts");
r1.setVoltage(50.0);
System.out.println("Its current is "
+ r1.getCurrent() + " Amps");
System.out.println("Setting r2's current to 3 Amps");
r2.setCurrent(3.0);
System.out.println("Its voltage is "
+ r2.getVoltage() + " Volts");
}
}


