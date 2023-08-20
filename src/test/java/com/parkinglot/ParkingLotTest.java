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

    @Test
    void should_return_the_car_when_fetch_given_parkingLot_a_standard_parking_boy_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car car = new Car();
        ParkingTicket parkingTicket = standardParkingBoy.park(car,parkingLot);
        //when
        Car fetchCar = standardParkingBoy.fetch(parkingTicket,parkingLot);
        //then
        assertEquals(car, fetchCar);
    }
    @Test
    void should_return_the_right_car_with_each_ticket_when_fetch_car_twice_given_a_parkingLot_a_standard_parking_boy_and_two_parked_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingTicket parkingTicketFirst = standardParkingBoy.park(firstCar,parkingLot);
        ParkingTicket parkingTicketSecond = standardParkingBoy.park(secondCar,parkingLot);
        //when
        Car fetchCarFirst = standardParkingBoy.fetch(parkingTicketFirst,parkingLot);
        Car fetchCarSecond = standardParkingBoy.fetch(parkingTicketSecond,parkingLot);
        //then
        assertEquals(firstCar, fetchCarFirst);
        assertEquals(secondCar, fetchCarSecond);
    }
    @Test
    void should_return_unrecognizedTicketException_when_fetch_the_car_given_a_parkingLot_a_standard_parking_boy_and_a_wrong_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car car = new Car();
        standardParkingBoy.park(car,parkingLot);
        ParkingTicket wrongParkingTicket = new ParkingTicket();
        //when
        UnrecognizedTicketException unrecognizedTicketException = assertThrows(UnrecognizedTicketException.class, () ->
                standardParkingBoy.fetch(wrongParkingTicket,parkingLot));
        //then
        assertEquals("Unrecognized parkingTicket", unrecognizedTicketException.getMessage());
    }
    @Test
    void should_return_UnrecognizedTicketException_when_fetch_the_car_given_a_parkingLot_a_standard_parking_boy_and_a_used_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car car = new Car();
        ParkingTicket usedTicket = standardParkingBoy.park(car,parkingLot);
        standardParkingBoy.fetch(usedTicket,parkingLot);
        //when
        UnrecognizedTicketException unrecognizedTicketException = assertThrows(UnrecognizedTicketException.class, () ->
                standardParkingBoy.fetch(usedTicket,parkingLot));
        //then
        assertEquals("Unrecognized parkingTicket", unrecognizedTicketException.getMessage());
    }
    @Test
    void should_return_no_available_position_exception_when_park_the_car_given_a_parkingLot__a_standard_parking_boy_and_a_car_without_any_position() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car newCar = new Car();
        Car parkedCar = new Car();
        standardParkingBoy.park(parkedCar,parkingLot);
        //when
        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, () -> {
            standardParkingBoy.park(newCar,parkingLot);
        });
        //then
        assertEquals("No available parkingLot position", noAvailablePositionException.getMessage());
    }
}
