package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
//    @Test
//    void should(){
//        //given
//        //when
//        //then
//    }
@Test
void should_return_ticket_when_park_given_parkingLot_and_a_car(){
    //given
    ParkingLot parkingLot = new ParkingLot();
    Car car = new Car();
    //when
    ParkingTicket parkingTicket = new ParkingTicket();
    //then
    assertNotNull(parkingTicket);
}
}
