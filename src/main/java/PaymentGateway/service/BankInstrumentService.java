package PaymentGateway.service;

import PaymentGateway.DTO.InstrumentDTO;
import PaymentGateway.entity.BankInstrument;
import PaymentGateway.entity.Instrument;
import PaymentGateway.entity.InstrumentType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankInstrumentService extends InstrumentService{
    @Override
    public InstrumentDTO addInstrument(InstrumentDTO instrumentDTO) {

        BankInstrument bankInstrument = new BankInstrument();
        bankInstrument.setInstrumentID((int) new Random().nextInt(100-10)+10);
        bankInstrument.setInstrumentType(InstrumentType.BANK);
        bankInstrument.setUserID(instrumentDTO.getUserID());

        List<Instrument> userInstrumentList = userToInstrumentsMapping.computeIfAbsent(bankInstrument.getUserID(), k -> new ArrayList<>());
        userInstrumentList.add(bankInstrument);

        return convertInstrumentToInstrumentDTO(bankInstrument);
    }

    @Override
    public List<InstrumentDTO> getInstrument(int userID) {
        List<Instrument> userIntruments = userToInstrumentsMapping.get(userID);
        List<InstrumentDTO> userIntrumentsFetched = new ArrayList<>();
        for(Instrument instrument: userIntruments){
            if(instrument.getInstrumentType() == InstrumentType.BANK){
                userIntrumentsFetched.add(convertInstrumentToInstrumentDTO(instrument));
            }
        }
        return userIntrumentsFetched;
    }
}
