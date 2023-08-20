package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<ParkingTicket, Car> parkingTicketMap = new HashMap<>();
    private final int DEFAULT_CAPACITY =10;
    private final int capacity;

    public ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingTicket park(Car car) {
        if (isFull()){
            return null;
        }
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicketMap.put(parkingTicket, car);
        return parkingTicket;
    }

    private boolean isFull() {
        return parkingTicketMap.size() ==capacity;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (parkingTicketMap.get(parkingTicket) == null) {
            throw new UnrecognizedTicketException();
        }
        return parkingTicketMap.remove(parkingTicket);
    }
}
