package hotelreservationsystem;
import java.util.ArrayList;

public interface HotelReservationSystemService {

	 public void addHotelDetails(String hotelName, int weekDayRate, int weekendRate, int rating, int rewardCutomerWeekdayRates, int rewardCustomerWeekendRates);
	 public ArrayList<String> findCheapestHotelForRegularCustomer(String arrival, String checkout);
}
