/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.exercise2;

/**
 *
 * @author EB
 */
public class CharStack {

    /**
     * Implementation of a first in, last-out stack. *
     */
    // Abstraction function: for n elements in a stack, rep = c1, c2, ... cn. The top of the stack is n-1
    // Rep Invariant: -1 <= topOfStack < stackArray.length and stackArray != null. 
// Instance variables
    private char[] stackArray;// The array implementing the stack. 
    private int topOfStack; // The top of the stack.

// Static variable
    private static int counter;

    //Constructor now increments the counter for each object created.
    public CharStack(int capacity) {
        stackArray = new char[capacity];
        topOfStack = -1;
        counter++;
        RepOK();
    }

    // Instance methods 
    public void push(char element) {
        stackArray[++topOfStack] = element;
        RepOK();
    }

    public char pop() {
        RepOK();
        return stackArray[topOfStack--];
    }

    public char peek() {
        return stackArray[topOfStack];
    }

    public boolean isEmpty() {
        return topOfStack < 0;
    }

    public boolean isFull() {
        return topOfStack == stackArray.length - 1;
    }

    public boolean RepOK() {
        // EFFECTS: Returns true if the rep invariant holds for this; 
        //otherwise returns false

        if (this.stackArray == null) {
            return false;
        }
        if (stackArray.length <= topOfStack) {
            return false;
        }
        if (topOfStack < -1) {
            return false;
        }
        return true;
    }
}
