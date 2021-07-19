package hotelreservationsystemtest;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import hotelreservationsystem.HotelReservationSystemImpl;

public class HotelReservationSystemTest {

	 @Test
	    public void givenDates_WhenRegularCustomer_Should_ReturnCheapestHotel() throws ParseException {
	        HotelReservationSystemImpl reservation = new HotelReservationSystemImpl();
	        String hotelName = reservation.getCheapestHotelAndRate("10Sep2020","11Sep2020");
	        Assert.assertEquals("Lakewood, $220", hotelName);
	    }

}
