package PaymentGateway.service;

import PaymentGateway.DTO.InstrumentDTO;
import PaymentGateway.entity.Instrument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class InstrumentService {

    static Map <Integer, List<Instrument>> userToInstrumentsMapping = new HashMap<>();

    public abstract InstrumentDTO addInstrument(InstrumentDTO intrumentDTO);

    public abstract List<InstrumentDTO> getInstrument(int userID);

    public InstrumentDTO convertInstrumentToInstrumentDTO(Instrument instrument){
        InstrumentDTO instrumentDTO = new InstrumentDTO();
        instrumentDTO.setUserID(instrument.getUserID());
        instrumentDTO.setInstrumentType(instrument.getInstrumentType());
        instrumentDTO.setInstrumentID(instrument.getInstrumentID());

        return instrumentDTO;
    }
}
