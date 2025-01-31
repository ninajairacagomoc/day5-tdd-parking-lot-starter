package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;

import java.util.List;

public class StandardParkingBoy implements ParkingBoy{

    private List<ParkingLot> parkingLots;

    public StandardParkingBoy(List<ParkingLot> parkingLots) {

        this.parkingLots = parkingLots;
    }

    public StandardParkingBoy() {

    }
    public ParkingTicket park(Car car, ParkingLot parkingLot) {
        return parkingLot.park(car);
    }
    @Override
    public Car fetch(ParkingTicket parkingTicket, ParkingLot parkingLot) {
        return parkingLot.fetch(parkingTicket);
    }

    public ParkingTicket park(Car car) {
        return parkingLots.stream()
                .filter(ParkingLot::hasAvailableCapacity)
                .findFirst()
                .orElseThrow(NoAvailablePositionException::new)
                .park(car);
    }
}