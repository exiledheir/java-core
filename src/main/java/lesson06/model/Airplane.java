package lesson06.model;

import lesson06.model.enums.TravelClass;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Airplane {
    private final String name;
    private final Map<String, Seat> seats = new LinkedHashMap<>();

    public Airplane(String name) {
        this.name = name;
        initializeSeats();
    }

    private void initializeSeats() {
        for (int row = 1; row <= 5; row++) {
            for (char seatLetter = 'A'; seatLetter <= 'D'; seatLetter++) {
                String code = row + String.valueOf(seatLetter);
                seats.put(code, new Seat(TravelClass.BUSINESS, code));
            }
        }

        for (int row = 6; row <= 15; row++) {
            for (char seatLetter = 'A'; seatLetter <= 'F'; seatLetter++) {
                String code = row + String.valueOf(seatLetter);
                seats.put(code, new Seat(TravelClass.ECONOMY, code));
            }
        }
    }

    public Collection<Seat> getAllSeats() {
        return seats.values();
    }

    public Seat getSeat(String code) {
        return seats.get(code.toUpperCase());
    }

    public Map<String, Seat> getSeatsMap() {
        return seats;
    }
}
