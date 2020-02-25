package io.zipcoder.casino;

import io.zipcoder.casino.player.Player;

public abstract class Games {
    //Dealer dealer;
    Player player;

    /*public Games(Dealer newDealer, Player newPlayer) {
        //this.dealer = newDealer;
        this.player = newPlayer;
    }*/

    public Games(Player newPlayer) {
        this.player = newPlayer;
    }

    public abstract void Exit();

    public abstract void play();

    public abstract void playerTurn();

}
