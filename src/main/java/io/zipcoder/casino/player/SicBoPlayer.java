package io.zipcoder.casino.player;

import java.util.concurrent.ThreadLocalRandom;

public class SicBoPlayer extends DicePlayer{

    private Player user;
    Integer[] triple = new Integer[3];

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
        int sum = 0;
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < 3; i++) {
            Integer num = random.nextInt(6) + 1;
            triple[i] = num;
            sum += num;
        }
        return sum;
    }

    public boolean isTriple() {
        System.out.println("Dice 1 is " + triple[0] +
                            " Dice 2 is " + triple[1] + "Dice 3 is " + triple[2]);

        return triple[0].equals(triple[1]) && triple[1].equals(triple[2]);
    }




}
