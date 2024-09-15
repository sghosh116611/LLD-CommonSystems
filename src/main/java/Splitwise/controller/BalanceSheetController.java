package Splitwise.controller;

import Splitwise.entity.Balance;
import Splitwise.entity.Split;
import Splitwise.entity.User;
import Splitwise.entity.UserExpenseBalanceSheet;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {

    public void updateBalanceSheetForTheUser(User paidByUser, List<Split> splitDetails, double expenseAmount){

        UserExpenseBalanceSheet paidByUserBalanceSheet = paidByUser.getBalanceSheet();
        paidByUserBalanceSheet.setTotalPayment(paidByUserBalanceSheet.getTotalExpense() + expenseAmount);

        for(Split split : splitDetails){
            User userOwe = split.getUser();
            UserExpenseBalanceSheet userOweBalanceSheet = userOwe.getBalanceSheet();
            double oweAmount = split.getAmount();

            if(paidByUser.getUserId().equals(userOwe.getUserId())){
                paidByUserBalanceSheet.setTotalExpense(paidByUserBalanceSheet.getTotalExpense() + oweAmount);
            }else{

                // update the balance of the paid user
                paidByUserBalanceSheet.setTotalGetBack(paidByUserBalanceSheet.getTotalGetBack() + oweAmount);

                Balance userOweBalance;
                if(paidByUserBalanceSheet.getFriendsBalance().containsKey(userOwe.getUserId())){
                    userOweBalance = paidByUserBalanceSheet.getFriendsBalance().get(userOwe.getUserId());
                }else{
                    userOweBalance = new Balance();
                    paidByUserBalanceSheet.getFriendsBalance().put(userOwe.getUserId(), userOweBalance);
                }
                userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack() + oweAmount);

                // update the balance of the owe user
                userOweBalanceSheet.setTotalOwe(userOweBalance.getAmountOwe() + oweAmount);
                userOweBalanceSheet.setTotalExpense(paidByUserBalanceSheet.getTotalExpense() + oweAmount);

                Balance userPaidBalance;
                if(userOweBalanceSheet.getFriendsBalance().containsKey(paidByUser.getUserId())){
                    userPaidBalance = userOweBalanceSheet.getFriendsBalance().get(paidByUser.getUserId());
                }else{
                    userPaidBalance = new Balance();
                    userOweBalanceSheet.getFriendsBalance().put(paidByUser.getUserId(), userPaidBalance);
                }
                userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe() + oweAmount);
            }
        }
    }

    public void showBalanceSheet(User user) {
        UserExpenseBalanceSheet balanceSheet = user.getBalanceSheet();

        System.out.println("Balance sheet for user: " + user.getUserName());
        System.out.println("------------------------------------------");
        System.out.println("Total Expense: " + balanceSheet.getTotalExpense());
        System.out.println("Total Owe: " + balanceSheet.getTotalOwe());
        System.out.println("Total Get Back: " + balanceSheet.getTotalGetBack());

        System.out.println("\nBreakdown with friends:");

        Map<String, Balance> friendsBalance = balanceSheet.getFriendsBalance();

        for (Map.Entry<String, Balance> entry : friendsBalance.entrySet()) {
            String friendId = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("User ID: " + friendId);
            System.out.println("Amount Owe: " + balance.getAmountOwe());
            System.out.println("Amount Get Back: " + balance.getAmountGetBack());
            System.out.println("------------------------------------------");
        }
    }
}
