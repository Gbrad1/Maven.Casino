package io.zipcoder.casino.player;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SicBoPlayer extends DicePlayer{

    private Integer score;
    private Player user;

    public SicBoPlayer(Player user) {
        this.user = user;
    }

    public SicBoPlayer() {

    }

    public Player getPlayer() {
        return user;
    }

    @Override
    public int rollDice() {
        Integer[] triple = new Integer[3];
        boolean isTriple = false;
        int sum = 0;
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < 3; i++) {
            Integer num = random.nextInt(6) + 1;
            triple[i] = num;
            sum += num;
        }
        return sum;
    }




}
