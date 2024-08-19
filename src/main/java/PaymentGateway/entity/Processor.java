package PaymentGateway.entity;

import PaymentGateway.DTO.InstrumentDTO;

public class Processor {

    public void process(InstrumentDTO senderInstrumentDTO, InstrumentDTO receiverInstrumentDTO) {
        System.out.println("Processed!");
    }
}
