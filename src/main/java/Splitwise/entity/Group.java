package Splitwise.entity;

import Splitwise.controller.ExpenseController;

import java.util.List;

public class Group {
    private String groupId;
    private String name;
    private List<User> users;
    private List<Expense> expenses;
    private ExpenseController expenseController;

    public Group(String groupId, String name, List<User> users, List<Expense> expenses) {
        this.groupId = groupId;
        this.name = name;
        this.users = users;
        this.expenses = expenses;
        expenseController = new ExpenseController();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
