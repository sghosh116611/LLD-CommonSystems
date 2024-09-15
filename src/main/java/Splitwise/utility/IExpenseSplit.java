package Splitwise.utility;

import Splitwise.entity.Split;

import java.util.List;

public interface IExpenseSplit {

    public default void computeAmount(List<Split> splitList, double totalAmount){
        for(Split split : splitList){
            double splitAmount = (split.getPercentage() / 100) * totalAmount;
            split.setAmount(splitAmount);
        }
    }

    public boolean validateRequest(List<Split> splitList, double totalAmount);
}
