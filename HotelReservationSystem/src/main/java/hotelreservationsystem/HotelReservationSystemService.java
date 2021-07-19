package hotelreservationsystem;

import java.text.ParseException;

public interface HotelReservationSystemService {

	public String getCheapestHotelAndRate(String arrivalDate,String checkoutDate) throws ParseException;
}
