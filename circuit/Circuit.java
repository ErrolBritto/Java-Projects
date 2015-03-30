/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coe318.lab6;
import java.util.ArrayList;
/**
 *
 * @author Errol Britto, 500529490
 */
public class Circuit {
private static Circuit trial = null;
public static Circuit gettrial() {
if (trial == null) {
trial = new Circuit();
}
return trial;
}
private ArrayList<Resistor> resistorlist;

private Circuit() {
    resistorlist = new ArrayList<Resistor>();
}

public void addResistor(Resistor R){
   resistorlist.add(R);    
}
@Override
public String toString (){
    String resistors = "";

    for (int i = 0; i < resistorlist.size(); i++){
    resistors = resistors + resistorlist.get(i) + "\n";
    }
    return resistors;
    
}
 
}
