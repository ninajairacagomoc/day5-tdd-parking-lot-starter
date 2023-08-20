package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedTicketException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void should_return_ticket_when_park_given_parkingLot_a_standard_parking_boy_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car car = new Car();
        //when
        ParkingTicket parkingTicket = standardParkingBoy.park(car,parkingLot);
        //then
        assertNotNull(parkingTicket);
    }

//    @Test
//    void should_return_the_car_when_fetch_given_parkingLot_and_a_ticket() {
//        //given
//        ParkingLot parkingLot = new ParkingLot();
//        Car car = new Car();
//        ParkingTicket parkingTicket = parkingLot.park(car);
//        //when
//        Car fetchCar = parkingLot.fetch(parkingTicket);
//        //then
//        assertEquals(car, fetchCar);
//    }
//
//    @Test
//    void should_return_the_right_car_with_each_ticket_when_fetch_car_twice_given_a_parkingLot_and_two_parked_tickets() {
//        //given
//        ParkingLot parkingLot = new ParkingLot();
//        Car firstCar = new Car();
//        Car secondCar = new Car();
//        ParkingTicket parkingTicketFirst = parkingLot.park(firstCar);
//        ParkingTicket parkingTicketSecond = parkingLot.park(secondCar);
//        //when
//        Car fetchCarFirst = parkingLot.fetch(parkingTicketFirst);
//        Car fetchCarSecond = parkingLot.fetch(parkingTicketSecond);
//        //then
//        assertEquals(firstCar, fetchCarFirst);
//        assertEquals(secondCar, fetchCarSecond);
//    }
//
//    @Test
//    void should_return_unrecognizedTicketException_when_fetch_the_car_given_a_parkingLot_and_a_wrong_parking_ticket() {
//        //given
//        ParkingLot parkingLot = new ParkingLot();
//        Car car = new Car();
//        parkingLot.park(car);
//        ParkingTicket wrongParkingTicket = new ParkingTicket();
//        //when
//        UnrecognizedTicketException unrecognizedTicketException = assertThrows(UnrecognizedTicketException.class, () ->
//                parkingLot.fetch(wrongParkingTicket));
//        //then
//        assertEquals("Unrecognized parkingTicket", unrecognizedTicketException.getMessage());
//    }
//
//    @Test
//    void should_return_UnrecognizedTicketException_when_fetch_the_car_given_a_parkingLot_and_a_used_parking_ticket() {
//        //given
//        ParkingLot parkingLot = new ParkingLot();
//        Car car = new Car();
//        ParkingTicket usedTicket = parkingLot.park(car);
//        parkingLot.fetch(usedTicket);
//        //when
//        UnrecognizedTicketException unrecognizedTicketException = assertThrows(UnrecognizedTicketException.class, () ->
//                parkingLot.fetch(usedTicket));
//        //then
//        assertEquals("Unrecognized parkingTicket", unrecognizedTicketException.getMessage());
//    }
//
//    @Test
//    void should_return_UnrecognizedTicketException_when_park_the_car_given_a_parkingLot_without_any_position() {
//        //given
//        ParkingLot parkingLot = new ParkingLot(1);
//        Car newCar = new Car();
//        Car parkedCar = new Car();
//        parkingLot.park(parkedCar);
//        //when
//        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, () -> {
//            parkingLot.park(newCar);
//        });
//        //then
//        assertEquals("No available parkingLot position", noAvailablePositionException.getMessage());
//    }
}
