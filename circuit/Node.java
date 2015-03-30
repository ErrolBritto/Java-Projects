/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coe318.lab6;


/**
 *
 * @author Errol Britto, 500529490
 */
public class Node {
    public static int node = 0;
    public int nodenum;
    
public Node (){
nodenum = node;
node++;
}
    
    @Override
    public String toString(){
    return "This node is :" + nodenum;
}
}
