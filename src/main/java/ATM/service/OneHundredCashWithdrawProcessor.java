package ATM.service;

public class OneHundredCashWithdrawProcessor extends CashWithDrawalProcessor{

    public OneHundredCashWithdrawProcessor(CashWithDrawalProcessor nextCashWithDrawalProcessor) {
        super(nextCashWithDrawalProcessor);
    }

    @Override
    public void withdraw(int remainingAmount) {
        int notes = remainingAmount / 100;
        System.out.println("100 notes --" + notes);
        remainingAmount %= 100;

        if(remainingAmount != 0)
            super.withdraw(remainingAmount);
    }
}
