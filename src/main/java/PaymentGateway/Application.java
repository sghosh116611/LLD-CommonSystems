package PaymentGateway;

import PaymentGateway.DTO.InstrumentDTO;
import PaymentGateway.DTO.TransactionDTO;
import PaymentGateway.DTO.UserDTO;
import PaymentGateway.controller.InstrumentController;
import PaymentGateway.controller.TransactionController;
import PaymentGateway.controller.UserController;
import PaymentGateway.entity.InstrumentType;
import PaymentGateway.entity.Transaction;
import PaymentGateway.entity.User;

import java.util.List;
import java.util.Random;

public class Application {

    /*

    MVC Architecture ,
    Factory Design Pattern -> To determine the type of instrument,

    */
    public static void main(String[] args) {
        UserController userController = new UserController();
        InstrumentController instrumentController = new InstrumentController();
        TransactionController transactionController = new TransactionController();

        //1. Create User 1
        UserDTO user1 = new UserDTO();
        user1.setName("Jitu");
        user1.setEmail("ghoshsoumojit53@gmail.com");
        UserDTO user1Detail = userController.addUser(user1);

        //1. Create User 2
        UserDTO user2 = new UserDTO();
        user2.setName("Enigma");
        user2.setEmail("enigmakaen@gmail.com");
        UserDTO user2Detail = userController.addUser(user2);

        // Add bank to user1
        InstrumentDTO bankInstrumentDTO = new InstrumentDTO();
        bankInstrumentDTO.setInstrumentType(InstrumentType.BANK);
        bankInstrumentDTO.setUserID(user1Detail.getUserID());
        bankInstrumentDTO.setInstrumentID((int) new Random().nextInt(100-10)+10);
        InstrumentDTO bankInstrumentDTODetails = instrumentController.addInstrument(bankInstrumentDTO);
        System.out.println("User 1 bank instrument details ----->"+ bankInstrumentDTODetails.toString());

        // Add card to user2
        InstrumentDTO cardInstrumentDTO = new InstrumentDTO();
        cardInstrumentDTO.setInstrumentType(InstrumentType.CARD);
        cardInstrumentDTO.setUserID(user2Detail.getUserID());
        cardInstrumentDTO.setInstrumentID((int) new Random().nextInt(100-10)+10);
        InstrumentDTO cardInstrumentDTODetails = instrumentController.addInstrument(cardInstrumentDTO);
        System.out.println("User 2 card instrument details ----->"+ cardInstrumentDTODetails.toString());

        // Make payment
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setAmount(10);
        transactionDTO.setSenderUserID(user1Detail.getUserID());
        transactionDTO.setDebitInstrumentID(bankInstrumentDTODetails.getInstrumentID());
        transactionDTO.setReceiverUserID(user2Detail.getUserID());
        transactionDTO.setCreditInstrumentID(cardInstrumentDTODetails.getInstrumentID());
        TransactionDTO transactionDTODetails = transactionController.makePayment(transactionDTO);

        System.out.println("Transaction history---");
        List<Transaction> transactionHistory =  transactionController.getTransactionHistory(user1Detail.getUserID());
        for(Transaction transaction : transactionHistory){
            System.out.println(transaction.toString());
        }
    }


}
