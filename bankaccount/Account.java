/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coe318.lab4;

/**
 *
 * @author Errol Britto, 500529490
 */
public class Account {
    public String acname;
    public int idnum;
    public double bal;
    
    
public Account (String name, int number, double initialBalance) {
acname = name;
idnum = number;
bal = initialBalance;
}

public String getName(){
 
    return acname;
}

public double getBalance() {
    
    return bal;
}

public int getNumber (){
    
    return idnum;
}

public boolean deposit (double amount){
  if (amount > 0){
      bal = bal + amount;
      return true;
  }
  else{
        return false;
  }
}

public boolean withdraw (double amount){
    if (amount > bal || amount < 0) {
        return false;
    }
    else {
        bal = bal - amount;
        return true;
    }
}


@Override
public String toString() {//DO NOT MODIFY
return ("(" + getName() + ", " + getNumber() + ", " + String.format("$%.2f", getBalance()) + ")"); 
}
}