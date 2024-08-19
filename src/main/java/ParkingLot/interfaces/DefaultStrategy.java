package ParkingLot.interfaces;

import ParkingLot.entity.ParkingSpot;

import java.util.List;

public class DefaultStrategy implements ParkingStrategy{

    @Override
    public ParkingSpot find(List<ParkingSpot> parkingSpots) {
        return parkingSpots.get(0);
    }
}
