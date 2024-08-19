package ATM.service;

import ATM.entity.ATM;
import ATM.entity.Card;

public abstract class CashWithDrawalProcessor {

    private CashWithDrawalProcessor nextCashWithDrawalProcessor;

    public CashWithDrawalProcessor(CashWithDrawalProcessor nextCashWithDrawalProcessor){
        this.nextCashWithDrawalProcessor = nextCashWithDrawalProcessor;
    }

    public void withdraw(int remainingAmount){
        if(nextCashWithDrawalProcessor != null){
            nextCashWithDrawalProcessor.withdraw(remainingAmount);
        }
    }
}
