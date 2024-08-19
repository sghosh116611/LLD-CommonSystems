package PaymentGateway.DTO;

import PaymentGateway.entity.InstrumentType;

public class InstrumentDTO {
    int instrumentID;
    int userID;
    InstrumentType instrumentType;

    public int getInstrumentID() {
        return instrumentID;
    }

    public void setInstrumentID(int instrumentID) {
        this.instrumentID = instrumentID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    @Override
    public String toString() {
        return "InstrumentDTO{" +
                "instrumentID=" + instrumentID +
                ", userID=" + userID +
                ", instrumentType=" + instrumentType +
                '}';
    }
}
