import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {

    static Movies movie11 = new Movies("Black Adam", 124, "Action, Fantasy, Science Fiction", 2);
    static Movies movie12 = new Movies("Black Adam", 124, "Action, Fantasy, Science Fiction", 6);
    static Movies movie21 = new Movies("Black Panther: Wakanda Forever", 161, "Action, Fantasy, Science Fiction", 2);
    static Movies movie22 = new Movies("Black Panther: Wakanda Forever", 161, "Action, Fantasy, Science Fiction", 6);
    static Movies movie31 = new Movies("Top Gun: Maverick", 131, "Action, Drama", 2);
    static Movies movie32 = new Movies("Top Gun: Maverick", 131, "Action, Drama", 6);
    static Movies movie41 = new Movies("Minions: The Rise Of Gru", 87, "Animation", 2);
    static Movies movie42 = new Movies("Minions: The Rise Of Gru", 87, "Animation", 6);

    static HashMap<Integer, String> seats11 = new HashMap<Integer, String>();
    static HashMap<Integer, String> seats12 = new HashMap<Integer, String>();
    static HashMap<Integer, String> seats21 = new HashMap<Integer, String>();
    static HashMap<Integer, String> seats22 = new HashMap<Integer, String>();
    static HashMap<Integer, String> seats31 = new HashMap<Integer, String>();
    static HashMap<Integer, String> seats32 = new HashMap<Integer, String>();
    static HashMap<Integer, String> seats41 = new HashMap<Integer, String>();
    static HashMap<Integer, String> seats42 = new HashMap<Integer, String>();

    static Auditorium auditorium11 = new Auditorium(seats11, 10.0, movie11); // movie 1 afternoon
    static Auditorium auditorium12 = new Auditorium(seats12, 10.0, movie12); // movie 1 night
    static Auditorium auditorium21 = new Auditorium(seats21, 10.0, movie21); // movie 2 afternoon
    static Auditorium auditorium22 = new Auditorium(seats22, 10.0, movie22); // movie 2 night
    static Auditorium auditorium31 = new Auditorium(seats31, 10.0, movie31); // movie 3 afternoon
    static Auditorium auditorium32 = new Auditorium(seats32, 10.0, movie32); // movie 3 night
    static Auditorium auditorium41 = new Auditorium(seats41, 10.0, movie41); // movie 4 afternoon
    static Auditorium auditorium42 = new Auditorium(seats42, 10.0, movie42); // movie 4 night

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        auditorium11.fillMap("new", null, null);
        auditorium12.fillMap("new", null, null);
        auditorium21.fillMap("new", null, null);
        auditorium22.fillMap("new", null, null);
        auditorium31.fillMap("new", null, null);
        auditorium32.fillMap("new", null, null);
        auditorium41.fillMap("new", null, null);
        auditorium42.fillMap("new", null, null);

        int userInputNumber = 0;

        String n = ""; // name
        String u = ""; // username
        String m = ""; // email

        ArrayList<User> userList = new ArrayList<User>();
        while (true) {
            System.out.print("\033\143");
            System.out.println("==============================");
            System.out.println(" --- WELCOME TO CINEMATRIX ---");
            System.out.println("==============================");
            System.out.println("");
            System.out.println("1 ==> Login (Registered User");
            System.out.println("2 ==> New User (Don't have an account, Create one)");
            System.out.println("==============================");
            System.out.print("Please enter a choice: ");

            if (sc.hasNextInt()) {
                userInputNumber = sc.nextInt();
            } else {
                sc.nextLine();
            }

            if (userInputNumber == 1) {
                System.out.print("\033\143");
                System.out.println("==============================");
                System.out.println("------- Registered User ------");
                System.out.println("==============================");
                System.out.println("");
                u = "";
                while (u == "") {
                    System.out.print("UserName: ");
                    u = sc.next();

                    for (User i : userList) {
                        if (i.getUserName().compareToIgnoreCase(u) == 0) {
                            System.out.println("welcome back " + i.getName());
                            selecMovie();
                            break;
                        }
                    }
                }
            }
            if (userInputNumber == 2) {
                n = "";
                u = "";
                m = "";
                System.out.print("\033\143");
                System.out.println("==============================");
                System.out.println("----- New User: Register -----");
                System.out.println("==============================");
                System.out.println("");
                while (n == "") {
                    System.out.print("Name: ");
                    n = sc.next();
                }
                while (u == "") {
                    System.out.print("UserName: ");
                    u = sc.next();
                    for (User i : userList) {
                        if (i.getUserName().compareToIgnoreCase(u) == 0) {
                            System.out.println("This username is already in use, please type a different one");
                            u = "";
                            break;
                        }
                    }
                }
                while (m == "") {
                    System.out.print("eMail: ");
                    m = sc.next();
                }
                User userx = new User(n, u, m);
                n = "";
                u = "";
                m = "";
                userList.add(userx);
                System.out.println("Successfully registered");
                while (userInputNumber != 1) {
                    System.out.print("1 ===> Return to Main menu: ");

                    if (sc.hasNextInt()) {
                        userInputNumber = sc.nextInt();
                    } else {
                        sc.nextLine();
                    }
                }
            }
        }
    }

    // ==============================================================================================================================
    public static void selecMovie() {
        int userInputNumber = 0;
        String returnString = "";

        do {
            System.out.print("\033\143");
            System.out.println("");
            System.out.println("==============================");
            System.out.println("------ available movies ------");
            System.out.println("-------- and schedules -------");
            System.out.println("==============================");
            System.out.println("");

            System.out.println("1 ==> " + movie11.getName() + " -- Genre: " + movie11.getGenre() + " -- Length (min): " + movie11.getMovieLength() + "  -- Schedule: 2:00 pm\n      Available Seats: " + auditorium11.getAvailableSeats() + "\n");
            System.out.println("2 ==> " + movie12.getName() + " -- Genre: " + movie12.getGenre() + " -- Length (min): " + movie12.getMovieLength() + "  -- Schedule: 6:00 pm\n      Available Seats: " + auditorium12.getAvailableSeats() + "\n");
            System.out.println("3 ==> " + movie21.getName() + " -- Genre: " + movie21.getGenre() + " -- Length (min): " + movie21.getMovieLength() + "  -- Schedule: 2:00 pm\n      Available Seats: " + auditorium21.getAvailableSeats() + "\n");
            System.out.println("4 ==> " + movie22.getName() + " -- Genre: " + movie22.getGenre() + " -- Length (min): " + movie22.getMovieLength() + "  -- Schedule: 6:00 pm\n      Available Seats: " + auditorium22.getAvailableSeats() + "\n");
            System.out.println("5 ==> " + movie31.getName() + " -- Genre: " + movie31.getGenre() + " -- Length (min): " + movie31.getMovieLength() + "  -- Schedule: 2:00 pm\n      Available Seats: " + auditorium31.getAvailableSeats() + "\n");
            System.out.println("6 ==> " + movie32.getName() + " -- Genre: " + movie32.getGenre() + " -- Length (min): " + movie32.getMovieLength() + "  -- Schedule: 6:00 pm\n      Available Seats: " + auditorium32.getAvailableSeats() + "\n");
            System.out.println("7 ==> " + movie41.getName() + " -- Genre: " + movie41.getGenre() + " -- Length (min): " + movie41.getMovieLength() + "  -- Schedule: 2:00 pm\n      Available Seats: " + auditorium41.getAvailableSeats() + "\n");
            System.out.println("8 ==> " + movie42.getName() + " -- Genre: " + movie42.getGenre() + " -- Length (min): " + movie42.getMovieLength() + "  -- Schedule: 6:00 pm\n      Available Seats: " + auditorium42.getAvailableSeats() + "\n");
            System.out.print("Please enter a choice: ");

            userInputNumber = 0;
            while (userInputNumber < 1 || userInputNumber > 8) {
                if (sc.hasNextInt()) {
                    userInputNumber = sc.nextInt();
                } else {
                    sc.nextLine();
                }
            }

            switch (userInputNumber) {
                case 1:
                    if (auditorium11.getAvailableSeats() > 0) {
                        returnString = auditorium11.selectSeats();
                    }
                    break;
                case 2:
                    if (auditorium12.getAvailableSeats() > 0) {
                        returnString = auditorium12.selectSeats();
                    }
                    break;
                case 3:
                    if (auditorium21.getAvailableSeats() > 0) {
                        returnString = auditorium21.selectSeats();
                    }
                    break;
                case 4:
                    if (auditorium22.getAvailableSeats() > 0) {
                        returnString = auditorium22.selectSeats();
                    }
                    break;
                case 5:
                    if (auditorium31.getAvailableSeats() > 0) {
                        returnString = auditorium31.selectSeats();
                    }
                    break;
                case 6:
                    if (auditorium32.getAvailableSeats() > 0) {
                        returnString = auditorium32.selectSeats();
                    }
                    break;
                case 7:
                    if (auditorium41.getAvailableSeats() > 0) {
                        returnString = auditorium41.selectSeats();
                    }
                    break;
                case 8:
                    if (auditorium42.getAvailableSeats() > 0) {
                        returnString = auditorium42.selectSeats();
                    }
                    break;
            }
        } while (returnString != "finish");
    }
}