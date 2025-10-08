package lesson06.util;

import lesson06.model.Passenger;
import lesson06.model.Seat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileStorage {
    private static final String FILE_NAME = "airplane_data.txt";

    public static void save(Map<String, Seat> seats) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Seat seat : seats.values()) {
                if (seat.isBooked()) {
                    writer.write(seat.getSeatNumber() + ";" + seat.getPassenger().getFio());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Exception file is not safed: " + e.getMessage());
        }
    }

    public static void load(Map<String, Seat> seats) {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String code = parts[0];
                String passengerName = parts[1];
                Seat seat = seats.get(code.toUpperCase());
                if (seat != null) {
                    seat.setPassenger(new Passenger(passengerName));
                }
            }
        } catch (IOException e) {
            System.out.println("Exception cant load from file: " + e.getMessage());
        }
    }
}
