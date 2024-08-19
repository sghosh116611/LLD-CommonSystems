package PaymentGateway.service;

import PaymentGateway.entity.InstrumentType;

public class InstrumentServiceFactory {

    public InstrumentService getInstrumentService(InstrumentType instrumentType){
        if(instrumentType == InstrumentType.BANK)
            return new BankInstrumentService();
        else if(instrumentType == InstrumentType.CARD)
            return new CardInstrument();
        else
            return null;
    }
}
