package ParkingLot.service;

import ParkingLot.entity.ParkingSpot;
import ParkingLot.entity.ParkingSpotManager;
import ParkingLot.entity.Vehicle;

import java.util.List;
import java.util.Random;

public class ParkingSpotManagerService {

    public ParkingSpot findParkingSpot(ParkingSpotManager parkingSpotManager) {
        return parkingSpotManager.getParkingStrategy().find(parkingSpotManager.getParkingSpotList());
    }

    public ParkingSpot addParkingSpace(ParkingSpotManager parkingSpotManager, ParkingSpot parkingSpot) {
        List<ParkingSpot> parkingSpots = parkingSpotManager.getParkingSpotList();
        parkingSpots.add(parkingSpot);

        return parkingSpot;
    }

    public ParkingSpot removeParkingSpace(ParkingSpotManager parkingSpotManager, ParkingSpot parkingSpot) {
        List<ParkingSpot> parkingSpots = parkingSpotManager.getParkingSpotList();
        parkingSpots.remove(parkingSpot);

        return parkingSpot;
    }

    public ParkingSpot parkVehicle(ParkingSpot parkingSpot, Vehicle vehicle) {
        parkingSpot.setVehicle(vehicle);
        parkingSpot.setEmpty(true);

        return parkingSpot;
    }

    public ParkingSpot removeVehicle(Vehicle vehicle, ParkingSpotManager parkingSpotManager) {
        List<ParkingSpot> parkingSpotList = parkingSpotManager.getParkingSpotList();
        for (ParkingSpot parkingSpot : parkingSpotList) {
            if (parkingSpot.getVehicle() == vehicle) {
                parkingSpot.setVehicle(null);
                parkingSpot.setEmpty(true);
                return parkingSpot;
            }
        }
        return null;
    }
}
