package io.zipcoder.casino.game;

import io.zipcoder.casino.player.SicBoPlayer;
import io.zipcoder.casino.utilities.Console;


public class SicBo implements Gambling {

    private SicBoPlayer user;
    private Console console = new Console(System.in, System.out);
    private Integer input;
    private Integer bid;


    public SicBo(SicBoPlayer user) {
        this.user = user;
    }


    public int placeBet() {
        bid = console.getIntegerInput("Enter a bet amount");
        while (bid > user.getPlayer().getBalance()) {
            bid = console.getIntegerInput("You do not have enough in your balance. Please try again!");
        }
        return bid;
    }

    public void play() {
        input = console.getIntegerInput("What would you like to bet on? " +
                                        "\n1: SMALL\n2: BIG\n3: EVEN\n4: ODD\n5: ANY TRIPLE");

        switch (input)
        {
            case 1:
                betSmall();
                break;
            case 2:
                betBig();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

    public Integer newRoll() {
        return user.rollDice();
    }

    public void betSmall() {
        System.out.println("You bet on SMALL with $" + bid + "!");
        Integer roll = newRoll();
        System.out.println("The roll is " + roll + "!");
        if (roll <= 10) {
            user.getPlayer().setBalance(user.getPlayer().getBalance() + (bid * 2));
            System.out.println("You Win!");
        } else {
            user.getPlayer().setBalance(user.getPlayer().getBalance() - bid);
            System.out.println("You lost... please try again!");
        }
    }

    public void betBig() {
        System.out.println("You bet on BIG with $" + bid + "!");
        Integer roll = newRoll();
        System.out.println("The roll is " + roll + "!");
        if (roll > 10) {
            user.getPlayer().setBalance(user.getPlayer().getBalance() + (bid * 2));
            System.out.println("You Win!");
        } else {
            user.getPlayer().setBalance(user.getPlayer().getBalance() - bid);
            System.out.println("You lost... please try again!");
        }
    }



    @Override
    public void getWinnings() {

    }


}

