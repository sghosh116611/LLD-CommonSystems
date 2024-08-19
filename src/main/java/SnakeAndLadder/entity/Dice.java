package SnakeAndLadder.entity;

public class Dice {

    private int diceValue;
    private Point dicePoint;
    private DiceColor color;

    public Dice(int diceValue, Point dicePoint, DiceColor color) {
        this.diceValue = diceValue;
        this.dicePoint = dicePoint;
        this.color = color;
    }

    public int getDiceValue() {
        return diceValue;
    }

    public void setDiceValue(int diceValue) {
        this.diceValue = diceValue;
    }

    public Point getDicePoint() {
        return dicePoint;
    }

    public void setDicePoint(Point dicePoint) {
        this.dicePoint = dicePoint;
    }

    public DiceColor getColor() {
        return color;
    }

    public void setColor(DiceColor color) {
        this.color = color;
    }
}
