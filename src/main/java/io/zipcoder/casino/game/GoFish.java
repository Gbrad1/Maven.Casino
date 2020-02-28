package io.zipcoder.casino.game;

import io.zipcoder.casino.Casino;
import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Deck;
import io.zipcoder.casino.dealer.GoFishDealer;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.utilities.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class GoFish {

    private Deck deck = new Deck();
    private GoFishPlayer goFishPlayer;
    private GoFishDealer goFishDealer;
    Casino casino = new Casino();
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

    public boolean checkPlayerHand(Integer a) {
        for (Card c : goFishPlayer.getPlayerHand()) {
            if (c.getRank().equals(a)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDealerHand(Integer a) {
        for (Card c : goFishDealer.getDealerHand()) {
            if (c.getRank().equals(a)) {
                return true;
            }
        }
        return false;
    }

    public void takeDealerCards(Integer cardRank) {
        for (Card c : goFishDealer.getDealerHand()) {
            if (c.getRank().equals(cardRank)) {
                cardsToRemove.add(c);
                goFishPlayer.getPlayerHand().add(c);
            }
        }
        goFishDealer.getDealerHand().removeAll(cardsToRemove);
        cardsToRemove.clear();
    }

    public void takePlayerCards(Integer cardRank) {
        for (Card c : goFishPlayer.getPlayerHand()) {
            if (c.getRank().equals(cardRank)) {
                cardsToRemove.add(c);
                goFishDealer.getDealerHand().add(c);
            }
        }
        goFishPlayer.getPlayerHand().removeAll(cardsToRemove);
        cardsToRemove.clear();
    }

    public void sortPlayerHand() {
        Collections.sort(goFishPlayer.getPlayerHand());
    }

    public void sortDealerHand() {
        Collections.sort(goFishDealer.getDealerHand());
    }

    public boolean checkWinCondition () {
        if ((goFishPlayer.getPlayerScore() + goFishDealer.getDealerScore()) == 13) {
            return true;
        }
        return false;
    }
    public void returnToMenu() {
    }

    public void playerTurn() {
        Integer request = console.getIntegerInput("What number would like to ask your opponent for?");
        if (request.equals(0)) {
            casino.menu();
        }
        while (!checkPlayerHand(request)) {
            System.out.println("You do not own that card.");
            request = console.getIntegerInput("What number would like to ask your opponent for?");
        }
        if (checkDealerHand(request)) {
            System.out.println("Nice guess!");
            takeDealerCards(request);
            sortPlayerHand();
            sortDealerHand();
            goFishPlayer.addBook();
            printPlayerHand();
        } else if (!checkDealerHand(request)) {
            if (!deck.isEmpty()){
                goFishPlayer.drawCard(drawCardPlayer());
            }
            System.out.println("\n\"Go Fish!\" - evil Jeff\n");
            System.out.println("You draw a card and add it to your hand.");
            sortPlayerHand();
            sortDealerHand();
            goFishPlayer.addBook();
            printPlayerHand();
        }
    }

    public Integer dealerChoiceToRequestFromPlayer() {
        Random random = new Random();
        return goFishDealer.getDealerHand().get(random.nextInt(goFishDealer.getDealerHand().size())).getRank();
    }

    public void dealerTurn () {
        System.out.println("====================================\n");
        Integer dealerPick = dealerChoiceToRequestFromPlayer();
        if (checkPlayerHand(dealerPick)) {
            takePlayerCards(dealerPick);
            System.out.println("Picked " + dealerPick);
            System.out.println("That rascal Jeff stole from you. Your new hand is below.\n");
            sortPlayerHand();
            sortDealerHand();
            goFishDealer.addBook();
            printPlayerHand();
        } else if (!checkPlayerHand(dealerPick)){
            if (!deck.isEmpty()){
                goFishDealer.drawCard(drawCardDealer());
            }
            System.out.println("Jeff did not guess correctly.\n");
            sortPlayerHand();
            sortDealerHand();
            goFishDealer.addBook();
        }
        //Card toPrint = goFishDealer.getDealerHand().get(dealerPick);
    }


    public void play() {
        boolean playStatus = true;
        console.welcomeGoFish();
        createDeck();
        shuffleDeck();
        setupPlayerHand();
        setupDealerHand();
        sortPlayerHand();
        sortDealerHand();
        System.out.println("Hello! please use the following for face cards.\nJack(11)\nQueen(12)\nKing(13)");
        System.out.println("\n");
        System.out.println("Here is your starting hand.\nYou may also type \"0\" to quit at anytime.\n");
        printPlayerHand();

        while(playStatus) {
            playerTurn();
            dealerTurn();
            System.out.println("====================================");
            System.out.println("Dealer Score: " + goFishDealer.getDealerScore() + "\nPlayer Score: " + goFishPlayer.getPlayerScore());
            System.out.println("====================================");
            if (deck.isEmpty() || checkWinCondition()) {
                if (goFishPlayer.getPlayerScore() > goFishDealer.getDealerScore()) {
                    System.out.println("You won!");
                    break;
                } else
                    System.out.println("You lose. D:");
                    break;
            }

        }
    }
}