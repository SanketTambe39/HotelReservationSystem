package hotelreservationsystem;
import java.util.ArrayList;

public interface HotelReservationSystemService {

	public void addHotelDetails(String hotelName, int weekDayRate, int weekendRate, int rating, int rewardCutomerWeekdayRates, int rewardCustomerWeekendRates);
	public ArrayList<String> findCheapestHotel(String arrival, String checkout, boolean rewardCustomer);
	public String findBestRatedHotel(String arrival, String departure, boolean rewardCustomer);
	public String cheapestBestRatedHotel(String arrival, String departure, boolean rewardCustomer);
}
