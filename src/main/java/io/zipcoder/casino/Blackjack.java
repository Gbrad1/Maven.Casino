package io.zipcoder.casino;

import io.zipcoder.casino.card.Deck;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

public class Blackjack {

    Deck deck;
    Console console;
    Player player;
    Dealer dealer;



    public Blackjack(Player user) {

        this.deck = new Deck();
        this.console = new Console(System.in, System.out);
        this.player = user;
        this.dealer =  new Dealer();


    }

    public void playGame() {

       }

    public boolean checkBlackJack(Hand firstRound) {

        if (dealer.getHand[0].getRank() + dealer.getHand[1].getRank() = 21) {
            if (player.getHand[0].getRank() + player.getHand[1].getRank() = 21)
        }
                return true;

        }


    public void placeBet() {

    }

    public void hitMe() {

    }

    public void stay() {

    }

    public void blackjackYay() {
        int blackjackYay = 21;
    }

    public void beginPlay() {

    }




    }



