/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coe318.lab5;

/**
 *
 * @author jsumajit
 */
public class Card implements Comparable{
  //Symbolic constants

  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;

  /**
   * Construct a card of the given rank, suit and whether it is faceup or
   * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
   * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
   * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
   * Clubs, Diamonds, Hearts and Spades respectively.
   *
   * @param rank
   * @param suit
   * @param faceUp
   */
  int rankCard, suitCard;
  boolean faceCard;
  public Card(int rank, int suit, boolean faceUp) {
    //FIX THIS
      rankCard = rank;
      suitCard = suit;
      faceCard = faceUp;
  }

  /**
   * @return the faceUp
   */
  public boolean isFaceUp() {
    return faceCard; //FIX THIS
  }

  /**
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) {
    //FIX THIS
      faceCard = faceUp;
  }

  /**
   * @return the rank
   */
  public int getRank() {
    return rankCard; //FIX THIS
  }

  /**
   * @return the suit
   */
  public int getSuit() {
    return suitCard;//FIX THIS
  }

  @Override
  public boolean equals(Object ob) {
    if (!(ob instanceof Card)) {
      return false;
    }
    Card c = (Card) ob;
    //FIX THIS
    if (c.suitCard == suitCard && c.rankCard == rankCard) {
          return true;
      }
    else {
          return false;
      }
  }

  @Override
  public int hashCode() {//DO NOT MODIFY
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {//DO NOT MODIFY
    return compareTo((Card) obj);
  }

  public int compareTo(Card c) {
      if(suitCard == c.suitCard) {
          if(rankCard<c.rankCard) {
              return -1;
          }
          else if(rankCard>c.rankCard) {
              return 1;
          }
          else {
              return 0;
          }
      }
      else
      {
          if(suitCard < c.suitCard) {
              return -1;
          }
          else if(suitCard > c.suitCard) {
              return 1;
          }
          else {
              return 0;
          }
      }

  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  public String getRankString() {
      //FIX THIS
      if (rankCard <= 10 && rankCard >= 2) {
          return ""+ this.rankCard;
      }
      else if (rankCard == 11) {
          return "Jack";
      }
      else if (rankCard == 12) {
          return "Queen";
      }
      else if (rankCard == 13) {
          return "King";
      }
      else {
          return "Ace";
      }
  }

  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  public String getSuitString() {
      //FIX THIS
       if (suitCard == 0) {
          return "Clubs";
      } //FIX THIS
       else if (suitCard == 1) {
          return "Diamonds";
      }
       else if (suitCard == 2) {
          return "Hearts";
      }
       else if (suitCard == 3) {
          return "Spades";
      }
       else {
          return "";
      }
  }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
  public String toString() {
      if(faceCard == true){
          if(this.getRank() >= 2 && this.getRank() <= 10){
              return "Face up" + ", " + this.getRankString() + " of " + this.getSuitString();
          }
          return "Face down" + ", " + this.getRankString() + " of " + this.getSuitString();
      }
      return "";
  }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: " + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: " + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: " + club5.equals(spadeAce));
    System.out.println("club5 equals club5: " + club5.equals(club5));
  }
}
