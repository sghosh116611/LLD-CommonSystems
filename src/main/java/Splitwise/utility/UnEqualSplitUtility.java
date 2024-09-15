package Splitwise.utility;

import Splitwise.entity.Split;

import java.util.List;

public class UnEqualSplitUtility implements IExpenseSplit{
    @Override
    public boolean validateRequest(List<Split> splitList, double totalAmount) {
        double splitSum = 0.0;

        for (Split split : splitList) {
            splitSum += split.getAmount();
        }

        return splitSum == totalAmount;
    }
}
