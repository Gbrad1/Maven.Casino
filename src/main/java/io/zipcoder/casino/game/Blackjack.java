package io.zipcoder.casino.game;
import io.zipcoder.casino.card.Deck;
import io.zipcoder.casino.dealer.BlackjackDealer;
import io.zipcoder.casino.player.BlackjackPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;


public class Blackjack {

    private Deck deck = new Deck();
    private BlackjackPlayer player;
    private BlackjackDealer dealer;
    Console console = new Console(System.in, System.out);

    public Blackjack(BlackjackPlayer player, BlackjackDealer dealer){
        this.player = player;
        this.dealer = dealer;
    }

    public void createDeck(){
        this.deck.createDeck();
    }

    public void shuffleDeck(){
        this.deck.shuffle();
    }

    public void drawCardPlayer(){
        player.hit(deck.popCard());
    }

    public void drawCardDealer(){
        dealer.hit(deck.popCard());
    }

    public int getScorePlayer(){
        return player.getScore();
    }

    public int getScoreDealer(){
        return dealer.getScore();
    }

    public boolean bustPlayer(){
        if (getScorePlayer() > 21){
            return true;
        }
        return false;
    }

    public boolean bustDealer(){
        if (getScoreDealer() > 21){
            return true;
        }
        return false;
    }

    public void setHandPlayer(){
        player.getHand().add(deck.popCard());
        player.getHand().add(deck.popCard());
    }

    public void setDealerPlayer(){
        dealer.getHand().add(deck.popCard());
        dealer.getHand().add(deck.popCard());
    }

    public String seeDealerCard(){
        return dealer.getHand().get(1).toString();
    }

    public void play() {
        Player player = new Player();
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(player);
        BlackjackDealer blackjackDealer = new BlackjackDealer();
        Blackjack newGame = new Blackjack(blackjackPlayer, blackjackDealer);

        newGame.createDeck();
        newGame.shuffleDeck();
        newGame.setHandPlayer();
        newGame.setDealerPlayer();

        System.out.println("Welcome to Blackjack!");
    }

}
