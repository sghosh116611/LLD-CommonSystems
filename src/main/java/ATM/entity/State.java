package ATM.entity;

public abstract class State {

    public void insertCard(ATM atm, Card card){

    }

    public void authenticatePing(ATM atm, Card card){

    }

    public void selectOperation(ATM atm, Card card){

    }

    public void withdrawCash(ATM atm, Card card, int cashToBeWithDrawn){

    }

    public void displayBalance(ATM atm, Card card){

    }

    public void changePinState(ATM atm, Card card){

    }

    public void returnCard(){

    }

    public void exit(ATM atm){

    }

}
