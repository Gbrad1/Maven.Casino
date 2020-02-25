package io.zipcoder.casino.Game;

import io.zipcoder.casino.dice.Dice;

import java.util.Arrays;
import java.util.List;

public class Sicbo {

    Dice dice = new Dice(3);
    private final List<Integer> smallRoll = Arrays.asList(3, 4, 5, 6, 7, 8, 9, 10);
    private final List<Integer> bigRoll = Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18);


    public Sicbo() {
    }

    public void newRoll() {

        for (int i = smallRoll.indexOf(0); i < smallRoll.size(); i++) {
            if (dice.tossAndSum() == smallRoll.indexOf(i)) {
                //smallRoll win;
            } else {
                //bigRoll win;
            }
        }
    }
}


/*
if sum == 4
    then payout 60 * bet;

   maybe switch case;


 */