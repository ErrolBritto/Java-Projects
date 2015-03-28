/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.exercise1;

import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author EB
 *
 */
public class IntSets {
    //OVERVIEW: IntSets are unbounded, mutable sets of integers.

    //The abstraction function is
    //  AF(c) = c.els[i].intValue; where 0 <= i < c.els.size}
    //The representation invariant is 
    //  c.els != null and all the elements of c.els are of type Integer.
    // Additionally, for c.els[i].intValue < c.els[j].intValue for integers i and j.
    private Vector<Integer> els;

    public IntSets() {
        //EFFECTS: Creates a new Vector<Integer>.
        els = new Vector<Integer>();
        repOk();
    }

    public void insert(int x) {
        //MODIFIES: els
        //EFFECTS: Adds an integer x to vector and sorts this.
        Integer y = new Integer(x);
        if (getIndex(y) < 0) {
            els.add(y);
            Collections.sort(this.els);
        }
        repOk();
    }

    public void remove(int x) {
        //MODIFIES: els
        //EFFECTS: Removes x from vector and sorts this.
        int i = getIndex(new Integer(x));
        if (i < 0) {
            return;
        }
        els.set(i, els.lastElement());
        els.remove(els.size() - 1);
        Collections.sort(this.els);
        repOk();
    }

    public boolean isIn(int x) {
        //EFFECTS: Searches the vector for element x and returns true if it is there, and false if not.

        return getIndex(new Integer(x)) >= 0;
    }

    private int getIndex(Integer x) {
        //EFFECTS: Returns index of x if it is in vector, returns -1 otherwise.

        for (int i = 0; i < els.size(); i++) {
            if (x.equals(els.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        //EFFECTS: Returns the size of the vector.

        return els.size();
    }

    public int choose() throws EmptyException {
        //EFFECTS: If the vector is empty (els.size==0) throws new exception. 
        //If not, choose function is used to randomly return an element of vector.

        if (els.size() == 0) {
            throw new EmptyException("IntSet.choose");
        }
        return els.lastElement();
    }

    public boolean repOk() {
        //EFFECTS:(1.) Ensures that vector is not empty (returns false if it is)
        //        (2.)Checks that elements of vector are of type integer.
        //        (3.)Checks that elements of vector are sorted in an increasing order.

        if (els == null) {
            return false;
        }

        for (int i = 0; i < els.size(); i++) {
            Object x = els.get(i);
            if (!(x instanceof Integer)) {
                return false;
            }
            for (int j = i + 1; j < els.size(); j++) {
                if (x.equals(els.get(j))) {
                    return false;
                }
            }
        }

        for (int i = 0; i < els.size(); i++) {
            for (int j = i + 1; j < els.size(); j++) {
                if (els.elementAt(i) > els.elementAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        //EFFECTS: Overrides the default toString() method.

        String s;
        if (els.size() == 0) {
            return "IntSet: {null}";
        } else {
            s = "IntSet: {" + els.elementAt(0).toString();
            for (int i = 1; i < els.size(); i++) {
                s = s + " , " + els.elementAt(i).toString();
            }
            return s + "}";
        }
    }

    private static class EmptyException extends Exception {

        public EmptyException() {
        }

        private EmptyException(String intSetchoose) {
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }
}
