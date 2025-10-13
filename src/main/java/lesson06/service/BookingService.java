package lesson06.service;

import lesson06.model.Airplane;
import lesson06.model.Passenger;
import lesson06.model.Seat;
import lesson06.util.FileStorage;

import java.util.Scanner;

public class BookingService {
    private final Airplane airplane;
    private final Scanner scanner = new Scanner(System.in);

    public BookingService(Airplane airplane) {
        this.airplane = airplane;
        FileStorage.load(airplane.getSeatsMap());
    }

    public void start() {
        while (true) {
            System.out.println("""
                
                ✈️ ==== AIRPLANE BOOKING MENU ====
                1. Show seat map
                2. Book a seat
                3. Cancel booking
                4. Seat info
                5. Exit
                """);
            System.out.print("Select option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> showAllSeats();
                case "2" -> bookSeat();
                case "3" -> cancelBooking();
                case "4" -> seatInfo();
                case "5" -> {
                    FileStorage.save(airplane.getSeatsMap());
                    System.out.println("✅ Data saved. Goodbye!");
                    return;
                }
                default -> System.out.println("❌ Invalid option!");
            }
        }
    }


    private void showAllSeats() {
        System.out.println("\n🛫==== AIRPLANE SEAT MAP ====\n");

        System.out.println("💼 BUSINESS CLASS (Rows 1–5):");
        drawSection(1, 5, 2, 2);

        System.out.println("\n🧳 ECONOMY CLASS (Rows 6–15):");
        drawSection(6, 15, 3, 3);

        System.out.println("\nLegend: [🟩]=Free   [🟥]=Booked\n");
    }

    private void drawSection(int startRow, int endRow, int leftSide, int rightSide) {
        for (int row = startRow; row <= endRow; row++) {
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();

            for (char seatLetter = 'A'; seatLetter < 'A' + leftSide; seatLetter++) {
                left.append(formatSeat(row, seatLetter)).append(" ");
            }
            left.append("    ");

            for (char seatLetter = (char) ('A' + leftSide);
                 seatLetter < 'A' + leftSide + rightSide; seatLetter++) {
                right.append(formatSeat(row, seatLetter)).append(" ");
            }

            System.out.println(left.toString() + right.toString());
        }
    }

    private String formatSeat(int row, char letter) {
        String code = row + String.valueOf(letter);
        Seat seat = airplane.getSeat(code);
        boolean booked = seat != null && seat.isBooked();
        String colorFree = "\u001B[32m";  // green
        String colorBooked = "\u001B[31m"; // red
        String reset = "\u001B[0m";

        String box = booked ? "[🟥]" : "[🟩]";
        return (booked ? colorBooked : colorFree) + box + reset + code;
    }

    private void bookSeat() {
        System.out.print("Enter seat code (e.g. 3B): ");
        String code = scanner.nextLine().trim().toUpperCase();
        Seat seat = airplane.getSeat(code);
        if (seat == null) {
            System.out.println("❌ Invalid seat code!");
            return;
        }
        if (seat.isBooked()) {
            System.out.println("❌ Seat already booked!");
            return;
        }
        System.out.print("Enter passenger full name: ");
        String name = scanner.nextLine();
        seat.setPassenger(new Passenger(name));
        FileStorage.save(airplane.getSeatsMap());
        System.out.println("✅ Seat " + code + " booked successfully!");
    }

    private void cancelBooking() {
        System.out.print("Enter seat code to cancel (e.g. 3B): ");
        String code = scanner.nextLine().trim().toUpperCase();
        Seat seat = airplane.getSeat(code);
        if (seat == null || !seat.isBooked()) {
            System.out.println("❌ This seat is not booked!");
            return;
        }
        seat.setPassenger(null);
        FileStorage.save(airplane.getSeatsMap());
        System.out.println("✅ Booking canceled for seat " + code);
    }

    private void seatInfo() {
        System.out.print("Enter seat code (e.g. 3B): ");
        String code = scanner.nextLine().trim().toUpperCase();
        Seat seat = airplane.getSeat(code);
        if (seat == null) {
            System.out.println("❌ No such seat!");
            return;
        }
        if (seat.isBooked()) {
            System.out.println("🔴 Seat " + seat.getSeatNumber() + " is booked by: " +
                seat.getPassenger().getFio());
        } else {
            System.out.println("🟢 Seat " + seat.getSeatNumber() + " is free (" + seat.getTravelClass() + ")");
        }
    }
}
