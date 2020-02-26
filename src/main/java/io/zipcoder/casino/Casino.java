package io.zipcoder.casino;


import io.zipcoder.casino.dealer.BlackjackDealer;
import io.zipcoder.casino.game.Blackjack;
import io.zipcoder.casino.player.BlackjackPlayer;
import io.zipcoder.casino.player.Multiplayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

public class Casino {

    private static Player user;
    private Multiplayer accounts = new Multiplayer();
    private Console console = new Console(System.in, System.out);

    public static void intro(){
        Console consoleIntro = new Console(System.in, System.out);
        String name = consoleIntro.getStringInput("What is your name?");
        Integer age = consoleIntro.getIntegerInput("What is your age?");
        if (age < 21){
            System.out.println("You are too young!");
            System.exit(0);
        }

        user = new Player(name, age);
    }
    public static void main(String[] args) {
        intro();
        Console consoleMain = new Console(System.in, System.out);
        while (true) {
            Integer choice = consoleMain.getIntegerInput("Enter 1 to play Blackjack, 2 to play Go Fish," +
                    " 3 to play Sic Bo, and 4 to play Craps.  If you ever want to exit, just type Exit");
            switch (choice) {
                case 1:
                    playBlackjackIntro();
            }
        }

    }


    public static void playBlackjackIntro(){
        Console consoleBlackjackIntro = new Console(System.in, System.out);
        Integer bid = consoleBlackjackIntro.getIntegerInput("Enter a bid amount of 5, 10, or 15.");
        if (bid == 5){
            playBlackjack(5);
        }
        else if (bid == 10){
            playBlackjack(10);
        }
        else if (bid == 15){
            playBlackjack(15);
        }
    }

    public static void playBlackjack(int bid){
        Console consoleBlackjack = new Console(System.in, System.out);
        Blackjack bjGame = new Blackjack(new BlackjackPlayer(user), new BlackjackDealer());
        // store bid as "bid"
        while (true){
            bjGame.play();
        }
    }

    public void playGoFish(){
        Console consoleGoFish = new Console(System.in, System.out);

    }

    public void playSicBo(){
        Console consoleSicBo = new Console(System.in, System.out);

    }

    public void playCraps(){
        Console consoleCraps = new Console(System.in, System.out);

    }
}
