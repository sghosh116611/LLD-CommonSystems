package PaymentGateway.DTO;

import PaymentGateway.entity.TransactionStatus;

public class TransactionDTO {

    private int txnID;
    private int amount;
    private int senderUserID;
    private int receiverUserID;
    private int debitInstrumentID;
    private int creditInstrumentID;
    private TransactionStatus status;

    public int getTxnID() {
        return txnID;
    }

    public void setTxnID(int txnID) {
        this.txnID = txnID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSenderUserID() {
        return senderUserID;
    }

    public void setSenderUserID(int senderUserID) {
        this.senderUserID = senderUserID;
    }

    public int getReceiverUserID() {
        return receiverUserID;
    }

    public void setReceiverUserID(int receiverUserID) {
        this.receiverUserID = receiverUserID;
    }

    public int getDebitInstrumentID() {
        return debitInstrumentID;
    }

    public void setDebitInstrumentID(int debitInstrumentID) {
        this.debitInstrumentID = debitInstrumentID;
    }

    public int getCreditInstrumentID() {
        return creditInstrumentID;
    }

    public void setCreditInstrumentID(int creditInstrumentID) {
        this.creditInstrumentID = creditInstrumentID;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "txnID=" + txnID +
                ", amount=" + amount +
                ", senderUserID=" + senderUserID +
                ", receiverUserID=" + receiverUserID +
                ", debitInstrumentID=" + debitInstrumentID +
                ", creditInstrumentID=" + creditInstrumentID +
                ", status=" + status +
                '}';
    }
}

