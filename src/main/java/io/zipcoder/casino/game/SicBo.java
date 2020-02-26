package io.zipcoder.casino.game;

import io.zipcoder.casino.player.SicBoPlayer;
import io.zipcoder.casino.utilities.Console;


public class SicBo implements Gambling {

    private SicBoPlayer user;
    private Console console = new Console(System.in, System.out);
    private Integer input;
    private Integer bid;


    public SicBo(SicBoPlayer user) {
        this.user = user;
    }


    public int placeBet() {
        bid = console.getIntegerInput("Enter a bet amount");
        while (bid > user.getPlayer().getBalance()) {
            bid = console.getIntegerInput("You do not have enough in your balance. Please try again!");
        }
        return bid;
    }

    public void play() {

        input = console.getIntegerInput("What would you like to bet on? \n1: Big\n2: Small\n3: Even\n4: Odds\n5: Any Triple");


        switch (input)
        {
            case 1:
                if (user.rollDice() > 10) placeBet();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }


    public boolean bigWin() {
        return user.rollDice() > 10;
    }

    public boolean smallWin() {
        return user.rollDice() <= 10;
    }

    @Override
    public void getWinnings() {

    }

    enum Bets {
        BIG,
        SMALL,
        EVEN,
        ODD,
        ANYTRIPLE;
    }


}

