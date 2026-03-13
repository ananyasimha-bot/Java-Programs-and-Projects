import java.io.*;
import java.util.Scanner;
import java.io.Serializable;
// Flight class
class Flight implements Serializable {
    int flightId;
    String source;
    String destination;
    int availableSeats;
    Flight(int flightId, String source, String destination, int availableSeats) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }
    void displayFlight() {
        System.out.println("Flight ID: " + flightId +
                " | From: " + source +
                " | To: " + destination +
                " | Seats: " + availableSeats);
    }
}
// Main class
public class AirlineReservationSystem {
    static Flight[] flights = new Flight[50];   // ARRAY
    static int count = 0;
    static final String FILE_NAME = "flights.dat";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loadFlights(); // File I/O + Serialization
        while (true) {
            System.out.println("\n--- Airline Reservation System ---");
            System.out.println("1. Add Flight");
            System.out.println("2. View Flights");
            System.out.println("3. Book Seat");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addFlight(sc);
                case 2 -> viewFlights();
                case 3 -> bookSeat(sc);
                case 4 -> {
                    saveFlights();
                    System.out.println("Data saved. Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
    // Add flight
    static void addFlight(Scanner sc) {
        if (count >= flights.length) {
            System.out.println("Flight list full!");
            return;
        }
        System.out.print("Enter Flight ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Source: ");
        String src = sc.nextLine();
        System.out.print("Enter Destination: ");
        String dest = sc.nextLine();
        System.out.print("Enter Available Seats: ");
        int seats = sc.nextInt();
        flights[count++] = new Flight(id, src, dest, seats);
        System.out.println("Flight added successfully!");
    }
    // View flights
    static void viewFlights() {
        if (count == 0) {
            System.out.println("No flights available.");
            return;
        }
        for (int i = 0; i < count; i++) {
            flights[i].displayFlight();
        }
    }
    // Book seat
    static void bookSeat(Scanner sc) {
        System.out.print("Enter Flight ID to book: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (flights[i].flightId == id) {
                if (flights[i].availableSeats > 0) {
                    flights[i].availableSeats--;
                    System.out.println("Seat booked successfully!");
                } else {
                    System.out.println("No seats available!");
                }
                return;
            }
        }
        System.out.println("Flight not found!");
    }
    // Save data (Serialization)
    static void saveFlights() {
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(flights);
            oos.writeInt(count);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
    // Load data (File I/O)
    static void loadFlights() {
        try {
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(FILE_NAME));
            flights = (Flight[]) ois.readObject();
            count = ois.readInt();
            ois.close();
        } catch (Exception e) {
            System.out.println("No previous data found.");
        }
    }
}
