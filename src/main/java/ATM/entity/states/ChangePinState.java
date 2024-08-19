package ATM.entity.states;

import ATM.entity.ATM;
import ATM.entity.Card;
import ATM.entity.State;

import java.util.Scanner;

public class ChangePinState extends State {

    @Override
    public void changePinState(ATM atm, Card card) {
        System.out.println("Enter new pin");
        String pin = new Scanner(System.in).nextLine();
        card.setPin(pin);

        exit(atm);
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
