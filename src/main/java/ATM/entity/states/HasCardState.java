package ATM.entity.states;

import ATM.entity.ATM;
import ATM.entity.Card;
import ATM.entity.State;

import java.util.Scanner;

public class HasCardState extends State {

    @Override
    public void authenticatePing(ATM atm, Card card) {
        System.out.println("Authenticating pin....");
        System.out.println("Enter your ping");
        String pin = new Scanner(System.in).nextLine();
        boolean isPinAuthenticated = pin.equalsIgnoreCase(card.getPin());
        if (isPinAuthenticated) {
            System.out.println("Ping authenticated");
            atm.setState(new CardAuthenticatedState());
        } else {
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
