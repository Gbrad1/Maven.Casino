package io.zipcoder.casino.game;

import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.SicBoPlayer;
import io.zipcoder.casino.utilities.Console;


public class Sicbo implements Gambling {

    SicBoPlayer player;
    Console console = new Console(System.in, System.out);


    public Sicbo(SicBoPlayer player) {
        this.player = player;
    }


    public int placeBet() {
        console.getIntegerInput("Place bet on Big or Small");
        return placeBet();
    }


    public void play() {

    }

    @Override
    public void getWinnings() {
        String bigWin = "Big Win";
        String smallWin = "Small Win";

        if (inFlavorOfBig()) {
            String bigWin1 = bigWin;
        } else if (inFlavorOfSmall()) {
            placeBet();
        }
        return ;

    }

    public boolean inFlavorOfBig() {
        return player.rollDice() > 10;
    }

    public boolean inFlavorOfSmall() {
        return player.rollDice() <= 10;
    }
}

