package io.zipcoder.casino.player;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Hand;

import java.util.ArrayList;

public class GoFishPlayer {


    private Player player;
    private Integer playerScore = 0;
    private Hand hand = new Hand();
    private ArrayList<Card> removeHolder = new ArrayList<>();

    public GoFishPlayer(Player newPlayer) {
        this.player = newPlayer;
    }


    public void drawCard(Card c) {
        hand.add(c);
    }


    public ArrayList<Card> getPlayerHand() {
        return hand.getHand();
    }


    public Player getPlayer() {
        return player;

    }

    public Integer addBookToPlayer() {
        return playerScore++;
    }

    public Integer getPlayerScore() {
        return playerScore;
    }

    public void removeBook(){
        hand.getHand().removeAll(removeHolder);
    }

    public String printPlayerScore() {
        return "Score: " + playerScore;
    }

    public void addBook() {
        Integer tempCount = 0;
        Integer tempRank = hand.getHand().get(0).getRank();
        for (int i = 1; i < hand.getSize(); i++) {
            if (!tempRank.equals(hand.getHand().get(i).getRank())){
                tempRank = hand.getHand().get(i).getRank();
                tempCount = 0;
            }
            else if (tempRank.equals(hand.getHand().get(i).getRank())){
                tempCount += 1;
                if (tempCount == 3){
                    removeHolder.add(hand.getHand().get(i));
                    removeHolder.add(hand.getHand().get(i - 1));
                    removeHolder.add(hand.getHand().get(i - 2));
                    removeHolder.add(hand.getHand().get(i - 3));
                    tempCount = 0;
                    addBookToPlayer();
                }
            }
        }
        removeBook();
    }

}
