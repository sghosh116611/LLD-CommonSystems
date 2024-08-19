package ATM.entity.states;

import ATM.entity.ATM;
import ATM.entity.Card;
import ATM.entity.TransactionType;
import ATM.entity.State;
import ATM.utils.Utilities;

import java.util.Objects;
import java.util.Scanner;

public class CardAuthenticatedState extends State {

    @Override
    public void selectOperation(ATM atm, Card card){
        Scanner sc = new Scanner(System.in);

        System.out.println("Operations ---");
        System.out.println("1. Cash withdrawal");
        System.out.println("2. Check balance");
        System.out.println("3. Change pin");

        System.out.println("Enter choice");
        Integer userChoice = Integer.parseInt(sc.nextLine());
        TransactionType choice = Utilities.getTransactionTypeFromUserChoice(userChoice);

        switch (choice){
            case CASH_WITHDRAWAL:
                atm.setState(new CashWithDrawalState());
                break;
            case BALANCE_CHECK:
                atm.setState(new CheckBalanceState());
                break;
            case CHANGE_PIN:
                atm.setState(new ChangePinState());
                break;
            default:
                System.out.println("Invalid option");
                exit(atm);

        }
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
