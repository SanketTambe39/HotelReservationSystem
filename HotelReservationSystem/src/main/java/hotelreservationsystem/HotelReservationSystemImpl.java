package hotelreservationsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HotelReservationSystemImpl implements HotelReservationSystemService {

	ArrayList<HotelDetails> HotelList = new ArrayList<>();
	ArrayList<String> cheapestHotelNameList;
    HashMap<String, Integer> hotelRatingMap;

	 public void addHotelDetails(String hotelName, int weekDayRate, int weekendRate, int rating) {
	        HotelDetails hotelDetails = new HotelDetails(hotelName, weekDayRate, weekendRate, rating);        
	        HotelList.add(hotelDetails);
    }

    public ArrayList<String> findCheapestHotelForRegularCustomer(String arrival, String checkout) {
    	addHotelDetails("Lakewood",110,90, 3);
        addHotelDetails("Bridgewood",150, 50, 4);
        addHotelDetails("Ridgewood",220, 150, 5);
        LocalDate arrivalDate = convertStringToDate(arrival);
        LocalDate checkoutDate = convertStringToDate(checkout);
        cheapestHotelNameList = new ArrayList<>();
        hotelRatingMap = new HashMap<>();
        int minRate = Integer.MAX_VALUE;
        for (HotelDetails hotelDetails : HotelList) {
            LocalDate start = arrivalDate;
            LocalDate end = checkoutDate.plusDays(1);
            int hotelRent = 0;
            while (!(start.equals(end))) {

                int day = start.getDayOfWeek().getValue();

                if (day == 6 || day == 7){
                    hotelRent = hotelRent + hotelDetails.getWeekendRate();
               }
               else{
                    hotelRent = hotelRent + hotelDetails.getWeekdayRate();
                }
                start = start.plusDays(1);
            }
            if (hotelRent <= minRate) {
                minRate = hotelRent;
                cheapestHotelNameList.add(hotelDetails.getHotelName());
                hotelRatingMap.put(hotelDetails.getHotelName(), hotelDetails.getRating());
            }
        }
        for (String hotel: cheapestHotelNameList){
            System.out.println("Hotel Name: "+hotel+" Total Rate $"+minRate);
        }
        return cheapestHotelNameList;
    }
    
    public String cheapestBestRatedHotel(String arrival, String checkout) {

        findCheapestHotelForRegularCustomer(arrival, checkout);
        Map.Entry<String, Integer> cheapestBestRatedHotel = null;
        for (Map.Entry<String, Integer> entry : hotelRatingMap.entrySet()) {
            if (cheapestBestRatedHotel == null || entry.getValue().compareTo(cheapestBestRatedHotel.getValue()) > 0) {
                cheapestBestRatedHotel = entry;
            }
        }
        return cheapestBestRatedHotel.getKey();
    }

    public LocalDate convertStringToDate(String dateString) {
        LocalDate date = null;
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("ddMMMyyyy");
        try {
            date = LocalDate.parse(dateString, dateTimeFormat);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
