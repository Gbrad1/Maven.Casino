package io.zipcoder.casino.player;

import java.util.concurrent.ThreadLocalRandom;

public class CrapsPlayer extends DicePlayer {
    Player user;

    public CrapsPlayer(Player user){
        this.user = user;
    }

    public Player getPlayer(){
        return this.user;
    }

    @Override
    public int rollDice() {

        Integer sum = 0;
        for (int i = 0; i < 2; i++) {
            sum += ThreadLocalRandom.current().nextInt(1,7);
        }

        return sum;
    }
}
