package io.zipcoder.casino.game;

import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.SicBoPlayer;
import io.zipcoder.casino.utilities.Console;


public class SicBo implements Gambling {

    private SicBoPlayer player;
    private Console console = new Console(System.in, System.out);
    private boolean isPlayerDone;


    public SicBo(SicBoPlayer player) {
        this.player = player;
    }


    public int placeBet() {
        console.getIntegerInput("Place bet on Big or Small");
        return 0;
    }


    public void play() {


    }


    @Override
    public void getWinnings() {

    }

    public boolean bigWin() {
        return player.rollDice() > 10;
    }

    public boolean smallWin() {
        return player.rollDice() <= 10;
    }
}

