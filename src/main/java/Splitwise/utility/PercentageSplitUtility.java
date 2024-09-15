package Splitwise.utility;

import Splitwise.entity.Split;

import java.util.List;

public class PercentageSplitUtility implements IExpenseSplit{
    @Override
    public boolean validateRequest(List<Split> splitList, double totalAmount) {
        double splitSumPercentage = 0.0;

        for(Split split : splitList){
            splitSumPercentage += split.getPercentage();
        }

        return splitSumPercentage == 100;
    }
}
