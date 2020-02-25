package io.zipcoder.casino.Game;

import io.zipcoder.casino.dice.Dice;
import io.zipcoder.casino.utilities.Console;

import java.util.Arrays;
import java.util.List;

public class Sicbo {

    Console console = new Console(System.in, System.out);

    Dice dice = new Dice(3);
    private final List<Integer> smallRoll = Arrays.asList(3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);
    private final List<Integer> bigRoll = Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18);
    private int bigBet;
    private int smallBet;


    public Sicbo() {
    }


    public int newRoll() {

        for (int i = smallRoll.indexOf(0); i < smallRoll.size(); i++) {
            if (dice.tossAndSum() == smallRoll.indexOf(i)) return smallBet;
        }

        for (int i = bigRoll.indexOf(0); i < bigRoll.size(); i++) {
            if (dice.tossAndSum() == bigRoll.indexOf(i)) return bigBet;
        }
        return 0;
    }
}

