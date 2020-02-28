package io.zipcoder.casino.player;

import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SicBoPlayer extends DicePlayer{


    private Player user;
    private ArrayList<Integer> triple = new ArrayList<>();
    private Random random;
    private Console console = new Console(System.in, System.out);


    public SicBoPlayer(Player user) {
        this.user = user;
        this.random = new Random();
    }

    public SicBoPlayer() {
    }


    public Random getRandom() {
        return random;
    }



    public void addTriple(int num) {
        triple.add(num);
    }

    public ArrayList<Integer> getTriple() {
        return triple;
    }

    public void setSeed() {
        this.random.setSeed(12);
    }

    public Player getPlayer() {
        return user;
    }

    public void clearTriple() {
        triple.clear();
    }


    @Override
    public int rollDice() {
        int sum = 0;
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < 3; i++) {
            int num = random.nextInt(6) + 1;
            triple.add(num);
            sum += num;
        }
        return sum;
    }


    public boolean isTriple(ArrayList<Integer> triple) {
        console.print("\nResult of all 3 dice is " + triple.get(0) +
                " , " + triple.get(1) + " , " + triple.get(2));

        return triple.get(0) == triple.get(1) && triple.get(1) == triple.get(2);
    }

}
