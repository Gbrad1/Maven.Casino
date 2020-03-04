package io.zipcoder.casino.game;

import io.zipcoder.casino.Casino;
import io.zipcoder.casino.card.SicBoTable;
import io.zipcoder.casino.player.SicBoPlayer;
import io.zipcoder.casino.utilities.Console;


public class SicBo implements Gambling {

    private SicBoPlayer user;
    private Console console = new Console(System.in, System.out);
    private Integer bid;
    private int input;


    public SicBo(SicBoPlayer user) {
        this.user = user;
    }


    public int placeBet() {

        while (bid > user.getPlayer().getBalance() && bid > 0) {
            bid = console.getIntegerInput("Please enter the right amount!");
        }
        return bid;
    }


    public void play() {

        SicBoTable sicBoTable = new SicBoTable();
        input = console.getIntegerInput("\nWhat would you like to bet on?" +
                "\n1: SMALL\n2: BIG\n3: EVEN\n4: ODD\n5: ANY TRIPLE\n" +
                "6: EXIT BACK TO MAIN MENU");

        while (input > 0 && input < 7) {

            switch (input)
            {
                case 1:
                    bid = console.getIntegerInput("Enter a bet amount");
                    placeBet();
                    console.print("You bet on SMALL with $" + bid + "!");
                    betSmall();
                    console.print("\nUpdated balance $" + user.getPlayer().getBalance());
                    break;
                case 2:
                    bid = console.getIntegerInput("Enter a bet amount");
                    placeBet();
                    console.print("You bet on BIG with $" + bid + "!");
                    betBig();
                    console.print("\nUpdated balance $" + user.getPlayer().getBalance());
                    break;
                case 3:
                    bid = console.getIntegerInput("Enter a bet amount");
                    placeBet();
                    console.print("You bet on EVEN with $" + bid + "!");
                    betEven();
                    console.print("\nUpdated balance $" + user.getPlayer().getBalance());
                    break;
                case 4:
                    bid = console.getIntegerInput("Enter a bet amount");
                    placeBet();
                    console.print("You bet on ODD with $" + bid + "!");
                    betOdd();
                    console.print("\nUpdated balance $" + user.getPlayer().getBalance());
                    break;
                case 5:
                    bid = console.getIntegerInput("Enter a bet amount");
                    placeBet();
                    console.print("You bet on ANY TRIPLE with $" + bid + "!");
                    betTriple();
                    console.print("\nUpdated balance $" + user.getPlayer().getBalance());
                    user.clearTriple();
                    break;
                case 6:
                    Casino.menu();
                    break;
            }
            play();
        }
        console.print("\nPlease enter a value menu option!");
        play();
    }


    public Integer getRoll() {
        return user.rollDice();
    }


    public void betSmall() {
        Integer roll = getRoll();
        console.print("\nThe roll is " + roll + "!");

        if (roll <= 10) {
            user.getPlayer().setBalance(user.getPlayer().getBalance() + bid);
            console.print("\nYou Win!");

        } else {
            user.getPlayer().setBalance(user.getPlayer().getBalance() - bid);
            console.print("\nYou lost... ");
        }

    }


    public void betBig() {
        Integer roll = getRoll();
        console.print("\nThe roll is " + roll + "!");

        if (roll > 10) {
            user.getPlayer().setBalance(user.getPlayer().getBalance() + bid);
            console.print("\nYou Win!");

        } else {
            user.getPlayer().setBalance(user.getPlayer().getBalance() - bid);
            console.print("\nYou lost... ");
        }
    }


    public void betEven() {
        Integer roll = getRoll();
        console.print("\nThe roll is " + roll + "!");

        if (roll % 2 == 0) {
            user.getPlayer().setBalance(user.getPlayer().getBalance() + bid);
            console.print("\nYou Win!");

        } else {
            user.getPlayer().setBalance(user.getPlayer().getBalance() - bid);
            console.print("\nYou lost... ");
        }

    }


    public void betOdd() {
        Integer roll = getRoll();
        console.print("\nThe roll is " + roll + "!");

        if (roll % 2 != 0) {
            user.getPlayer().setBalance(user.getPlayer().getBalance() + bid);
            console.print("\nYou Win!");

        } else {
            user.getPlayer().setBalance(user.getPlayer().getBalance() - bid);
            console.print("\nYou lost... ");
        }
    }


    public void betTriple() {

        getRoll();

        if (user.isTriple(user.getTriple())) {
            user.getPlayer().setBalance(user.getPlayer().getBalance() + (bid * 30));
            console.print("\nYou Win!");

        } else {
            user.getPlayer().setBalance(user.getPlayer().getBalance() - bid);
            console.print("\nYou lost... ");
        }
    }

    @Override
    public void getWinnings() {

    }

}

