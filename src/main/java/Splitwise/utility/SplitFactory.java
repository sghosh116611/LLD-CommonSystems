package Splitwise.utility;

import Splitwise.entity.SplitType;

public class SplitFactory {

    public static IExpenseSplit getSplitUtilityObject(SplitType splitType){
        if(splitType == SplitType.EQUAL)
            return new EqualSplitUtility();
        else if(splitType == SplitType.UNEQUAL)
            return new UnEqualSplitUtility();
        else
            return new PercentageSplitUtility();
    }
}
