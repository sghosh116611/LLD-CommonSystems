package ATM.entity.states;

import ATM.entity.ATM;
import ATM.entity.Card;
import ATM.entity.State;

public class IdleState extends State {
    @Override
    public void insertCard(ATM atm, Card card){
        System.out.println("Card inserted");
        atm.setState(new HasCardState());
    }
}
