package Splitwise.entity;

public class User {
    private String userId;
    private String userName;
    private UserExpenseBalanceSheet balanceSheet;

    public User(String userId, String userName, UserExpenseBalanceSheet balanceSheet) {
        this.userId = userId;
        this.userName = userName;
        this.balanceSheet = balanceSheet;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserExpenseBalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(UserExpenseBalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }
}
