package ATM.entity.states;

import ATM.entity.ATM;
import ATM.entity.Card;
import ATM.entity.State;
import ATM.service.CashWithDrawalProcessor;
import ATM.service.FiveHundredCashWithdrawProcessor;
import ATM.service.OneHundredCashWithdrawProcessor;
import ATM.service.TwoThousandCashWithdrawProcessor;

public class CashWithDrawalState extends State {

    @Override
    public void withdrawCash(ATM atm, Card card, int cashToBeWithDrawn) {
        if (cashToBeWithDrawn > atm.getAmount()) {
            System.out.println("ATM doesnot have sufficient balance");
        } else if (cashToBeWithDrawn > card.getAmount()) {
            System.out.println("Your bank balance does not have the sufficient balance");
        } else {
            CashWithDrawalProcessor cashWithDrawalProcessor = new TwoThousandCashWithdrawProcessor(new FiveHundredCashWithdrawProcessor(new OneHundredCashWithdrawProcessor(null)));

            cashWithDrawalProcessor.withdraw(cashToBeWithDrawn);

            atm.setAmount(atm.getAmount() - cashToBeWithDrawn);
            card.setAmount(card.getAmount() - cashToBeWithDrawn);

            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setState(new IdleState());
        System.out.println("Exiting ATM");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
