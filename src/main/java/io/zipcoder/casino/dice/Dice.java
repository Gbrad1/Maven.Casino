package io.zipcoder.casino.dice;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    public int numberOfDice;

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int tossAndSum() {
        int sum = 0;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < numberOfDice; i++) {
            sum += random.nextInt(6) + 1;
        }
        return sum;
    }
}
