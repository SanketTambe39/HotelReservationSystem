package hotelreservationsystemtest;

import org.junit.Assert;
import org.junit.Test;

import hotelreservationsystem.HotelReservationSystemImpl;

public class HotelReservationSystemTest {

    @Test
    public void givenDates_ForRegularCustomer_ShouldReturnCheapestHotels() {
        HotelReservationSystemImpl hotelReservation = new HotelReservationSystemImpl();
        Object[] hotelName = hotelReservation.findCheapestHotel("11Sep2020", "12Sep2020", false).toArray();
        Object[] expectedHotelName = {"Bridgewood","Lakewood"};
        Assert.assertArrayEquals(expectedHotelName, hotelName);
    }

    @Test
    public void givenDates_ForRewardCustomer_ShouldReturnCheapestHotels() {
        HotelReservationSystemImpl hotelReservation = new HotelReservationSystemImpl();
        Object[] hotelName = hotelReservation.findCheapestHotel("11Sep2020", "12Sep2020", true).toArray();
        Object[] expectedHotelName = {"Ridgewood"};
        Assert.assertArrayEquals(expectedHotelName, hotelName);
    }

    @Test
    public void givenDates_ForRegularCustomer_ShouldReturnCheapestBestRatedHotel() {
        HotelReservationSystemImpl hotelReservation = new HotelReservationSystemImpl();
        String hotelName = hotelReservation.cheapestBestRatedHotel("11Sep2020", "12Sep2020", false);
        Assert.assertEquals("Bridgewood", hotelName);
    }

    @Test
    public void givenDates_ForRewardCustomer_ShouldReturnCheapestBestRatedHotel() {
        HotelReservationSystemImpl hotelReservation = new HotelReservationSystemImpl();
        String hotelName = hotelReservation.cheapestBestRatedHotel("11Sep2020", "12Sep2020", true);
        Assert.assertEquals("Ridgewood", hotelName);
    }

    @Test
    public void givenDates_ForRegularCustomer_ShouldReturnBestRatedHotel() {
        HotelReservationSystemImpl hotelReservation = new HotelReservationSystemImpl();
        String hotelName = hotelReservation.findBestRatedHotel("11Sep2020", "12Sep2020", false);
        Assert.assertEquals("Ridgewood", hotelName);
    }

    @Test
    public void givenDates_ForRewardCustomer_ShouldReturnBestRatedHotel() {
        HotelReservationSystemImpl hotelReservation = new HotelReservationSystemImpl();
        String hotelName = hotelReservation.findBestRatedHotel("11Sep2020", "12Sep2020", true);
        Assert.assertEquals("Ridgewood", hotelName);
    }
}