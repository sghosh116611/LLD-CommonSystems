package Splitwise.utility;

import Splitwise.entity.Split;

import java.util.List;

public class EqualSplitUtility implements IExpenseSplit{
    @Override
    public boolean validateRequest(List<Split> splitList, double totalAmount) {

        double equalDivisionSum = (double) totalAmount / splitList.size();
        double splitSum = 0.0;

        for (Split split : splitList) {
            if (split.getAmount() != equalDivisionSum)
                return false;
            splitSum += split.getAmount();
        }

        return splitSum == totalAmount;
    }
}
