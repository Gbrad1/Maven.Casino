package io.zipcoder.casino.player;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SicBoPlayer extends DicePlayer{

    private Integer score;
    private Player player;

    public SicBoPlayer(Player player) {
    }


    @Override
    public int rollDice() {
        int sum = 0;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 3; i++) {
            sum += random.nextInt(6) + 1;
        }
        return sum;
    }
}
