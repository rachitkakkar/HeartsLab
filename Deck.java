/*
/    Authors:
/     Rachit Kakkar!!!
*/

import java.util.ArrayList;
import java.util.*;

public class Deck {
  private ArrayList<Card> deck;
  public static final String[] NAMES = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
  public static final String[] SUITS = {"clubs", "spades", "hearts", "diamonds"};
  public static final int[] RANKS = {2,3,4,5,6,7,8,9,10,11,12,13,14};

  public Deck() {
    initializeDeck();
  }

  public void initializeDeck() {
    deck = new ArrayList<Card>();

    for (String suit : SUITS) {
      for (int i = 0; i < RANKS.length; i++) {
        deck.add(new Card(NAMES[i], suit, RANKS[i]));
      }
    }
  }

  public ArrayList<Card> getDeck() {
    return deck;
  }

  public void setDeck(ArrayList<Card> newDeck) {
    deck = newDeck;
  }

  public Card getCard(int index) {
    return deck.get(index);
  }

  public Card dealTopCard() {
    Card topCard = getCard(0);
    deck.remove(0);
    return topCard;
  }

  public void shuffle() {
    /*
    int cardNum = (int)Math.floor(Math.random()*(10-2+1)+2);
    ArrayList<Card> toInsert = new ArrayList<Card>();

    for (int i = cardNum; i < 0; i--) {
      toInsert.add(getCard(i));
      deck.remove(i);
    }

    int insertLoc = (int)Math.floor(Math.random()*(deck.size()));
    deck.addAll(insertLoc, toInsert);
    */

    Collections.shuffle(deck, new Random());
  }

  public String toString() {
    if (deck.size() == 0) {
      return "No cards in the deck!";
    }

    String output = "";

    for (Card c : deck) {
      output += (c.toString() + " ");
    }

    return output;
  }
}