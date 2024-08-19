package ParkingLot.interfaces;

import ParkingLot.entity.ParkingSpot;

import java.util.List;

public class ClosestToElevatorStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot find(List<ParkingSpot> parkingSpots) {
        return parkingSpots.get(0);
    }
}
