package lesson06.model;

import lesson06.model.enums.SeatStatus;
import lesson06.model.enums.TravelClass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Seat {
    private Passenger passenger;
    private final TravelClass travelClass;
    private final String seatNumber;
    private SeatStatus status;
    private LocalDateTime bookingDateTime;

    public Seat(TravelClass travelClass, String seatNumber) {
        this.travelClass = travelClass;
        this.seatNumber = seatNumber;
        this.status = SeatStatus.FREE;
        this.bookingDateTime = null;
    }

    public boolean isBooked() {
        return passenger != null;
    }

    public boolean isFree() {
        return status == SeatStatus.FREE;
    }

    public void pay() {
        if (status == SeatStatus.BOOKED) {
            this.status = SeatStatus.PAID;
        }
    }

    public void cancel() {
        this.passenger = null;
        this.status = SeatStatus.FREE;
        this.bookingDateTime = null;
    }

    public boolean isExpired() {
        if (status != SeatStatus.BOOKED || bookingDateTime == null) {
            return false;
        }
        return LocalDateTime.now().isAfter(bookingDateTime.plusMinutes(24));
    }

    public void book(Passenger passenger) {
        this.passenger = passenger;
        this.status = SeatStatus.BOOKED;
        this.bookingDateTime = LocalDateTime.now();
    }
}