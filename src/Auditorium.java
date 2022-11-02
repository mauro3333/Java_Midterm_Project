import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class Auditorium {
    private HashMap seats;
    private Double ticketPrice;
    private Integer availableSeats;
    private Movies movies;

    public Auditorium(HashMap seats, Double ticketPrice, Movies movies) {
        this.seats = seats;
        this.ticketPrice = ticketPrice;
        this.availableSeats = 50;
        this.movies = movies;
    }

    int userInputNumber = 0;
    String userInpuntString = "";
    Scanner sc = new Scanner(System.in);

    // ==============================================================================================================================
    public String selectSeats() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("==============================");
        System.out.println("Available Seats: " + this.getAvailableSeats());
        System.out.print("Starting seat? ==> ");
        while (!sc.hasNextInt()) {
            sc.nextLine();
        }
        Integer startingSeat = sc.nextInt();
        while (startingSeat > 49) {
            System.out.println("Please select a seat from 0 to 49");
            System.out.print("Starting seat? ==> ");
            while (!sc.hasNextInt()) {
                sc.nextLine();
            }
            startingSeat = sc.nextInt();
        }

        System.out.print("Quantity of seats (maximun " + this.getAvailableSeats() + ")? ==> ");
        while (!sc.hasNextInt()) {
            sc.nextLine();
        }
        Integer seatQuantity = sc.nextInt();

        if (seatQuantity > this.getAvailableSeats()) {
            System.out.println("The number of seats available cannot be exceeded");
            System.out.print("Quantity of seats (maximun " + this.getAvailableSeats() + ")? ==> ");

            while (!sc.hasNextInt()) {
                sc.nextLine();
            }
            seatQuantity = sc.nextInt();

        }

        this.fillMap("seatPreview", startingSeat, seatQuantity);
        this.showauditorium();

        do {
            System.out.println(" ");
            System.out.println("==============================");
            System.out.println("1 - Save");
            System.out.println("2 - Cancel");
            System.out.print("Please enter a choice: ");
            while (!sc.hasNextInt()) {
                sc.nextLine();
            }
            userInputNumber = sc.nextInt();

            if (userInputNumber == 1 || userInputNumber == 2) {
                switch (userInputNumber) {
                    case 1:
                        this.fillMap("save", null, null);
                        // this.showauditorium();
                        return "finish";
                    case 2:
                        this.fillMap("change", null, null);
                        return "change";
                    default:
                        return "";
                }
            }
        } while (userInputNumber != 1 || userInputNumber != 2);
        return "";
    }

    // ==============================================================================================================================
    public void fillMap(String tasks, Integer startingSeat, Integer seatQuantity) { // task: new, seatPreview, save, change
        switch (tasks) {
            case "new":
                for (Integer x = 0; x < 50; x++) {
                    this.seats.put(x, "1");
                }
                break;
            case "seatPreview":
                while (seatQuantity > 0) {
                    if (this.seats.get(startingSeat).toString() == "0") {
                        startingSeat++;
                    } else {
                        this.seats.put(startingSeat, "R");
                        startingSeat++;
                        seatQuantity--;
                    }
                    if (startingSeat == 50) {
                        startingSeat = 0;
                    }
                }
                break;
            case "save":
                ArrayList<Integer> printTickets = new ArrayList<Integer>();

                for (Integer z = 0; z < 50; z++) {
                    if (this.seats.get(z).toString() == "R") {
                        this.seats.put(z, "0");
                        printTickets.add(z);
                        this.availableSeats--;
                    }
                }
                printTickets(printTickets, this.movies.getName(), this.movies.getSchedule(), this.ticketPrice);
                break;
            case "change":
                for (Integer w = 0; w < 50; w++) {
                    if (this.seats.get(w).toString() == "R") {
                        this.seats.put(w, "1");
                        // this.availableSeats++;
                    }
                }
                break;
        }
    }

    // ==============================================================================================================================
    public void showauditorium() {
        System.out.print("\033\143");
        System.out.println("============================================================");
        System.out.println("                           Screen");
        System.out.println("============================================================");
        System.out.println("");

        for (Integer x = 0; x < 50; x++) {
            if (x < 10) {
                if (this.seats.get(x).toString() == "1") {
                    System.out.print("[ 0" + x + " ]");
                }

                if (this.seats.get(x).toString() == "0") {
                    System.out.print("[ -- ]");
                }

                if (this.seats.get(x).toString() == "R") {
                    System.out.print("[ <> ]");
                }

                if (x == 9) {
                    System.out.println();
                }
            } else {
                if (this.seats.get(x).toString() == "1") {
                    System.out.print("[ " + x + " ]");
                }

                if (this.seats.get(x).toString() == "0") {
                    System.out.print("[ -- ]");
                }

                if (this.seats.get(x).toString() == "R") {
                    System.out.print("[ <> ]");
                }

                if (x == 19 || x == 29 || x == 39 || x == 49) {
                    System.out.println();
                }
            }
        }
    }

    // ==============================================================================================================================
    public static void printTickets(ArrayList<Integer> printTickets, String movieName, Integer schedule, Double ticketPrice) {
        Scanner sc = new Scanner(System.in);
        int userInputNumber = 0;
        Random random = new Random();
        int m = 0;

        System.out.println("");
        System.out.println("Ticket Price $" + ticketPrice + " -- Total Amount: $" + printTickets.size() * ticketPrice);

        System.out.println("");
        while (userInputNumber != 1) {
            System.out.print("1 ===> To print tickets: ");
            if (sc.hasNextInt()) {
                userInputNumber = sc.nextInt();
            } else {
                sc.nextLine();
            }
        }

        System.out.print("\033\143");
        System.out.println("");
        System.out.println("**************************************************");
        System.out.println("**************************************************");
        System.out.println("**     ============ CINEMATRIX ============     **");
        System.out.println("** Invoice # " + random.nextInt(99) + "             Date: Oct 31/22     **");
        System.out.println("** Ticket Price $" + ticketPrice + " --- Total Amount: $" + printTickets.size() * ticketPrice);
        System.out.println("**************************************************");
        System.out.println("** Movie: " + movieName);
        System.out.println("** Schedule: " + schedule + ":00 pm");
        System.out.println("**************************************************");
        System.out.print("**  Seats: ");

        for (Integer i : printTickets) {
            System.out.print(i);
            System.out.print(", ");
            m++;
            if (m == 9 || m == 18 || m == 27 || m == 36 || m == 45) {
                System.out.println("");
                System.out.print("**         ");
            }
        }
        System.out.println("");
        System.out.println("**                                              **");
        System.out.println("**************************************************");
        System.out.println("**************************************************");
        System.out.println("");
        System.out.println("");

        userInputNumber = 0;
        System.out.println("Thanks for your purchase, we hope you enjoy the movie");
        while (userInputNumber != 1) {
            System.out.print("1 ===> To Return Main Menu: ");
            if (sc.hasNextInt()) {
                userInputNumber = sc.nextInt();
            } else {
                sc.nextLine();
            }
        }
    }

    // ==============================================================================================================================
    public HashMap getSeats() {
        return seats;
    }

    public void setSeats(HashMap seats) {
        this.seats = seats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }
}
