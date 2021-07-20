package hotelreservationsystemtest;

import org.junit.Assert;
import org.junit.Test;

import hotelreservationsystem.HotelReservationSystemImpl;

public class HotelReservationSystemTest {

    @Test
    public void givenThreeHotels_ForGivenDates_ShouldCheapestHotel() {
        HotelReservationSystemImpl hotelReservation = new HotelReservationSystemImpl();
        Object[] hotelName = hotelReservation.findCheapestHotelForRegularCustomer("10Sep2020", "11Sep2020").toArray();
        Object[] expectedHotelName = {"Lakewood"};
        Assert.assertArrayEquals(expectedHotelName,hotelName);
    }

    @Test
    public void givenThreeHotels_ForGivenDatesHavingBothWeekDayAndWeekend_ShouldReturnCheapestHotels() {
        HotelReservationSystemImpl hotelReservation = new HotelReservationSystemImpl();
        Object[] hotelName = hotelReservation.findCheapestHotelForRegularCustomer("11Sep2020", "12Sep2020").toArray();
        Object[] expectedHotelName = {"Lakewood","Bridgewood"};
        Assert.assertArrayEquals(expectedHotelName, hotelName);
    }
}
