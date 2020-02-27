package io.zipcoder.casino.game;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Deck;
import io.zipcoder.casino.dealer.BlackjackDealer;
import io.zipcoder.casino.player.BlackjackPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;


public class Blackjack {
    private Deck deck = new Deck();
    private BlackjackPlayer player;
    private BlackjackDealer dealer;
    private Integer bet;
    private Boolean stay;
    private Boolean hit;
    Console console = new Console(System.in, System.out);
    private boolean stillPlaying;

    public Blackjack(BlackjackPlayer player, BlackjackDealer dealer) {
        this.player = player;
        this.dealer = dealer;
        this.bet = 0;
        this.hit = hit;
        this.stay = stay;
        this.deck = deck;
        deck.createDeck();
        deck.shuffle();
        setHandPlayer();
        setDealerPlayer();
        this.stillPlaying = true;
    }

    public Deck getDeck() {
        return deck;
    }

    public void createDeck() {
        this.deck.createDeck();
    }

    public void shuffleDeck() {
        this.deck.shuffle();
    }

    public void drawCardPlayer() {
        player.hit(deck.popCard());
    }

    public void drawCardDealer() {
        dealer.hit(deck.popCard());
    }

    public int getScorePlayer() {
        return player.getScore();
    }

    public int getScoreDealer() {
        return dealer.getScore();

    }

    public boolean bustPlayer() {
        if (getScorePlayer() > 21) {
            return true;
        }
        return false;
    }

    public boolean bustDealer() {
        if (getScoreDealer() > 21) {
            return true;
        }
        return false;
    }

    public void getWager() {
        if (player.getPlayer().getBalance() == 0) {
            // exit();
        }
        bet = console.getIntegerInput("How much do you want to wager?");
        while (bet > player.getPlayer().getBalance() || bet < 1) {
            bet = console.getIntegerInput("Enter a valid wager.");
        }
    }

    public void getWager(String prompt) {
        if (player.getPlayer().getBalance() == 0) {
            //exit();
        }
        bet = console.getIntegerInput(prompt);
        while (bet > player.getPlayer().getBalance() || bet < 0) {
            bet = console.getIntegerInput(prompt);
        }
    }

    public void placeBet() {
        player.getPlayer().setBalance(player.getPlayer().getBalance() - bet);
    }

    public void getWinnings(Integer amount) {
        player.getPlayer().setBalance(player.getPlayer().getBalance() + amount);
    }

    public void setHandPlayer() {
        player.getHand().add(deck.popCard());
        player.getHand().add(deck.popCard());
    }

    public ArrayList<Card> getHandPlayer() {
        return player.getHand();
    }

    public void setDealerPlayer() {
        dealer.getHand().add(deck.popCard());
        dealer.getHand().add(deck.popCard());
    }

    public String seeDealerCard() {
        return dealer.getHand().get(1).toString();
    }

    public void play() {
        while(stillPlaying) {
            console.println("Welcome to Blackjak.");
            getWager();
            placeBet();

            player.toString();
            player.getHand().toString();
        }


        }



    public void checkFirstHand() {
        if (this.dealer.checkBlackjack() && this.player.checkBlackjack()) {
            exit();
        }
        if (this.dealer.checkBlackjack() && !this.player.checkBlackjack()) {
            exit();
        }
        if (!this.dealer.checkBlackjack() && this.player.checkBlackjack()) {
                exit();

            }
        }
    }