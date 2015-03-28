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
public class DigitCounter extends AbstractCounter {

    public DigitCounter() {
        super();
    }

    @Override
    public void increment() {
        if (value < 9) {
            value++;
        } else {
            value = 0;
        }

    }

    @Override
    public void decrement() {
        if (value > 0) {
            value--;
        } else {
            value = 9;
        }

    }

    @Override
    public void reset() {
        value = 0;
    }

    @Override
    public String count() {
        return "" + value;
    }
}
