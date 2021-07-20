package hotelreservationsystem;

import java.util.Scanner;

public class HotelReservationSystemMain {

	public static void main(String[] args) throws InvalidUserChoiceException {
        System.out.println("Welcome to Hotel Reservation System");
        Scanner scanner = new Scanner(System.in);
        HotelReservationSystemService hotelReservation = new HotelReservationSystemImpl();
        while (true) {
            System.out.println("Are you a reward customer(true/false): ");
            boolean rewardCustomer = scanner.nextBoolean();
            scanner.nextLine();
            System.out.println("Enter arrival date: ");
            String arrival = scanner.nextLine();
            System.out.println("Enter the departure date: ");
            String departure = scanner.nextLine();
            System.out.println("Choose: \n 1.Best rated hotel\n 2.Cheapest hotel\n 3.Cheapest Best Rated Hotel");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    hotelReservation.findBestRatedHotel(arrival, departure, rewardCustomer);
                    break;

                case 2:
                    hotelReservation.findCheapestHotel(arrival, departure, rewardCustomer);
                    break;

                case 3:
                    hotelReservation.cheapestBestRatedHotel(arrival, departure, rewardCustomer);
                    break;

                default:
                    throw new InvalidUserChoiceException("Invalid choice");
            }
        }
    }
}

