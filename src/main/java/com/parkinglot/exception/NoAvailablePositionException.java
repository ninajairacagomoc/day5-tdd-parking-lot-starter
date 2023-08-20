package com.parkinglot.exception;

public class NoAvailablePositionException extends RuntimeException{
    public NoAvailablePositionException(){
        super("No available parkingLot position");
    }
}
