package io.zipcoder.casino.player;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Hand;

public class BlackjackPlayer{
    private Hand hand = new Hand();
    private Player player;

    public BlackjackPlayer(Player player){
        this.player = player;
    }
    public void hit(Card c){
        hand.add(c);
    }

    public Player getPlayer(){
        return this.player;
    }

}
