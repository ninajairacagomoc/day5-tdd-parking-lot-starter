package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedTicketException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @Test
    void should_return_parked_cars__when_park_given_a_super_parking_boy_and_parking_lots_two_parked_cars_and_two_parking_tickets() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(10);
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingTicket firstParkingTicket = firstParkingLot.park(firstCar);
        ParkingTicket secondparkingTicket = secondParkingLot.park(secondCar);
        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);

        //when
        Car fetchFirstCar = superParkingBoy.fetch(firstParkingTicket,firstParkingLot);
        Car fetchSecondCar= superParkingBoy.fetch(secondparkingTicket,secondParkingLot);
        //then
        Assertions.assertEquals(firstCar,fetchFirstCar);
        Assertions.assertEquals(secondCar,fetchSecondCar);
    }
    @Test
    void should_return_right_cars__when_fetch_given_a_super_parking_boy_and_parking_lots_two_parked_cars_and_two_parking_tickets() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingTicket firstParkingTicket = firstParkingLot.park(firstCar);
        ParkingTicket secondparkingTicket = secondParkingLot.park(secondCar);
        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);

        //when
        Car fetchFirstCar = superParkingBoy.fetch(firstParkingTicket,firstParkingLot);
        Car fetchSecondCar= superParkingBoy.fetch(secondparkingTicket,secondParkingLot);
        //then
        Assertions.assertEquals(firstCar,fetchFirstCar);
        Assertions.assertEquals(secondCar,fetchSecondCar);
    }
    @Test
    void should_return_nothing_with_Unrecognized_parking_ticket_when_fetch_given_a_super_parking_boy_and_parking_lots_and_a_used_parking_ticket() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        Car firstCar = new Car();
        Car secondCar = new Car();
        firstParkingLot.park(firstCar);
        secondParkingLot.park(secondCar);
        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);
        ParkingTicket usedParkingTicket = firstParkingLot.park(firstCar);
        superParkingBoy.fetch(usedParkingTicket,firstParkingLot);

        //when
        UnrecognizedTicketException unrecognizedTicketException = assertThrows(UnrecognizedTicketException.class, () ->
                superParkingBoy.fetch(usedParkingTicket,firstParkingLot)
        );
        //then
        assertEquals("Unrecognized parkingTicket", unrecognizedTicketException.getMessage());
    }
    @Test
    void should_return_nothing_with_No_available_position_when_park_given_a_super_parking_boy_and_two_parking_lot_and_both_without_position_and_a_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(0);
        ParkingLot secondParkingLot = new ParkingLot(0);
        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);
        Car car = new Car();
        //when
        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, () ->
                superParkingBoy.park(car)
        );
        //then
        assertEquals("No available parkingLot position", noAvailablePositionException.getMessage());
    }


}
