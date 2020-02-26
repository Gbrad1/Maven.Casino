package io.zipcoder.casino;


import io.zipcoder.casino.card.SicBoTable;
import io.zipcoder.casino.dealer.BlackjackDealer;
import io.zipcoder.casino.dealer.GoFishDealer;
import io.zipcoder.casino.game.Blackjack;
import io.zipcoder.casino.game.SicBo;
import io.zipcoder.casino.game.GoFish;
import io.zipcoder.casino.player.BlackjackPlayer;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Multiplayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.SicBoPlayer;
import io.zipcoder.casino.utilities.Console;

public class Casino {

    private static Player user;
    private static Multiplayer accounts = new Multiplayer();
    private static Console console = new Console(System.in, System.out);

    public static void intro(){
        Integer loginOrCreatePlayer = console.getIntegerInput("Enter 1 to create account or enter 2 to log in.");
        if (loginOrCreatePlayer == 1){
            createAccount();
        }
        else if (loginOrCreatePlayer == 2){
            logIn();
        }
    }

    public static void createAccount(){
        String name = console.getStringInput("What is your name?");
        Integer age = console.getIntegerInput("What is your age?");
        if (age < 21){
            System.out.println("You are too young!");
            System.exit(0);
        }
        Long ID = accounts.generateId();
        Player createdPlayer = new Player(name, age);
        //accounts.add(ID, createdPlayer);
        user = createdPlayer;
    }

    public static void logIn(){

    }

    public static void main(String[] args) {
        intro();
        menu();
    }

    public static void menu(){
        while (true) {
            Integer choice = console.getIntegerInput("Enter 1 to play Blackjack, 2 to play Go Fish," +
                    " 3 to play Craps, and 4 to play SicBo.  " +
                    "If you want to return to login press 5 and if you want to create a new account press 6." +
                    "If you wish to save and exit press 7.  ");
            switch (choice) {
                case 1:
                    playBlackjackIntro();
                    break;
                case 2:
                    playGoFish();
                    break;
                case 3:
                    playCraps();
                    break;
                case 4:
                    playSicBo();
                    break;
                case 5:
                    logIn();
                    break;
                case 6:
                    createAccount();
                    break;
                case 7:
                    saveAndExit();
                    break;
            }
        }
    }

    public static void saveAndExit(){
        accounts.savePlayerDataBase();
        System.exit(0);
    }


    public static void playBlackjackIntro(){
        Integer bid = console.getIntegerInput("Enter a bid amount of 5, 10, or 15.");
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
        Blackjack bjGame = new Blackjack(new BlackjackPlayer(user), new BlackjackDealer());
        // store bid as "bid"

        bjGame.play();

        menu();
    }

    public static void playGoFish(){
        Console consoleGoFish = new Console(System.in, System.out);
        GoFish goFishGame = new GoFish(new GoFishPlayer(user), new GoFishDealer());

        //goFishGame.play();
        menu();

    }

    public static void playSicBo(){
        Console consoleSicBo = new Console(System.in, System.out);
        SicBo sicBoGame = new SicBo(new SicBoPlayer(user));
        SicBoTable sicBoTable = new SicBoTable();
        sicBoGame.placeBet();

    }

    public static void playCraps(){
        Console consoleCraps = new Console(System.in, System.out);
        menu();

    }
}
