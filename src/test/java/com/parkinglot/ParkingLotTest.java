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


}
