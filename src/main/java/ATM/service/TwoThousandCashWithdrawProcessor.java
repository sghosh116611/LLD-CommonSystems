package ATM.service;

import ATM.entity.ATM;

public class TwoThousandCashWithdrawProcessor extends CashWithDrawalProcessor{

    public TwoThousandCashWithdrawProcessor(CashWithDrawalProcessor nextCashWithDrawalProcessor) {
        super(nextCashWithDrawalProcessor);
    }

    @Override
    public void withdraw(int remainingAmount) {
        int notes = remainingAmount / 2000;
        System.out.println("2k notes --" + notes);
        remainingAmount %= 2000;

        if(remainingAmount != 0)
            super.withdraw(remainingAmount);
    }
}
