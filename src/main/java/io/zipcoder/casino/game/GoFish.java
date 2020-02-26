package io.zipcoder.casino.game;
import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Deck;
import io.zipcoder.casino.dealer.GoFishDealer;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

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

    public void drawCardDealer() {
        deck.popCard();
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
}
