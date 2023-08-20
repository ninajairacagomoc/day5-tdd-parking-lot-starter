package com.parkinglot;

import com.parkinglot.exception.UnrecognizedTicketException;
import com.parkinglot.exception.NoAvailablePositionException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<ParkingTicket, Car> parkingTicketMap = new HashMap<>();
    private final int capacity;

    public ParkingLot() {
        this.capacity = 10;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingTicket park(Car car) {
        if (isFull()) {
            throw new NoAvailablePositionException();
        }
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicketMap.put(parkingTicket, car);
        return parkingTicket;
    }

    private boolean isFull() {
        return parkingTicketMap.size() == capacity;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (parkingTicketMap.get(parkingTicket) == null) {
            throw new UnrecognizedTicketException();
        }
        return parkingTicketMap.remove(parkingTicket);
    }


    public int getAvailableCapacity() {
        return capacity - parkingTicketMap.size();
    }

    public boolean hasAvailableCapacity() {
        return !isFull();
    }

    public double getTotalCapacity() {
        return capacity;
    }
}
