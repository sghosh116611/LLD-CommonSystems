package ParkingLot.entity;

import ParkingLot.service.ParkingSpotManagerFactory;

/*MVC Architecture
  Strategy Design Pattern - To determine the algorithm to park based on type of vechile*/
public class EntranceGate {
    private ParkingSpotManager parkingSpotManager;

    public ParkingSpotManager getParkingSpotManager() {
        return parkingSpotManager;
    }

    public void setParkingSpotManager(ParkingSpotManager parkingSpotManager) {
        this.parkingSpotManager = parkingSpotManager;
    }
}
