package com.parkinglot;

public class StandardParkingBoy {
    public ParkingTicket park(Car car,ParkingLot parkingLot) {
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket,ParkingLot parkingLot) {
        return parkingLot.fetch(parkingTicket);
    }
}
