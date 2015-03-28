/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author EB
 */
public class LinkedDigitCounter extends AbstractCounter {

    Counter left;

    public LinkedDigitCounter(Counter a) {
        super();
        left = a;
    }

    @Override
    public void increment() {

        if (value < 9) {
            value++;
        } else {
            value = 0;
            this.left.increment();

        }
    }

    @Override
    public void decrement() {
        if (value > 0) {
            value--;
        } else {
            value = 9;
            this.left.decrement();

        }
    }

    @Override
    public void reset() {
        value = 0;
        this.left.reset();
    }

    @Override
    public String count() {
        return this.left.count() + value;
    }

}
