package com.car.rental.exceptions;

public class BookingNotFoundException extends Exception {
    public BookingNotFoundException(String message) {
        super(message);
    }

    public BookingNotFoundException() {
    }
}
