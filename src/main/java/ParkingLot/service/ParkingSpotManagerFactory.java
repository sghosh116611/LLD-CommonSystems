package ParkingLot.service;

import ParkingLot.entity.FourWheelerParkingSpotManager;
import ParkingLot.entity.ParkingSpotManager;
import ParkingLot.entity.TwoWheelerParkingSpotManager;
import ParkingLot.entity.VehicleType;
import ParkingLot.interfaces.ClosestToElevatorStrategy;
import ParkingLot.interfaces.ClosestToGateStrategy;
import ParkingLot.interfaces.DefaultStrategy;

import java.util.ArrayList;

public class ParkingSpotManagerFactory {

    public ParkingSpotManager getParkingSpotManager(VehicleType vehicleType){
        if(vehicleType == VehicleType.TWOWHELLER){
            return new TwoWheelerParkingSpotManager(new ArrayList<>(), new ClosestToElevatorStrategy());
        }else if(vehicleType == VehicleType.FOURWHEELER){
            return new FourWheelerParkingSpotManager(new ArrayList<>(), new ClosestToGateStrategy());
        }else{
            return new ParkingSpotManager(new ArrayList<>(), new DefaultStrategy());
        }
    }
}
