package ParkingLot.controller;

import ParkingLot.entity.EntranceGate;
import ParkingLot.entity.ParkingSpot;
import ParkingLot.entity.ParkingSpotManager;
import ParkingLot.entity.Vehicle;
import ParkingLot.service.EntranceGateService;
import ParkingLot.service.ParkingSpotManagerFactory;

public class EntranceGateController {

    private final EntranceGateService entranceGateService;

    EntranceGateController(){
        entranceGateService = new EntranceGateService();
    }

    public void setParkingSpotManager(EntranceGate entranceGate, Vehicle vehicle){
        entranceGateService.setParkingSpotManager(entranceGate, vehicle);
    }

    public ParkingSpot findParkingSpot(ParkingSpotManager parkingSpotManager){
        return entranceGateService.findParkingSpot(parkingSpotManager);
    }

    public ParkingSpot parkVehicle(ParkingSpot parkingSpot, Vehicle vehicle){
        return entranceGateService.parkVehicle(parkingSpot,vehicle);
    }
}
