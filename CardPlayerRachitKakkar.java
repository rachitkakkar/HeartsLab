/*
/    Authors:
/     Rachit Kakkar!!!
*/
import java.util.*;    // required to use ArrayList

public class CardPlayerRachitKakkar extends CardPlayer {
  public CardPlayerRachitKakkar(String name, int score, ArrayList<Card> hand) {
    super(name, score, hand);
  }

  public Card chooseCard(ArrayList<Card> round, ArrayList<Card> previousRounds) {
    if (getHand().contains(new Card("2", "clubs", 2))) {
      return playCard(getHand().indexOf(new Card("2", "clubs", 2)));
    }

    if (round.size() == 0) { // First player
      int index = (int)(Math.random() * getHand().size());
      return playCard(index); 
    }

    else { // Not first player
      for (Card c : round) {
        if (c.equals(new Card("K", "spades", 13)) || c.equals(new Card("A", "spades", 1))) { // If round has king of spades or ace, and player has queen of spades, play it
          if (getHand().contains(new Card("Q", "spades", 12))) {
            return playCard(getHand().indexOf(new Card("Q", "spades", 12)));
          }
        }
      }

      if (round.get(0).getSuit() == "hearts") {
        ArrayList<Card> hearts = new ArrayList<Card>();
        for (Card c : getHand()) {
          if (c.getSuit() == "hearts") {
            hearts.add(c);
          }
        }

        if (hearts.size() > 0) {
          Card highestHeart = new Card();
          for  (Card c : round) {
            if (c.getSuit() == "hearts") {
              if (c.compareTo(highestHeart) == 1) {
                highestHeart = c;
              }
            }
          }
      
          Card chosenCard = null;
          for (Card c : getHand()) {
            if (chosenCard == null) {
              chosenCard = c;
            }
            
            if (c.compareTo(highestHeart) == -1 && c.compareTo(chosenCard) == 1) {
              chosenCard = c;
            }
          }
  
          return playCard(getHand().indexOf(chosenCard));
          }
      }
      
      else {
        boolean hasHearts = false;
        ArrayList<Card> otherCards = new ArrayList<Card>();
        for (Card c : round) {
          if (c.getSuit() == "hearts") {
            hasHearts = true;
          }

          else {
            otherCards.add(c);
          }
        }

        if (otherCards.size() > 0) {
          if (round.contains(new Card("Q", "spades", 12)) || hasHearts) {
            Card highestCard = new Card();
            for (Card c : otherCards) {
              if (c.getSuit() == round.get(0).getSuit()) {
                if (c.compareTo(highestCard) == 1) {
                  highestCard = c;
                }
              }
            }

            Card chosenCard = null;
            for (Card c : getHand()) {
              if (chosenCard == null) {
                chosenCard = c;
              }
              
              if (c.compareTo(highestCard) == -1 && c.compareTo(chosenCard) == 1) {
                chosenCard = c;
              }
            }
    
            return playCard(getHand().indexOf(chosenCard));
        }
      }
    }

      ArrayList<Card> matchingSuit = new ArrayList<Card>();
      for (Card c : getHand()) {
        if (c.getSuit() == round.get(0).getSuit()) {
          matchingSuit.add(c);
        }
      }

      if (matchingSuit.size() > 0) {
        int index = (int)(Math.random() * matchingSuit.size());
        return playCard(getHand().indexOf(matchingSuit.get(index))); // Play random card of suit
      }

      else { // Does not have suit
        if (getHand().contains(new Card("Q", "spades", 12))) {// If hand has queen of spades, play it
          return playCard(getHand().indexOf(new Card("Q", "spades", 12)));
        }
        
        ArrayList<Card> hearts = new ArrayList<Card>();
        for (Card c : getHand()) {
          if (c.getSuit() == "hearts") {
            hearts.add(c);
          }
        }

        // Find highest heart
        if (hearts.size() > 0) {
          Card highestHeart = null;
          for (Card c : hearts) {
            if (highestHeart == null) {
              highestHeart = c;
            }
  
            else {
              if (c.compareTo(highestHeart) == 1) {
                highestHeart = c;
              }
            }
          }

          return playCard(getHand().indexOf(highestHeart));
        }

        else { // No hearts, play random card
          int index = (int)(Math.random() * getHand().size());
          return playCard(index);
        }
      }
    }
  }
}