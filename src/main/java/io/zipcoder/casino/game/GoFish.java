package io.zipcoder.casino.game;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Deck;
import io.zipcoder.casino.dealer.GoFishDealer;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class GoFish {
    private Deck deck = new Deck();
    private GoFishPlayer goFishPlayer;
    private GoFishDealer goFishDealer;
    Random randomNumber = new Random();
    ArrayList<Card> cardsToRemove = new ArrayList<>();
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

    public void takeDealerCards(Integer cardRank) {
        Iterator iterator = goFishDealer.getDealerHand().iterator();
        for (Card c : goFishDealer.getDealerHand()) {
            if (c.getRank().equals(cardRank)) {
                goFishDealer.getDealerHand().removeAll(cardsToRemove);
                goFishPlayer.getPlayerHand().add(c);
            }
        }
        goFishDealer.getDealerHand().removeAll(cardsToRemove);
    }

    public void takePlayerCards(Integer cardRank) {
        Iterator iterator = goFishPlayer.getPlayerHand().iterator();
        for (Card c : goFishPlayer.getPlayerHand()) {
            if (c.getRank().equals(cardRank)) {
                goFishPlayer.getPlayerHand().removeAll(cardsToRemove);
                goFishDealer.getDealerHand().add(c);
            }
        }
        goFishPlayer.getPlayerHand().removeAll(cardsToRemove);
    }

    public void sortPlayerHand() {
        Collections.sort(goFishPlayer.getPlayerHand());
    }

    public void sortDealerHand() {
        Collections.sort(goFishDealer.getDealerHand());
    }

    public void playerTurn() {
        String request = console.getStringInput("What number would like to ask your opponent for?");
        Integer requestAsInteger = parseInt(request);
        if (goFishDealer.getDealerHand().contains(requestAsInteger)) {
            takeDealerCards(requestAsInteger);
            sortPlayerHand();
            sortDealerHand();
            printPlayerHand();
        } else {
            goFishPlayer.drawCard(drawCardPlayer());
            System.out.println("\n\"Go Fish!\" - evil NPC\n");
            System.out.println("You draw a card and add it to you hand.");
            sortPlayerHand();
            sortDealerHand();
            printPlayerHand();
        }
    }

    public Integer dealerChoiceToRequestFromPlayer() {
        int dealerHandSize = goFishDealer.getDealerHand().size();
        int random = (randomNumber.nextInt(dealerHandSize) + 1);
        return random;
    }

    public void dealerTurn () {
        System.out.println("=========================================\n");
        Integer dealerPick = dealerChoiceToRequestFromPlayer();
        if (goFishPlayer.getPlayerHand().contains(dealerPick)) {
            takePlayerCards(dealerPick);
            System.out.println("The rascal NPC stole from you. Your new hand is below.");
            sortPlayerHand();
            sortDealerHand();
            printPlayerHand();
        } else {
            goFishDealer.drawCard(drawCardDealer());
            System.out.println("Your opponent did not guess correctly.");
            sortPlayerHand();
            sortDealerHand();
        }
        Card toPrint = goFishDealer.getDealerHand().get(dealerPick);
        System.out.println("Your opponent chose: " + toPrint + "\n");
        System.out.println("=========================================\n");
    }


    public void play() {
        boolean playStatus = true;
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
        createDeck();
        shuffleDeck();

        setupPlayerHand();
        setupDealerHand();
        sortPlayerHand();
        sortDealerHand();
        System.out.println("\n");
        System.out.println("Here is your starting hand.\n");
        printPlayerHand();

        while(playStatus) {
            playerTurn();
            dealerTurn();
        }
    }
}