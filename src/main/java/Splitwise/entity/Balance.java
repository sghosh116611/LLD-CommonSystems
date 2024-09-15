package Splitwise.entity;

public class Balance {

    private double amountOwe;
    private double amountGetBack;

    public Balance() {
    }

    public Balance(double amountOwe, double amountGetBack) {
        this.amountOwe = amountOwe;
        this.amountGetBack = amountGetBack;
    }

    public double getAmountOwe() {
        return amountOwe;
    }

    public void setAmountOwe(double amountOwe) {
        this.amountOwe = amountOwe;
    }

    public double getAmountGetBack() {
        return amountGetBack;
    }

    public void setAmountGetBack(double amountGetBack) {
        this.amountGetBack = amountGetBack;
    }
}
