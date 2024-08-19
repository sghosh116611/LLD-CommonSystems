package ATM;

import ATM.entity.ATM;
import ATM.entity.Card;
import ATM.entity.states.IdleState;

import java.util.regex.Pattern;

public class Application {

    /*
    State Design Pattern - ATM states
    Chain of Responsibility Pattern - Cash withdrawal processor
    */
    public static void main(String[] args){
        ATM atm = new ATM();
        atm.setState(new IdleState());
        atm.setAmount(20000);

        Card card = new Card();
        card.setAmount(10000);
        card.setPin("####");

        atm.getState().insertCard(atm,card);
        atm.getState().authenticatePing(atm,card);
        atm.getState().selectOperation(atm,card);
        atm.getState().withdrawCash(atm,card,3900);

    }
}
