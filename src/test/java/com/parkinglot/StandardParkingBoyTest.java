package com.parkinglot;

import com.parkinglot.exception.UnrecognizedTicketException;
import com.parkinglot.exception.NoAvailablePositionException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void should_park_to_second_parking_lot_when_park_given_a_standard_parking_boy_and_first_is_full_and_second_is_not_and_a_car() {
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
        ParkingTicket secondCarParkingTicket = secondParkingLot.park(secondCar);
        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        //when
        Car fetchCarFirst = standardParkingBoy.fetch(firstCarParkingTicket, firstParkingLot);
        Car fetchCarSecond = standardParkingBoy.fetch(secondCarParkingTicket, secondParkingLot);

        //then
        Assertions.assertEquals(firstCar, fetchCarFirst);
        Assertions.assertEquals(secondCar, fetchCarSecond);
    }

    @Test
    void should_return_nothing_with_Unrecognized_parking_ticket_when_fetch_given_a_standard_parking_boy_and_two_parking_lot_and_unrecognizable_ticket() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        Car firstCar = new Car();
        Car secondCar = new Car();
        firstParkingLot.park(firstCar);
        secondParkingLot.park(secondCar);
        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();
        //when
        UnrecognizedTicketException unrecognizedTicketException = assertThrows(UnrecognizedTicketException.class, () ->
                standardParkingBoy.fetch(unrecognizedParkingTicket, firstParkingLot)
        );
        //then
        assertEquals("Unrecognized parkingTicket", unrecognizedTicketException.getMessage());
    }

    @Test
    void should_return_nothing_with_Unrecognized_parking_ticket_when_fetch_given_a_standard_parking_boy_and_two_parking_lot_and_a_used_ticket() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car firstCar = new Car();
        ParkingTicket usedParkingTicket = standardParkingBoy.park(firstCar);
        standardParkingBoy.fetch(usedParkingTicket, firstParkingLot);

        //when
        UnrecognizedTicketException unrecognizedTicketException = assertThrows(UnrecognizedTicketException.class, () ->
                standardParkingBoy.fetch(usedParkingTicket, firstParkingLot)
        );
        //then
        assertEquals("Unrecognized parkingTicket", unrecognizedTicketException.getMessage());
    }

    @Test
    void should_return_nothing_with_No_available_position_when_park_given_a_standard_parking_boy_and_two_parking_lot_and_both_without_position_and_a_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(0);
        ParkingLot secondParkingLot = new ParkingLot(0);
        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car car = new Car();
        //when
        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, () ->
                standardParkingBoy.park(car, secondParkingLot)
        );
        //then
        assertEquals("No available parkingLot position", noAvailablePositionException.getMessage());
    }
}
