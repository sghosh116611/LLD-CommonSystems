package PaymentGateway.service;

import PaymentGateway.DTO.InstrumentDTO;
import PaymentGateway.entity.BankInstrument;
import PaymentGateway.entity.Instrument;
import PaymentGateway.entity.InstrumentType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardInstrument extends InstrumentService{
    @Override
    public InstrumentDTO addInstrument(InstrumentDTO instrumentDTO) {
        BankInstrument bankInstrument = new BankInstrument();
        bankInstrument.setInstrumentID((int) new Random().nextInt(100-10)+10);
        bankInstrument.setInstrumentType(InstrumentType.CARD);
        bankInstrument.setUserID(instrumentDTO.getUserID());

        List<Instrument> userInstrumentList = userToInstrumentsMapping.computeIfAbsent(bankInstrument.getUserID(), k -> new ArrayList<>());
        userInstrumentList.add(bankInstrument);

        return convertInstrumentToInstrumentDTO(bankInstrument);
    }

    @Override
    public List<InstrumentDTO> getInstrument(int userID) {
        List<Instrument> userInstruments = userToInstrumentsMapping.get(userID);
        List<InstrumentDTO> userInstrumentsFetched = new ArrayList<>();
        for(Instrument instrument: userInstruments){
            if(instrument.getInstrumentType() == InstrumentType.CARD){
                userInstrumentsFetched.add(convertInstrumentToInstrumentDTO(instrument));
            }
        }
        return userInstrumentsFetched;
    }
}
