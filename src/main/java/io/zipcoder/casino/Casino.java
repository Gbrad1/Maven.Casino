package io.zipcoder.casino;


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
    }

    public static void createAccount(){
        String name = console.getStringInput("What is your name?");
        Integer age = console.getIntegerInput("What is your age?");
        if (age < 21){
            System.out.println("You are too young!");
            System.exit(0);
        }
        Long ID = accounts.generateId();
        System.out.println("Your log in ID is " + ID + " please save this number!\n");
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
            Integer choice = console.getIntegerInput("Enter: \n1 to play Blackjack\n2 to play Go Fish" +
                    "\n3 to play Sic Bo\n4 to play Craps" +
                    "\n5 to return to login\n6 to create a new account" +
                    "\n7 to leave the casino");
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

        goFishGame.play();
        menu();
    }

    public static void playSicBo(){
        Console consoleSicBo = new Console(System.in, System.out);
        SicBo sicBoGame = new SicBo(new SicBoPlayer(user));

    }

    public static void playCraps(){
        Console consoleCraps = new Console(System.in, System.out);
        menu();

    }
}
