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
        if (parkingTicketMap.containsKey(parkingTicket)) {
            Car car = parkingTicketMap.get(parkingTicket);
            parkingTicketMap.remove(parkingTicket);
            return car;
        }
        return null;
    }
}
