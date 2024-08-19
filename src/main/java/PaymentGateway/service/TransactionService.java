package PaymentGateway.service;

import PaymentGateway.DTO.InstrumentDTO;
import PaymentGateway.DTO.TransactionDTO;
import PaymentGateway.controller.InstrumentController;
import PaymentGateway.entity.*;

import java.util.*;

public class TransactionService {
    static Map<Integer, List<Transaction>> userTransactionDetails;
    private final InstrumentController instrumentController;
    private final Processor processor;

    public TransactionService() {
        userTransactionDetails = new HashMap<>();
        instrumentController = new InstrumentController();
        processor = new Processor();
    }

    public TransactionDTO makePayment(TransactionDTO transactionDTO) {
        // Validate details

        // fetch the sender instrument
        InstrumentDTO senderInstrumentDTO = instrumentController.getInstrumentByID(transactionDTO.getDebitInstrumentID(), transactionDTO.getSenderUserID());
        // fetch the receiver instrument
        InstrumentDTO receiverInstrumentDTO = instrumentController.getInstrumentByID(transactionDTO.getCreditInstrumentID(), transactionDTO.getReceiverUserID());

        // Pass data to processor
        processor.process(senderInstrumentDTO, receiverInstrumentDTO);

        // Create transaction
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setTxnID((int) new Random().nextInt(100 - 10) + 10);
        transaction.setSenderUserID(transactionDTO.getSenderUserID());
        transaction.setReceiverUserID(transactionDTO.getReceiverUserID());
        transaction.setDebitInstrumentID(transactionDTO.getDebitInstrumentID());
        transaction.setCreditInstrumentID(transactionDTO.getCreditInstrumentID());
        transaction.setStatus(TransactionStatus.SUCCESS);

        List<Transaction> transactionList = userTransactionDetails.computeIfAbsent(transactionDTO.getSenderUserID(), k -> new ArrayList<>());
        transactionList.add(transaction);

        userTransactionDetails.put(transactionDTO.getSenderUserID(), transactionList);

        return convertTransactionToTransactionDTO(transaction);
    }


    public List<Transaction> getTransactionHistory(int userID) {
        return userTransactionDetails.get(userID);
    }


    private TransactionDTO convertTransactionToTransactionDTO(Transaction transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setTxnID((int) new Random().nextInt(100 - 10) + 10);
        transactionDTO.setSenderUserID(transaction.getSenderUserID());
        transactionDTO.setReceiverUserID(transaction.getReceiverUserID());
        transactionDTO.setDebitInstrumentID(transaction.getDebitInstrumentID());
        transactionDTO.setCreditInstrumentID(transaction.getCreditInstrumentID());
        transactionDTO.setStatus(transaction.getStatus());

        return transactionDTO;
    }
}
