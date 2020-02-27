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
    Console console = new Console(System.in, System.out);
    private Integer bet;
    private boolean stillPlaying;
    Integer input;
    Integer makeDecision;

    public Blackjack(BlackjackPlayer player, BlackjackDealer dealer) {
        this.player = player;
        this.dealer = dealer;
        this.bet = 0;
        deck.createDeck();
        deck.shuffle();
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
            //exit();
        }
        bet = console.getIntegerInput("How much do you want to wager?");
        while (bet > player.getPlayer().getBalance() || bet < 1) {
            bet = console.getIntegerInput("Enter a valid wager.");
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

    public Boolean checkBlackjack() {
        if (this.dealer.checkBlackjack() && this.player.checkBlackjack()) {
            console.println("You both got Blackjack. Push!\n");
            stillPlaying = false;
            getWinnings(bet);
            return true;
        }
        if (this.dealer.checkBlackjack() && !this.player.checkBlackjack()) {
            console.println("Dealer got Blackjack! You lost.\n");
            stillPlaying = false;
            return true;
        }
        if (!this.dealer.checkBlackjack() && this.player.checkBlackjack()) {
            console.println("You got Blackjack! You won!\n");
            stillPlaying = false;
            return true;
        }
        return false;
    }


    public void play() {
        console.println("Welcome to Blackjack.\n");

        while (stillPlaying) {
            setHandPlayer();
            setDealerPlayer();
            input = console.getIntegerInput("Would you like to play or exit? \n1: Play a hand \n2: Exit the game\n");
            while (input != 1 && input != 2) {
                input = console.getIntegerInput("Would you like to play or exit? \n1: Play a hand \n2: Exit the game\n");
            }
            if (input == 1) {

            }
            if (input == 2) {
                break;
            }

            getWager();
            placeBet();

            console.println(dealer.dealerShowCard() + "\n");
            console.println(player.toString() + "\n");
            if (checkBlackjack()) {
                break;
            }

            makeDecision = console.getIntegerInput("What would you like to do? \n1: Hit \n2: Stay");
            while (player.getScore() < 21) {
                if (makeDecision == 1) {
                    drawCardPlayer();
                    console.println(player.toString() + "\n");
                    if (player.getScore() < 21) {
                        makeDecision = console.getIntegerInput("What would you like to do? \n1: Hit \n2: Stay");
                    }
                    if (player.getScore() > 21) {
                        console.println("You busted!");
                        player.getHand().clear();
                        dealer.getHand().clear();
                        break;
                    }
                }

                if (makeDecision == 2) {
                    console.println(dealer.toString());
                    while (dealer.getScore() < 17){
                        drawCardDealer();
                        console.println(dealer.toString());
                    }
                    if (dealer.getScore() > player.getScore()) {
                        console.println("Dealer wins!");
                        player.getHand().clear();
                        dealer.getHand().clear();
                        break;
                    } else if (dealer.getScore() < player.getScore()) {
                        console.println("You win!");
                        getWinnings(bet);
                        player.getHand().clear();
                        dealer.getHand().clear();
                        break;
                    } else {
                        console.println("You pushed!");
                        player.getHand().clear();
                        dealer.getHand().clear();
                        break;
                    }
                }
            }
        }
    }
}