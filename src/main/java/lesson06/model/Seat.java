package lesson06.model;

import lesson06.model.enums.TravelClass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Seat {
    private Passenger passenger;
    private final TravelClass travelClass;
    private final String seatNumber;

    public Seat(TravelClass travelClass, String seatNumber) {
        this.travelClass = travelClass;
        this.seatNumber = seatNumber;
    }

    public boolean isBooked() {
        return passenger != null;
    }
}