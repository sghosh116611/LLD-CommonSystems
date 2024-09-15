package Splitwise.entity;

import java.util.Map;

public class UserExpenseBalanceSheet {

    private Map<String, Balance> friendsBalance;
    private double totalExpense;
    private double totalPayment;
    private double totalOwe;
    private double totalGetBack;

    public Map<String, Balance> getFriendsBalance() {
        return friendsBalance;
    }

    public void setFriendsBalance(Map<String, Balance> friendsBalance) {
        this.friendsBalance = friendsBalance;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalOwe() {
        return totalOwe;
    }

    public void setTotalOwe(double totalOwe) {
        this.totalOwe = totalOwe;
    }

    public double getTotalGetBack() {
        return totalGetBack;
    }

    public void setTotalGetBack(double totalGetBack) {
        this.totalGetBack = totalGetBack;
    }
}
