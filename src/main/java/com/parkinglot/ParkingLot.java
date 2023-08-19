package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    public final Map<ParkingTicket, Car> parkingTicketMap = new HashMap<>();
    private Car car;

    public ParkingLot() {
    }

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicketMap.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkingTicketMap.remove(parkingTicket);
    }
}
