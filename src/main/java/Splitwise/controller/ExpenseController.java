package Splitwise.controller;

import Splitwise.entity.Expense;
import Splitwise.entity.Split;
import Splitwise.entity.SplitType;
import Splitwise.entity.User;
import Splitwise.utility.IExpenseSplit;
import Splitwise.utility.SplitFactory;

import java.util.List;

public class ExpenseController {

    private BalanceSheetController balanceSheetController;

    public ExpenseController(){
        balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double totalAmount, User paidBy, SplitType splitType, List<Split> splitsDetails){

        Expense expense = null;
        IExpenseSplit expenseSplit = SplitFactory.getSplitUtilityObject(splitType);
        if(expenseSplit.validateRequest(splitsDetails,totalAmount)){
            expense = new Expense(expenseId,description,totalAmount,paidBy,splitType,splitsDetails);
            balanceSheetController.updateBalanceSheetForTheUser(paidBy,splitsDetails,totalAmount);
        }

        return expense;
    }
}
