package lesson06.util;

import lesson06.model.Passenger;
import lesson06.model.Seat;
import lesson06.model.enums.SeatStatus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class FileStorage {
    private static final String FILE_NAME = "airplane_data.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void save(Map<String, Seat> seats, LocalDateTime flightDate) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("FLIGHT_DATE;" + flightDate.format(FORMATTER));
            writer.newLine();

            for (Seat seat : seats.values()) {
                if (seat.isBooked()) {
                    writer.write(seat.getSeatNumber() + ";" +
                        seat.getPassenger().getFio() + ";" +
                        seat.getStatus() + ";" +
                        (seat.getBookingDateTime() != null ?
                            seat.getBookingDateTime().format(FORMATTER) : ""));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Exception file is not saved: " + e.getMessage());
        }
    }

    public static void load(Map<String, Seat> seats) {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split(";");
                if (parts.length < 3) continue;

                String code = parts[0];
                String passengerName = parts[1];
                SeatStatus status = SeatStatus.valueOf(parts[2]);
                LocalDateTime bookingDateTime = null;

                if (parts.length > 3 && !parts[3].isEmpty()) {
                    bookingDateTime = LocalDateTime.parse(parts[3], FORMATTER);
                }

                Seat seat = seats.get(code.toUpperCase());
                if (seat != null) {
                    seat.setPassenger(new Passenger(passengerName));
                    seat.setStatus(status);
                    seat.setBookingDateTime(bookingDateTime);
                }
            }
        } catch (IOException e) {
            System.out.println("Exception cant load from file: " + e.getMessage());
        }
    }
}
