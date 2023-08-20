package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;

import java.util.Comparator;
import java.util.List;

public class SuperParkingBoy implements ParkingBoy {
    private final List<ParkingLot> parkingLots;

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
@Override
    public Car fetch(ParkingTicket parkingTicket, ParkingLot parkingLot) {
        return parkingLot.fetch(parkingTicket);
    }
}
