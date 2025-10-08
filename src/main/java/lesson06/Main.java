package lesson06;

import lesson06.model.Airplane;
import lesson06.service.BookingService;

public class Main {
    public static void main(String[] args) {
        Airplane airplane = new Airplane("Airubus A397");
        BookingService bookingService = new BookingService(airplane);
        bookingService.start();
    }
}
