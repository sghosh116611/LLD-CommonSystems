package PaymentGateway.controller;

import PaymentGateway.DTO.TransactionDTO;
import PaymentGateway.entity.Transaction;
import PaymentGateway.service.TransactionService;

import java.util.List;

public class TransactionController {

    private TransactionService transactionService;
    public TransactionController(){
        transactionService = new TransactionService();
    }

    public TransactionDTO makePayment(TransactionDTO transactionDTO){
        return transactionService.makePayment(transactionDTO);
    }

    public List<Transaction> getTransactionHistory(int userID){
       return transactionService.getTransactionHistory(userID);
    }
}
