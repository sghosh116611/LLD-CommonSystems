package ATM.utils;

import ATM.entity.TransactionType;

public class Utilities {

    public static TransactionType getTransactionTypeFromUserChoice(Integer userChoice){
        return switch (userChoice) {
            case 1 -> TransactionType.CASH_WITHDRAWAL;
            case 2 -> TransactionType.BALANCE_CHECK;
            case 3 -> TransactionType.CHANGE_PIN;
            default -> null;
        };
    }
}
