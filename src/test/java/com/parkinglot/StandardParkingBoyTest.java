package com.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StandardParkingBoyTest {
    @Test
    void should_park_to_first_parking_lot_when_park_given_a_standard_parking_boy_and_two_parking_lots_and_a_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car car = new Car();
        //when
        ParkingTicket parkingTicket = standardParkingBoy.park(car);
        //then
        Assertions.assertNotNull(parkingTicket);
        Assertions.assertEquals(9, firstParkingLot.getAvailableCapacity());
        Assertions.assertEquals(10, secondParkingLot.getAvailableCapacity());
    }

    @Test
    void should_park_to_second_parking_lot_when_park_given_a_standard_parking_boy_and_first_is_full_and_second_isnot_and_a_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot();
        firstParkingLot.park(new Car());
        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car car = new Car();
        //when
        ParkingTicket parkingTicket = standardParkingBoy.park(car);

        //then
        Assertions.assertNotNull(parkingTicket);
        Assertions.assertEquals(0, firstParkingLot.getAvailableCapacity());
        Assertions.assertEquals(9, secondParkingLot.getAvailableCapacity());
    }
    @Test
    void should_return_the_right_car_when_fetch_given_a_standard_parking_boy_and_two_parking_lot_and_two_tickets() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingTicket firstCarParkingTicket = firstParkingLot.park(firstCar);
        ParkingTicket secondCarParkingTicket =secondParkingLot.park(secondCar);
        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        //when
        Car fetchCarFirst = standardParkingBoy.fetch(firstCarParkingTicket,firstParkingLot);
        Car fetchCarSecond = standardParkingBoy.fetch(secondCarParkingTicket,secondParkingLot);

        //then
        Assertions.assertEquals(firstCar, fetchCarFirst);
        Assertions.assertEquals(secondCar, fetchCarSecond);
    }
}
