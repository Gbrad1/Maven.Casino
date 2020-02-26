package io.zipcoder.casino.player;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SicBoPlayer extends DicePlayer{

    private Integer score;
    private Player user;

    public SicBoPlayer(Player user) {
        this.user = user;
    }

    public Player getPlayer() {
        return user;
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
