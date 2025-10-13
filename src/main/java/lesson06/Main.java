package lesson06;

import lesson06.model.Airplane;
import lesson06.service.BookingService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime flightDate = LocalDateTime.now().plusDays(3).withHour(14).withMinute(30).withSecond(0).withNano(0);

        Airplane airplane = new Airplane("Airbus A397", flightDate);
        BookingService bookingService = new BookingService(airplane);
        bookingService.start();
    }
}
