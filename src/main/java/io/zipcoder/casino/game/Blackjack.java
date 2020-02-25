package io.zipcoder.casino.game;

import io.zipcoder.casino.card.Deck;
import io.zipcoder.casino.dealer.BlackjackDealer;
import io.zipcoder.casino.player.BlackjackPlayer;
import io.zipcoder.casino.player.Player;

public class Blackjack {
 private Player playerOne;
 private Deck cardDeck;

    public Blackjack(BlackjackPlayer player, BlackjackDealer dealer){
        this.playerOne = player;
    }
}
