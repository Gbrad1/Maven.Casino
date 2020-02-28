package io.zipcoder.casino;


import io.zipcoder.casino.card.CrapsTable;
import io.zipcoder.casino.card.SicBoTable;
import io.zipcoder.casino.dealer.BlackjackDealer;
import io.zipcoder.casino.dealer.GoFishDealer;
import io.zipcoder.casino.game.Blackjack;
import io.zipcoder.casino.game.Craps;
import io.zipcoder.casino.game.SicBo;
import io.zipcoder.casino.game.GoFish;
import io.zipcoder.casino.player.*;
import io.zipcoder.casino.utilities.Console;

import java.lang.annotation.Target;

public class Casino {

    private static Player user;
    private static Multiplayer accounts = new Multiplayer();
    private static Console console = new Console(System.in, System.out);

    public static void welcome(){
        System.out.println("██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗    ████████╗ ██████╗     ███████╗██╗██████╗      ██████╗ ██████╗ ██████╗ ███████╗\n" +
                "██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝    ╚══██╔══╝██╔═══██╗    ╚══███╔╝██║██╔══██╗    ██╔════╝██╔═══██╗██╔══██╗██╔════╝\n" +
                "██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗         ██║   ██║   ██║      ███╔╝ ██║██████╔╝    ██║     ██║   ██║██║  ██║█████╗  \n" +
                "██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝         ██║   ██║   ██║     ███╔╝  ██║██╔═══╝     ██║     ██║   ██║██║  ██║██╔══╝  \n" +
                "╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗       ██║   ╚██████╔╝    ███████╗██║██║         ╚██████╗╚██████╔╝██████╔╝███████╗\n" +
                " ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝       ╚═╝    ╚═════╝     ╚══════╝╚═╝╚═╝          ╚═════╝ ╚═════╝ ╚═════╝ ╚══════╝\n" +
                "                                                                                                                                                \n" +
                " ██████╗ █████╗ ███████╗██╗███╗   ██╗ ██████╗ ██╗     ██╗██████╗  ██╗     █████╗ ███╗   ██╗██████╗      ██████╗ ██╗   ██╗███████╗██████╗ ██╗    \n" +
                "██╔════╝██╔══██╗██╔════╝██║████╗  ██║██╔═══██╗██║    ██╔╝╚════██╗███║    ██╔══██╗████╗  ██║██╔══██╗    ██╔═══██╗██║   ██║██╔════╝██╔══██╗╚██╗   \n" +
                "██║     ███████║███████╗██║██╔██╗ ██║██║   ██║██║    ██║  █████╔╝╚██║    ███████║██╔██╗ ██║██║  ██║    ██║   ██║██║   ██║█████╗  ██████╔╝ ██║   \n" +
                "██║     ██╔══██║╚════██║██║██║╚██╗██║██║   ██║╚═╝    ██║ ██╔═══╝  ██║    ██╔══██║██║╚██╗██║██║  ██║    ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗ ██║   \n" +
                "╚██████╗██║  ██║███████║██║██║ ╚████║╚██████╔╝██╗    ╚██╗███████╗ ██║    ██║  ██║██║ ╚████║██████╔╝    ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║██╔╝   \n" +
                " ╚═════╝╚═╝  ╚═╝╚══════╝╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝ ╚═╝    ╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝      ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝╚═╝    \n" +
                "                                                                                                                                                ");
    }


    public static void intro(){
        Integer loginOrCreatePlayer = console.getIntegerInput("Enter: \n1 to create account\n2 to log in.");
        if (loginOrCreatePlayer == 1){
            createAccount();
        }
        else if (loginOrCreatePlayer == 2){
            logIn();
        }
        else {
            System.out.println("\nPlease Enter 1 or 2.\n");
            intro();
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
        System.out.println("Your login ID is " + ID + " please save this number!\n");
        Player createdPlayer = new Player(name, age);
        accounts.add(ID, createdPlayer);
        user = createdPlayer;
    }

    public static void logIn(){
        Long id = console.getLongInput("What is your login ID?");
        if (accounts.containsID(id)){
            user = accounts.loginPlayer(id);
            System.out.println("Welcome back "+ user.getName() + "!\n");
        }
        else {
            System.out.println("Wrong login ID.\n");
            intro();
        }


    }

    public static void main(String[] args) {
        welcome();
        intro();
        menu();
    }

    public static void menu(){
        while (true) {
            System.out.println("===========\nUsername: "
                    + user.getName() + "\nBalance: "
                    + user.getBalance() + "\n===========");
            Integer choice = console.getIntegerInput("\nEnter: \n1 to play Blackjack\n2 to play Go Fish" +
                    "\n3 to play Craps\n4 to play SicBo" +
                    "\n5 to return to login\n6 to create a new account" +
                    "\n7 to leave the casino");
            switch (choice) {
                case 1:
                    playBlackjack();
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


    public static void playBlackjack(){
        Blackjack bjGame = new Blackjack(new BlackjackPlayer(user), new BlackjackDealer());

        bjGame.play();

        menu();
    }

    public static void playGoFish(){
        GoFish goFishGame = new GoFish(new GoFishPlayer(user), new GoFishDealer());

        goFishGame.play();
        menu();
    }

    public static void playSicBo(){
        Console consoleSicBo = new Console(System.in, System.out);
        SicBo sicBoGame = new SicBo(new SicBoPlayer(user));
        sicBoGame.play();
    }

    public static void playCraps(){
        CrapsTable table = new CrapsTable();
        Craps crapsTable = new Craps(new CrapsPlayer(user), table);
        crapsTable.play();
        menu();

    }
}
