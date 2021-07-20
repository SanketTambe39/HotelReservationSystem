package hotelreservationsystem;
import java.util.ArrayList;

public interface HotelReservationSystemService {

	 public void addHotelDetails(String hotelName, int weekDayRate, int weekendRate,int rating);
	 public ArrayList<String> findCheapestHotelForRegularCustomer(String arrival, String checkout);
}
