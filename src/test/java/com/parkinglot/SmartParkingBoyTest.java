package com.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoyTest {
    @Test
    void should_park_to_more_empty_parking_lot_when_park_given_a_smart_parking_boy_and_two_parking_lots_and_a_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(3);
        ParkingLot secondParkingLot = new ParkingLot(5);
        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        ParkingTicket parkingTicket = smartParkingBoy.park(car);
        //then
        Assertions.assertNotNull(parkingTicket);
        Assertions.assertEquals(3, firstParkingLot.getAvailableCapacity());
        Assertions.assertEquals(4, secondParkingLot.getAvailableCapacity());
    }
    @Test
    void should_park_to_second_parking_lot_when_park_given_a_smart_parking_boy_and_first_is_full_and_second_is_not_and_a_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(10);
        firstParkingLot.park(new Car());
        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        ParkingTicket parkingTicket = smartParkingBoy.park(car);
        //then
        Assertions.assertNotNull(parkingTicket);
        Assertions.assertEquals(0, firstParkingLot.getAvailableCapacity());
        Assertions.assertEquals(9, secondParkingLot.getAvailableCapacity());
    }
    @Test
    void should_return_the_right_car_when_fetch_given_a_smart_parking_boy_and_two_parking_lot_and_two_tickets(){
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingTicket firstCarParkingTicket = firstParkingLot.park(firstCar);
        ParkingTicket secondCarParkingTicket = secondParkingLot.park(secondCar);
        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        Car fetchCarFirst = smartParkingBoy.fetch(firstCarParkingTicket, firstParkingLot);
        Car fetchCarSecond = smartParkingBoy.fetch(secondCarParkingTicket, secondParkingLot);
        //then
        Assertions.assertEquals(firstCar, fetchCarFirst);
        Assertions.assertEquals(secondCar, fetchCarSecond);
    }

}

