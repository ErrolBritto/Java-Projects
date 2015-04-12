/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker5;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author EB
 * @author Marc
 * 
 */
public class Deck {

    ArrayList<Card> cards;
    Random draw;

    public Deck() {
        cards = new ArrayList();
        draw = new Random();
    }

    public void generateDeck() {
        cards.clear();
        for (int i = 1; i < 5; i++) {
            for (int j = 2; j < 15; j++) {
                Card card1 = new Card(i, j);
                cards.add(card1);
            }
        }
    }

    public Card[] drawHand() {
        int size, j;
        Card[] five = new Card[5];
        for (int i = 0; i < 5; i++) {
            size = cards.size();
            j = draw.nextInt(size);
            five[i] = cards.get(j);
            cards.remove(j);
        }
        return five;

    }

    public void swapCards(Card[] hand, int[] swap) {
        int size, j;
        for (int i = 0; i < 5; i++) {
            if (swap[i] == 1) {
                size = cards.size();
                j = draw.nextInt(size);
                hand[i] = cards.get(j);
                cards.remove(j);

            }
        }

    }

}
