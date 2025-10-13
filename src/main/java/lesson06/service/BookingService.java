package lesson06.service;

import lesson06.model.Airplane;
import lesson06.model.Passenger;
import lesson06.model.Seat;
import lesson06.model.enums.SeatStatus;
import lesson06.util.FileStorage;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BookingService {
    private final Airplane airplane;
    private final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public BookingService(Airplane airplane) {
        this.airplane = airplane;
        FileStorage.load(airplane.getSeatsMap());
    }

    public void start() {
        while (true) {
            System.out.printf("""
                
                ✈️ ==== AIRPLANE BOOKING MENU ====
                Flight: %s
                Departure: %s
                
                1. Show seat map
                2. Book a seat
                3. Pay for booking
                4. Cancel booking
                5. Seat info
                6. Exit
                %n""", airplane.getName(), airplane.getFlightDate().format(DATE_FORMATTER));
            System.out.print("Select option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> showAllSeats();
                case "2" -> bookSeat();
                case "3" -> payForBooking();
                case "4" -> cancelBooking();
                case "5" -> seatInfo();
                case "6" -> {
                    FileStorage.save(airplane.getSeatsMap(), airplane.getFlightDate());
                    System.out.println("✅ Data saved. Goodbye!");
                    return;
                }
                default -> System.out.println("❌ Invalid option!");
            }
        }
    }

    private void showAllSeats() {
        clearExpiredBookings();

        System.out.println("\n🛫==== AIRPLANE SEAT MAP ====\n");

        System.out.println("💼 BUSINESS CLASS (Rows 1–5):");
        drawSection(1, 5, 2, 2);

        System.out.println("\n🧳 ECONOMY CLASS (Rows 6–15):");
        drawSection(6, 15, 3, 3);

        System.out.println("\nLegend: [🟩]=Free   [🟨]=Booked   [🟥]=Paid\n");
    }

    private void clearExpiredBookings() {
        int clearedCount = 0;
        for (Seat seat : airplane.getAllSeats()) {
            if (seat.isExpired()) {
                System.out.println("⏰ Booking expired for seat " + seat.getSeatNumber());
                seat.cancel();
                clearedCount++;
            }
        }
        if (clearedCount > 0) {
            FileStorage.save(airplane.getSeatsMap(), airplane.getFlightDate());
            System.out.println("✅ Cleared " + clearedCount + " expired booking(s)\n");
        }
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

        String colorFree = "\u001B[32m";    // green
        String colorBooked = "\u001B[33m";  // yellow
        String colorPaid = "\u001B[31m";    // red
        String reset = "\u001B[0m";

        String box;
        String color;

        if (seat == null || seat.getStatus() == SeatStatus.FREE) {
            box = "[🟩]";
            color = colorFree;
        } else if (seat.getStatus() == SeatStatus.BOOKED) {
            box = "[🟨]";
            color = colorBooked;
        } else {
            box = "[🟥]";
            color = colorPaid;
        }

        return color + box + reset + code;
    }

    private void bookSeat() {
        clearExpiredBookings();

        System.out.print("Enter seat code (e.g. 3B): ");
        String code = scanner.nextLine().trim().toUpperCase();
        Seat seat = airplane.getSeat(code);

        if (seat == null) {
            System.out.println("❌ Invalid seat code!");
            return;
        }
        if (seat.isBooked()) {
            System.out.println("❌ Seat already booked or paid!");
            return;
        }

        System.out.print("Enter passenger full name: ");
        String name = scanner.nextLine();
        seat.book(new Passenger(name));
        FileStorage.save(airplane.getSeatsMap(), airplane.getFlightDate());

        System.out.println("✅ Seat " + code + " booked successfully!");
        System.out.println("⏰ Booking valid until: " +
            seat.getBookingDateTime().plusMinutes(24).format(DATE_FORMATTER));
        System.out.println("💡 Please pay within 24 minutes to confirm your booking.");
    }

    private void payForBooking() {
        System.out.print("Enter seat code to pay (e.g. 3B): ");
        String code = scanner.nextLine().trim().toUpperCase();
        Seat seat = airplane.getSeat(code);

        if (seat == null) {
            System.out.println("❌ Invalid seat code!");
            return;
        }
        if (seat.getStatus() == SeatStatus.FREE) {
            System.out.println("❌ This seat is not booked!");
            return;
        }
        if (seat.getStatus() == SeatStatus.PAID) {
            System.out.println("❌ This seat is already paid!");
            return;
        }
        if (seat.isExpired()) {
            System.out.println("❌ Booking has expired!");
            seat.cancel();
            FileStorage.save(airplane.getSeatsMap(), airplane.getFlightDate());
            return;
        }

        seat.pay();
        FileStorage.save(airplane.getSeatsMap(), airplane.getFlightDate());
        System.out.println("✅ Payment successful for seat " + code + "!");
    }

    private void cancelBooking() {
        System.out.print("Enter seat code to cancel (e.g. 3B): ");
        String code = scanner.nextLine().trim().toUpperCase();
        Seat seat = airplane.getSeat(code);

        if (seat == null || seat.isFree()) {
            System.out.println("❌ This seat is not booked!");
            return;
        }
        if (seat.getStatus() == SeatStatus.PAID) {
            System.out.print("⚠️ This seat is paid. Are you sure you want to cancel? (yes/no): ");
            String confirm = scanner.nextLine().trim().toLowerCase();
            if (!confirm.equals("yes")) {
                System.out.println("❌ Cancellation aborted.");
                return;
            }
        }

        seat.cancel();
        FileStorage.save(airplane.getSeatsMap(), airplane.getFlightDate());
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

        if (seat.isExpired()) {
            System.out.println("⏰ Booking expired! Clearing...");
            seat.cancel();
            FileStorage.save(airplane.getSeatsMap(), airplane.getFlightDate());
        }

        System.out.println("\n📋 ==== SEAT INFORMATION ====");
        System.out.println("Seat: " + seat.getSeatNumber());
        System.out.println("Class: " + seat.getTravelClass());
        System.out.println("Status: " + getStatusEmoji(seat.getStatus()) + " " + seat.getStatus());

        if (seat.isBooked()) {
            System.out.println("Passenger: " + seat.getPassenger().getFio());
            System.out.println("Booking time: " + seat.getBookingDateTime().format(DATE_FORMATTER));

            if (seat.getStatus() == SeatStatus.BOOKED) {
                System.out.println("Valid until: " +
                    seat.getBookingDateTime().plusMinutes(24).format(DATE_FORMATTER));
            }
        }
        System.out.println("============================\n");
    }

    private String getStatusEmoji(SeatStatus status) {
        return switch (status) {
            case FREE -> "🟢";
            case BOOKED -> "🟡";
            case PAID -> "🔴";
        };
    }
}
