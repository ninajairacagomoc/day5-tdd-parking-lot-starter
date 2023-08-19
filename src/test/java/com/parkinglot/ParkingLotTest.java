package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {

    @Test
    void should_return_ticket_when_park_given_parkingLot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        ParkingTicket parkingTicket = parkingLot.park(car);
        //then
        assertNotNull(parkingTicket);
    }

//    @Test
//    void should_return_the_car_when_fetch_given_parkingLot_and_a_ticket() {
//        //given
//        ParkingLot parkingLot = new ParkingLot();
//        Car car = new Car();
//        ParkingTicket parkingTicket = new ParkingTicket();
//        //when
//        Car fetchCar = parkingLot.fetch(parkingTicket);
//        //then
//        assertEquals(car,fetchCar);
//    }
}
