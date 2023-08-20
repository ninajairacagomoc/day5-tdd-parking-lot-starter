package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;

import java.util.Comparator;
import java.util.List;

public class SuperParkingBoy {
    private final List<ParkingLot> parkingLots;
    private Car car;

    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }


    public ParkingTicket park(Car car) {
        return parkingLots.stream()
                .max(Comparator.comparingDouble(parkingLot -> (double) 
                        parkingLot.getAvailableCapacity() / parkingLot.getTotalCapacity()))
                .orElseThrow(NoAvailablePositionException::new)
                .park(car);
    }

    public Car fetch(Car car) {
        return car;
    }
}
