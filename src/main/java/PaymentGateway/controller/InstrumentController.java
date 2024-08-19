package PaymentGateway.controller;

import PaymentGateway.DTO.InstrumentDTO;
import PaymentGateway.entity.InstrumentType;
import PaymentGateway.service.InstrumentService;
import PaymentGateway.service.InstrumentServiceFactory;

import java.util.List;

public class InstrumentController {
    private InstrumentServiceFactory instrumentServiceFactory;

    public InstrumentController() {
        instrumentServiceFactory = new InstrumentServiceFactory();
    }

    public InstrumentDTO addInstrument(InstrumentDTO instrumentDTO) {

        InstrumentService instrumentService = instrumentServiceFactory.getInstrumentService(instrumentDTO.getInstrumentType());

        return instrumentService.addInstrument(instrumentDTO);
    }

    public List<InstrumentDTO> getAllInstruments(int userID) {
        InstrumentService bankInstrumentService = instrumentServiceFactory.getInstrumentService(InstrumentType.BANK);
        InstrumentService cardInstrumentService = instrumentServiceFactory.getInstrumentService(InstrumentType.CARD);

        List<InstrumentDTO> userAllInstruments = bankInstrumentService.getInstrument(userID);
        userAllInstruments.addAll(cardInstrumentService.getInstrument(userID));

        return userAllInstruments;
    }

    public InstrumentDTO getInstrumentByID(int instrumentID, int userID){
        List<InstrumentDTO> allInstruments = this.getAllInstruments(userID);
        for(InstrumentDTO instrumentDTO : allInstruments){
            if(instrumentDTO.getInstrumentID() == instrumentID){
                return instrumentDTO;
            }
        }
        return null;
    }
}
