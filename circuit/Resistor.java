/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coe318.lab6;

/**
 *
 * @author Errol Britto, 500529490
 */
public class Resistor {
    public double ohms;
    public Node X;
    public  Node Y;
    public int resistornum;
    public static int resist = 1;
    public Node [] nodenum;
    public Circuit circ1 = Circuit.gettrial();
public Resistor (double resistance, Node node1, Node node2){
    if (node1 == null || node2 == null){
        throw new IllegalArgumentException("Zero Resistance!!");
    }
   else
       if (node1 == node2){
    throw new IllegalArgumentException ("Nodes are the same!!");
} 
    else
       if (resistance < 0) {
        throw new IllegalArgumentException("Negative Resistance!!");
    }
    ohms = resistance;
    X = node1;
    Y = node2;
    circ1.addResistor(this);
    nodenum = new Node []{X, Y};
    resistornum = resist;
    resist++;
    
}
        
public Node [] getNodes() {
    return nodenum;
}
    @Override
    public String toString(){
    return "Resistor " + resistornum + " at node " + this.X.nodenum + " to " + this.Y.nodenum + " " + ohms;
}
}
