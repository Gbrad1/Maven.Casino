package io.zipcoder.casino.game;

import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;


public class Sicbo {

    Console console = new Console(System.in, System.out);
    Player player = new Player();


    public Sicbo() {
    }

    public int getBet() {
        return console.getIntegerInput("Place bet on Big or Small");
    }

    public boolean inFlavorOfBig() {
        return false;
    }

    public boolean inFlavorOfSmall() {
        return false;
    }

    public String getWinner() {
        String bigWin = "Big Win";
        String smallWin = "Small Win";

        if (inFlavorOfBig()) return bigWin;
        else if (inFlavorOfSmall()) return smallWin;
        return "No roll";
    }

}

