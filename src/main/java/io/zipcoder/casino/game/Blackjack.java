package io.zipcoder.casino.game;

import io.zipcoder.casino.card.Deck;
import io.zipcoder.casino.dealer.BlackjackDealer;
import io.zipcoder.casino.player.BlackjackPlayer;
import io.zipcoder.casino.utilities.Console;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class Blackjack {

    private Deck deck = new Deck();
    private BlackjackPlayer player;
    private BlackjackDealer dealer;
    Console console = new Console(System.in, System.out);

    public Blackjack(BlackjackPlayer player, BlackjackDealer dealer){

    }
}
