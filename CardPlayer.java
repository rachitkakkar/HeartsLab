/*
/    Authors:
/     Rachit Kakkar!!!
*/

import java.util.*;    // required to use ArrayList

public class CardPlayer extends Player {
  private ArrayList<Card> hand;
  private ArrayList<Card> takenCards;

  public CardPlayer(String name, int score, ArrayList<Card> hand) {
    super(name, score);
    this.hand = hand;
    takenCards = new ArrayList<Card>();
  }

  public ArrayList<Card> getHand() {
    return hand;
  }

  public ArrayList<Card> getTakenCards() {
    return takenCards;
  }

  public void setHand(ArrayList<Card> hand) {
    this.hand = hand;
  }

  public void setTakenCards(ArrayList<Card> takenCards) {
    this.takenCards = takenCards;
  }

  public void addCard(Card card) {
    hand.add(card);
  }

  public Card playCard(int index) {
    Card selectedCard = hand.get(index);
    hand.remove(index);
    return selectedCard;
  }

  public Card chooseCard(ArrayList<Card> round, ArrayList<Card> previousRounds) {
    if (hand.contains(new Card("2", "clubs", 2))) {
      return playCard(hand.indexOf(new Card("2", "clubs", 2)));
    }

    if (round.size() == 0) { // First player
      int index = (int)(Math.random() * hand.size());
      return playCard(index); 
    }

    else { // Not first player
      ArrayList<Card> matchingSuit = new ArrayList<Card>();
      for (Card c : hand) {
        if (c.getSuit() == round.get(0).getSuit()) {
          matchingSuit.add(c);
        }
      }

      if (matchingSuit.size() > 0) {
        int index = (int)(Math.random() * matchingSuit.size());
        return playCard(hand.indexOf(matchingSuit.get(index)));
      }

      else {
        ArrayList<Card> hearts = new ArrayList<Card>();
        for (Card c : hand) {
          if (c.getSuit() == "hearts") {
            hearts.add(c);
          }
        }

        if (hearts.size() > 0) {
          int index = (int)(Math.random() * hearts.size());
          return playCard(hand.indexOf(hearts.get(index)));
        }

        else {
          int index = (int)(Math.random() * hand.size());
          return playCard(index); 
        }
      }
    }
  }
}