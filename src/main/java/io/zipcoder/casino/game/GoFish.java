package io.zipcoder.casino.game;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Deck;
import io.zipcoder.casino.dealer.GoFishDealer;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

import java.sql.SQLOutput;

public class GoFish {
    private Deck deck = new Deck();
    private GoFishPlayer goFishPlayer;
    private GoFishDealer goFishDealer;
    private Player player;
    Console console = new Console(System.in, System.out);

    public GoFish(GoFishPlayer newPlayer, GoFishDealer newDealer) {
        this.goFishPlayer = newPlayer;
        this.goFishDealer = newDealer;
    }

    public void createDeck() {
        deck.createDeck();
    }

    public void shuffleDeck() {
        deck.shuffle();
    }

    public Card drawCardPlayer() {
        return deck.popCard();
    }

    public Card drawCardDealer() {
        return deck.popCard();
    }

    public void setupPlayerHand() {
        for (int i = 0; i < 5; i++) {
            goFishPlayer.drawCard(deck.popCard());
        }
    }

    public void setupDealerHand() {
        for (int i = 0; i < 5; i++) {
            goFishDealer.drawCard(deck.popCard());
        }
    }

    public void printPlayerHand() {
        int playerHandSize = goFishPlayer.getPlayerHand().size();
        for (int i = 0; i < playerHandSize; i++) {
            System.out.println(goFishPlayer.getPlayerHand().get(i).toString());
        }
    }
<<<<<<< HEAD
=======

>>>>>>> 43ebb870dc096875ef696a2ee99d8ff5fc33a05f

    public void printDealerHand() {
        int playerHandSize = goFishDealer.getDealerHand().size();
        for (int i = 0; i < playerHandSize; i++) {
            System.out.println(goFishDealer.getDealerHand().get(i).toString());
        }
    }

    public void addBookToPlayerScore() {
        goFishPlayer.addBookToPlayer();
    }

    public void addBookToDealerScore() {
        goFishDealer.addBookToDealer();
    }

    public Integer getPlayerScore() {
        return goFishPlayer.getPlayerScore();
    }

    public Integer getDealerScore() {
        return goFishDealer.getDealerScore();
    }

    public void play() {
        System.out.println("██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗    ████████╗ ██████╗      ██████╗  ██████╗ ███████╗██╗███████╗██╗  ██╗\n" +
                "██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝    ╚══██╔══╝██╔═══██╗    ██╔════╝ ██╔═══██╗██╔════╝██║██╔════╝██║  ██║\n" +
                "██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗         ██║   ██║   ██║    ██║  ███╗██║   ██║█████╗  ██║███████╗███████║\n" +
                "██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝         ██║   ██║   ██║    ██║   ██║██║   ██║██╔══╝  ██║╚════██║██╔══██║\n" +
                "╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗       ██║   ╚██████╔╝    ╚██████╔╝╚██████╔╝██║     ██║███████║██║  ██║\n" +
                " ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝       ╚═╝    ╚═════╝      ╚═════╝  ╚═════╝ ╚═╝     ╚═╝╚══════╝╚═╝  ╚═╝\n" +
                "                                                                                                                                     ");
        Player player = new Player();
        GoFishPlayer goFishPlayer = new GoFishPlayer(player);
        GoFishDealer goFishDealer = new GoFishDealer();
        GoFish currentGame = new GoFish(goFishPlayer, goFishDealer);
        currentGame.createDeck();
        currentGame.shuffleDeck();

        currentGame.setupPlayerHand();
        currentGame.setupDealerHand();

    }

}
