package io.zipcoder.casino.player;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Hand;

import java.util.ArrayList;

public class GoFishPlayer {
    private Player player;
    private Integer playerScore = 0;
    private Hand hand = new Hand();

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

}
