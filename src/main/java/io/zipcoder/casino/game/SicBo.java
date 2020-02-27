package io.zipcoder.casino.game;

import io.zipcoder.casino.Casino;
import io.zipcoder.casino.card.SicBoTable;
import io.zipcoder.casino.player.SicBoPlayer;
import io.zipcoder.casino.utilities.Console;


public class SicBo implements Gambling {

    private SicBoPlayer user;
    private Console console = new Console(System.in, System.out);
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
        SicBoTable sicBoTable = new SicBoTable();
        Integer input = console.getIntegerInput("\nWhat would you like to bet on?" +
                "\n1: SMALL\n2: BIG\n3: EVEN\n4: ODD\n5: ANY TRIPLE\n" +
                "6: EXIT BACK TO MAIN MENU");



        switch (input)
        {
            case 1:
                placeBet();
                betSmall();
                break;
            case 2:
                placeBet();
                betBig();
                break;
            case 3:
                placeBet();
                betEven();
                break;
            case 4:
                placeBet();
                betOdd();
                break;
            case 5:
                placeBet();
                betTriple();
                break;
            case 6:
                Casino.menu();
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
            user.getPlayer().setBalance(user.getPlayer().getBalance() + bid);
            System.out.println("You Win!");

        } else {
            user.getPlayer().setBalance(user.getPlayer().getBalance() - bid);
            System.out.println("You lost... " + bid);
        }
        play();
    }

    public void betBig() {
        System.out.println("You bet on BIG with $" + bid + "!");
        Integer roll = newRoll();
        System.out.println("The roll is " + roll + "!");

        if (roll > 10) {
            user.getPlayer().setBalance(user.getPlayer().getBalance() + bid);
            System.out.println("You Win!");

        } else {
            user.getPlayer().setBalance(user.getPlayer().getBalance() - bid);
            System.out.println("You lost... " + bid);
        }
        play();
    }

    public void betEven() {
        System.out.println("You bet on EVEN with $" + bid + "!");
        Integer roll = newRoll();
        System.out.println("The roll is " + roll + "!");

        if (roll % 2 == 0) {
            user.getPlayer().setBalance(user.getPlayer().getBalance() + bid);
            System.out.println("You Win!");

        } else {
            user.getPlayer().setBalance(user.getPlayer().getBalance() - bid);
            System.out.println("You lost... " + bid);
        }
        play();
    }

    public void betOdd() {
        System.out.println("You bet on ODD with $" + bid + "!");
        Integer roll = newRoll();
        System.out.println("The roll is " + roll + "!");

        if (roll % 2 != 0) {
            user.getPlayer().setBalance(user.getPlayer().getBalance() + bid);
            System.out.println("You Win!");

        } else {
            user.getPlayer().setBalance(user.getPlayer().getBalance() - bid);
            System.out.println("You lost... " + bid);
        }
        play();
    }

    public void betTriple() {
        System.out.println("You bet on ANY TRIPLE with $" + bid + "!");

        if (user.isTriple()) {
            user.getPlayer().setBalance(user.getPlayer().getBalance() + bid);
            System.out.println("You Win!");

        } else {
            user.getPlayer().setBalance(user.getPlayer().getBalance() - bid);
        }
        play();
    }

    @Override
    public void getWinnings() {

    }



}

