package ParkingLot.interfaces;

import ParkingLot.entity.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {

    public ParkingSpot find(List<ParkingSpot> parkingSpots);
}
