package com.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SuperParkingBoyTest {
    @Test
    void should_park_to_larger_possible_position_rate_when_park_given_a_super_parking_boy_and_two_parking_lots_and_a_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(3);
        ParkingLot secondParkingLot = new ParkingLot(5);
        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);
        Car car = new Car();
        //when
        ParkingTicket parkingTicket = superParkingBoy.park(car);
        //then
        Assertions.assertNotNull(parkingTicket);
        Assertions.assertEquals(2, firstParkingLot.getAvailableCapacity());
        Assertions.assertEquals(5, secondParkingLot.getAvailableCapacity());
    }
}
