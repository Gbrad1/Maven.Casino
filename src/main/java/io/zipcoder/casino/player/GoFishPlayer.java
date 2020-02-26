package io.zipcoder.casino.player;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Hand;

public class GoFishPlayer extends CardPlayer {

    private Hand hand = new Hand();




    @Override
    public void playerTurn() {


    }
    @Override
    public void drawCard(Card card) {
        hand.add(card);
    }
}
