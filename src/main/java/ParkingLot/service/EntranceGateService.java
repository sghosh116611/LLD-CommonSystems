package ParkingLot.service;

import ParkingLot.controller.ParkingSpotManagerController;
import ParkingLot.entity.*;

public class EntranceGateService {

    private ParkingSpotManagerController parkingSpotManagerController;

    public EntranceGateService(){
        parkingSpotManagerController = new ParkingSpotManagerController();
    }

    public void setParkingSpotManager(EntranceGate entranceGate, Vehicle vehicle){
        entranceGate.setParkingSpotManager(new ParkingSpotManagerFactory().getParkingSpotManager(vehicle.getVehicleType()));
    }

    public ParkingSpot findParkingSpot(ParkingSpotManager parkingSpotManager){
        return parkingSpotManagerController.findParkingSpot(parkingSpotManager);
    }

    public ParkingSpot parkVehicle(ParkingSpot parkingSpot, Vehicle vehicle){
        return parkingSpotManagerController.parkVehicle(parkingSpot,vehicle);
    }
}
