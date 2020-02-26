package io.zipcoder.casino.game;

import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.SicBoPlayer;
import io.zipcoder.casino.utilities.Console;


public class SicBo implements Gambling {

    private SicBoPlayer player;
    private Console console = new Console(System.in, System.out);
    private Integer input;

    public SicBo(SicBoPlayer player) {
        this.player = player;
    }


    public int placeBet() {
        return console.getIntegerInput("Enter a bet amount");
    }

    public void play(int bid) {
        input = console.getIntegerInput("What would you like to bet on? \n1: Big\n2: Small\n3: Even\n4: Odds\n5: Any Triple");
        switch (input)
        {
            case 1:
                placeBet();
                break;
        }
    }

    public boolean bigWin() {
        return player.rollDice() > 10;
    }

    public boolean smallWin() {
        return player.rollDice() <= 10;
    }

    @Override
    public void getWinnings() {

    }


}

