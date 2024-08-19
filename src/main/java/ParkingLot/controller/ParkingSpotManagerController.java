package ParkingLot.controller;

import ParkingLot.entity.ParkingSpot;
import ParkingLot.entity.ParkingSpotManager;
import ParkingLot.entity.Vehicle;
import ParkingLot.service.ParkingSpotManagerService;

public class ParkingSpotManagerController {

    ParkingSpotManagerService parkingSpotManagerService;

    public ParkingSpotManagerController(){
        parkingSpotManagerService = new ParkingSpotManagerService();
    }

    public ParkingSpot findParkingSpot(ParkingSpotManager parkingSpotManager){
        return parkingSpotManagerService.findParkingSpot(parkingSpotManager);
    }

    public ParkingSpot parkVehicle(ParkingSpot parkingSpot, Vehicle vehicle){
        return parkingSpotManagerService.parkVehicle(parkingSpot, vehicle);
    }

    public ParkingSpot addParkingSpace(ParkingSpotManager parkingSpotManager, ParkingSpot parkingSpot){
        return parkingSpotManagerService.addParkingSpace(parkingSpotManager, parkingSpot);
    }
    public ParkingSpot removeVehicle(Vehicle vehicle, ParkingSpotManager parkingSpotManager){
        return parkingSpotManagerService.removeVehicle(vehicle, parkingSpotManager);
    }
}
