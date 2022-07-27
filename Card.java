/*
/    Authors:
/     Rachit Kakkar!!!
*/

public class Card implements Comparable<Object> {
  /**
  * Set instance variables as follows;
  *   variable "name" of type string
  *   variable suit of type string
  *   variable "value" of type primitive integer
  * Note: use the correct access specifier
  */
  private String name;    // example with "name" instance variable
  private String suit;
  private int value;
   
  /**
  * Card Constuctor - default
  * Creates a default card object with;
  *   name set to "default"
  *   suit set to "default"
  *   value set to 0
  * @param none
  */

  // ** Your code here **
  public Card() {
    name = "default";
    suit = "default";
    value = 0;
  }

  /**
  * Card Constuctor - initializing
  * Creates a default card object with;
  *   name set to "default"
  *   suit set to "default"
  *   value set to 0
  * @param  name a string with name of card
  * @param  suit a string with name of suit
  * @param  value an integer with the value of the card
  */

  // ** Your code here **
  public Card(String name, String suit, int rank) {
    this.name = name;
    this.suit = suit;
    value = rank;
  }

  /**
  * Accessor Methods for each instance variable
  */

  // ** Your code here **
  public String getName() {
    return name;
  }

  public String getSuit() {
    return suit;
  }

  public int getValue() {
    return value;
  }

  /**
  * Mutator Methods for each instance variable
  */

  // ** Your code here **
  public void setName(String newName) {
    name = newName;
  }

  public void setSuit(String newSuit) {
    suit = newSuit;
  }

  public void setValue(int newRank) {
    value = newRank;
  }

  /**
  * sortRank - Helper function to give rank of card, weighted
  *            by suit. 
  *                diamonds 0-12, hearts 13-25, 
  *                spades 26 - 38, clubs 39 - 51
  *  So you simply need to add a wight to value of this card object
  *                diamonds: value + 0
  *                hearts: value + 13
  *                spades: value + 26
  *                clubs: value + 39
  */



  public int sortRank() {     // ** You have to fix this method declaration
  // ** Your code here **
    int rank = 0;
    switch (suit) {
      case "diamonds":
        rank = value;
        break;
      case "hearts":
        rank = value + 13;
        break;
      case "spades":
        rank = value + 26;
        break;
      case "clubs":
        rank = value + 39;
        break;
    }

    return rank;
  }


  /**
  * compareTo - Override the compareTo() method default
  * 
  */

  public int compareTo(Object obj)  {     // ** You have to fix this method declaration
    Card c = (Card) obj;
    // ** Your code here **
    if (value ==  c.getValue())
      return 0;

    else if (value > c.getValue())
      return 1;

    else
      return -1;
  }


  /**
  * equals - Override the equals() method default
  *  for indexOf() to work on an array of cards we 
  *   need to define what it means for two cards to 
  *   be equal.  We use indexOf() to find the 2 of 
  *   clubs in the CardGame class.
  */
   
  // ** Your code here **
  public boolean equals(Object obj) {
    Card c = (Card) obj;
    return (name == c.getName() && sortRank() == c.sortRank());
  }


  /**
  * toString - Override the toString method default
  * 
  */
  // ** Your code here **
  public String toString() {
    return (suit.substring(0, 1) + name.substring(0, 1) + "(" + Integer.toString(value) + ")");
  }
}