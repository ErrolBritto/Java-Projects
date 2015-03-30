
/*author Errol Britto, 500529490*/  
package coe318.lab3;

public class Counter {
    //Instance variables here

    public int counte;
    public int modulu;
    Counter a;
    public int acount, totalcount;

    public Counter(int modulus, Counter left) {
        counte = 0;
        modulu = modulus;
        a = left;
    }

    /**
     * @return the modulus
     */
    public int getModulus() {
        return modulu;
    }

    /**
     * Returns the Counter to the left attached to this Counter. Returns null if
     * there is no Counter to the left.
     *
     * @return the left
     */
    public Counter getLeft() {
        return a;

    }

    /**
     * @return the digit
     */
    public int getDigit() {
        return counte;
    }

    /**
     * @param digit the digit to set
     */
    public void setDigit(int digit) {
        counte = digit;
    }

    /**
     * Increment this counter. If it rolls over, its left Counter is also
     * incremented if it exists.
     */
    public void increment() {
        counte++;
        if (counte == modulu) {
            counte = 0;
            if (a != null) {
                a.increment();
            }
        }



    }

    /**
     * Return the count of this Counter combined with any Counter to its left.
     *
     * @return the count
     */
    public int getCount() {
        
        if (a != null) {
            acount = a.getCount();
            totalcount = counte + (modulu * acount);
        } else  {
            totalcount = counte;
        }
        return totalcount;

    }

    /**
     * Returns a String representation of the Counter's total count (including
     * its left neighbour).
     *
     * @return the String representation
     */
    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        return "" + getCount();
    }
}