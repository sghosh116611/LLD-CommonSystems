package ATM.service;

public class FiveHundredCashWithdrawProcessor extends CashWithDrawalProcessor{

    public FiveHundredCashWithdrawProcessor(CashWithDrawalProcessor nextCashWithDrawalProcessor) {
        super(nextCashWithDrawalProcessor);
    }

    @Override
    public void withdraw(int remainingAmount) {
        int notes = remainingAmount / 500;
        System.out.println("500 notes --" + notes);
        remainingAmount %= 500;

        if(remainingAmount != 0)
            super.withdraw(remainingAmount);
    }
}
