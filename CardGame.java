/*
/    Authors:
/        J. Dollinger
/        R. Kakkar
*/
import java.util.*;

public class CardGame{
  private Deck deckOfCards;
  private String nameOfGame;
  private ArrayList<CardPlayer> players;
  private int numberOfPlayers;
  private int currentPlayer;

  public CardGame(String name, int playercount, String[] names, int cPlayer){
    players = new ArrayList<CardPlayer>();
    nameOfGame = name;
    numberOfPlayers = playercount;
    currentPlayer = cPlayer;

    // Two CardPlayerLevel1s
    players.add(new CardPlayerLevel1(names[0], 0, new ArrayList<Card>()));
    players.add(new CardPlayerLevel1(names[1], 0, new ArrayList<Card>()));

    // Two CardPlayerBot2s
    players.add(new CardPlayerBot2(names[2], 0, new ArrayList<Card>()));
    players.add(new CardPlayerBot2(names[3], 0, new ArrayList<Card>()));
    
    deckOfCards = new Deck();
  }

  public void setDeckOfCards(Deck d){
    deckOfCards = d;
  }
  public Deck getDeckOfCards(){
    return deckOfCards;
  }

  public void setNameOfGame(String s){
    nameOfGame = s;
  }
  public String getNameOfGame(String s){
    return nameOfGame;
  }

  public void setNumberOfPlayers(int i){
    numberOfPlayers = i;
  }
  public int getNumberOfPlayers(){
    return numberOfPlayers;
  }

  public void setPlayers(ArrayList<CardPlayer> c){
    players = c;
  }
  public ArrayList<CardPlayer> getPlayers(){
    return players;
  }

  public CardPlayer getPlayer(int i){
    return players.get(i);
  }

  public void setCurrentPlayer(int i){
    currentPlayer = i;
  }
  public int getCurrentPlayer(){
    return currentPlayer;
  }

  public void deal(int numCards, int index) {
    for (int i = 0; i < numCards; i++) {
      getPlayer(index).addCard(deckOfCards.dealTopCard());
    }
  }

  public void playGame() {
    for (int i = 0; i < players.size(); i++) {
      CardPlayer player = players.get(i);
      if (player.getHand().contains(new Card("2", "clubs",2))) {
        setCurrentPlayer(i);
      }
    }
    
    ArrayList<Card> playedGame = new ArrayList<Card>();
    int playerOrder = currentPlayer;
    // Game
    for(int x = 1; x <=13; x++) {
      // Round
      ArrayList<Card> playedRound = new ArrayList<Card>();
      ArrayList<Integer> playerOrdered = new ArrayList<Integer>();
      CardPlayer lostPlayer = new CardPlayer("", 0, new ArrayList<Card>());

      for (int i = 0; i < numberOfPlayers; i++) {
        if (playerOrder >= numberOfPlayers) {
          playerOrder = 0;
        }
        Card chosenCard = players.get(playerOrder).chooseCard(playedRound, playedGame);
        playedRound.add(chosenCard);
        playerOrdered.add(playerOrder);
        playerOrder++;
      }
      playedGame.addAll(playedRound);

      Card c = playedRound.get(0);
      int indexOfHighest = 0;
      for(int i = 0; i < numberOfPlayers; i++) {
        Card current = playedRound.get(i);
        
        if (current.compareTo(c) == 1 && current.getSuit() == playedRound.get(0).getSuit()) {
          c = current;
          indexOfHighest = i;
        }
      }

      setCurrentPlayer(playerOrdered.get(indexOfHighest));
      players.get(currentPlayer).setTakenCards(playedRound);
      lostPlayer = players.get(currentPlayer);
    
      for (Card c2 : lostPlayer.getTakenCards()) {
        if (c2.getSuit() == "hearts") {
          lostPlayer.updateScore(1); 
        }
  
        else if (c2.getSuit() == "spades" && c2.getName() == "Q") {
          lostPlayer.updateScore(13);
        }
      }
    }
  }

  public String toString() {
    String playerText = "";
    for (CardPlayer player : players) {
      playerText += (player.getName() + " (" + player.getScore() + ") " + player.getHand() + "\n");
    }

    return ("***" + nameOfGame + "***\n" 
            + playerText 
            + "deck -> " + deckOfCards);
  } 
}