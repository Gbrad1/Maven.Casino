package io.zipcoder.casino.player;

import java.util.Random;

public class SicBoPlayer extends DicePlayer{

    private Integer score;
    private Player player;

    public SicBoPlayer(Player player) {
    }

    private void placeBet() {

    }


    @Override
    public int rollDice() {
        Random random = new Random();
        return 3* (random.nextInt(6) + 1);
    }
}
