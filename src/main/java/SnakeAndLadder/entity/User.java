package SnakeAndLadder.entity;

public class User {

    private Dice dice;
    private String name;


    public User(Dice dice, String name) {
        this.dice = dice;
        this.name = name;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
