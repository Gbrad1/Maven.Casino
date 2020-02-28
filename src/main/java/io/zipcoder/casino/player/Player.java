package io.zipcoder.casino.player;

public class Player {
    private String name;
    private int balance;
    private int age;

    public Player(String name, int age){
        this.name = name;
        this.balance = 500;
        this.age = age;
    }

    public Player(){
    }

    public void setBalance(int newBalance){
        this.balance = newBalance;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getBalance(){
        return this.balance;
    }

}
