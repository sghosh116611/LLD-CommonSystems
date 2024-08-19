package ATM.entity.states;

import ATM.entity.ATM;
import ATM.entity.Card;
import ATM.entity.State;

public class CheckBalanceState extends State {

    @Override
    public void displayBalance(ATM atm, Card card){
        System.out.println("Your bank balance---"+ card.getAmount());

        exit(atm);
    }

    @Override
    public void exit(ATM atm){
        returnCard();
        atm.setState(new IdleState());
        System.out.println("Exiting ATM");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }
}
