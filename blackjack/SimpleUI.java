/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coe318.lab5;

/**
 *
 * @author Errol Britto, 500529490
 */
import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);
    private String s;

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
      
            System.out.println("House is holding: " + game.houseCards.getCards() + "\n");
            
            System.out.println("You are holding: " + game.yourCards.getCards() + "\n");
        
    }

  @Override
    public boolean hitMe() {
        System.out.println("Would you like another card (y/n)?");
        s = user.nextLine();
        if (s.equals("y")){
            return true;
        }
        else
        return false;
    }

  @Override
    public void gameOver() 
  {
      System.out.println ("Game Over!" + "\n");
        System.out.println("House is holding: " + game.houseCards.getCards() + "\n");
            System.out.println("You are holding: " + game.yourCards.getCards() + "\n");
       System.out.println ("Your score is :" + game.score(game.getYourCards()) + "\n");
       System.out.println ("House score is: " + game.score(game.getHouseCards()) + "\n");
       if (game.score(game.getYourCards()) > 21 || game.score(game.getHouseCards()) == game.score(game.getYourCards()) )
       {
                 System.out.println ("You lose!" + "\n");

       }
       
     else if (game.score(game.getHouseCards()) > 21 && game.score(game.getYourCards()) <= 21 || game.score(game.getHouseCards()) <= 21 && game.score(game.getYourCards()) <= 21 && game.score(game.getHouseCards()) < game.score(game.getYourCards()) )
       {
                 System.out.println ("You Win!" + "\n");
        }
 
  }
