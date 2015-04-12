/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker5;

/**
 *
 * @author EB
 * @author Marc
 * 
 */
public class Card {
    int suit; //1=hearts, 2=diamonds, 3=clubs, 4=spades
    int value;//2=2......11=jack,12=Queen,13=king,Ace=14
    public Card(int suit, int value){
        this.suit=suit;
        this.value=value;
    }
    
}
