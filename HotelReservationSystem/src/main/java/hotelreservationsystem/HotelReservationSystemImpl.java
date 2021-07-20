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
    HashMap<String, Integer> hotelRateMap;

    public void addHotelDetails(String hotelName, int weekDayRate, int weekendRate, int rating, int rewardCutomerWeekdayRates, int rewardCustomerWeekendRates) 
    {
        HotelDetails hotelDetails = new HotelDetails(hotelName, weekDayRate, weekendRate, rating, rewardCutomerWeekdayRates, rewardCustomerWeekendRates);        
	        HotelList.add(hotelDetails);
    }

    public ArrayList<String> findCheapestHotel(String arrival, String checkout, boolean rewardCustomer){
    	 addHotelDetails("Lakewood",110,90, 3, 80, 80);
         addHotelDetails("Bridgewood",150, 50, 4, 110, 50);
         addHotelDetails("Ridgewood",220, 150, 5, 100, 40);
        LocalDate arrivalDate = convertStringToDate(arrival);
        LocalDate checkoutDate = convertStringToDate(checkout);
        cheapestHotelNameList = new ArrayList<>();
        hotelRatingMap = new HashMap<>();
        hotelRateMap = new HashMap<>();
        int minRate = Integer.MAX_VALUE;
        for (HotelDetails hotelDetails : HotelList) {
            LocalDate start = arrivalDate;
            LocalDate end = checkoutDate.plusDays(1);
            int hotelRent = 0;
            while (!(start.equals(end))) {

                int day = start.getDayOfWeek().getValue();

                if (day == 6 || day == 7){
                	if(rewardCustomer) {
                        hotelRent = hotelRent + hotelDetails.getRewardCustomerWeekendrate();
                    } else {
                        hotelRent = hotelRent + hotelDetails.getWeekendRate();
                    }
               }
               else{
                    if(rewardCustomer) {
                        hotelRent = hotelRent + hotelDetails.getRewardCustomerWeekdayRate();
                    } else {
                        hotelRent = hotelRent + hotelDetails.getWeekdayRate();
                    }
                }
                start = start.plusDays(1);
            }
            if (hotelRent <= minRate) {
                minRate = hotelRent;
                hotelRateMap.put(hotelDetails.getHotelName(), hotelRent);
                hotelRatingMap.put(hotelDetails.getHotelName(), hotelDetails.getRating());
            }
        }
        for (Map.Entry<String, Integer> entry : hotelRateMap.entrySet()) {
            if (entry.getValue().equals(minRate)) {
                cheapestHotelNameList.add(entry.getKey());
            }
        }
        for (String hotel: cheapestHotelNameList){
        	System.out.println("Hotel Name: " + hotel + " Total Rate $" + minRate);
        }
        return cheapestHotelNameList;
    }
    
    public String cheapestBestRatedHotel(String arrival, String checkout, boolean rewardCustomer) {
    	 findCheapestHotel(arrival, checkout, rewardCustomer);
        Map.Entry<String, Integer> cheapestBestRatedHotel = null;
        for (Map.Entry<String, Integer> entry : hotelRatingMap.entrySet()) {
            if (cheapestBestRatedHotel == null || entry.getValue().compareTo(cheapestBestRatedHotel.getValue()) > 0) {
                cheapestBestRatedHotel = entry;
            }
        }
        return cheapestBestRatedHotel.getKey();
    }

    public String findBestRatedHotel(String arrival, String checkout, boolean rewardCustomer) {
    	 addHotelDetails("Lakewood",110,90, 3, 80, 80);
         addHotelDetails("Bridgewood",150, 50, 4, 110, 50);
         addHotelDetails("Ridgewood",220, 150, 5, 100, 40);
        LocalDate arrivalDate = convertStringToDate(arrival);
        LocalDate checkoutDate = convertStringToDate(checkout);
        int totalHotelRent = 0;
        int bestRating = 0;
        HotelDetails BestRatedHotel = null;
        for (HotelDetails hotelDetails : HotelList) {
            LocalDate start = arrivalDate;
            LocalDate end = checkoutDate.plusDays(1);
            int hotelRent = 0;
            while (!(start.equals(end))) {

                int day = start.getDayOfWeek().getValue();

                if (day == 6 || day == 7){
                	if(rewardCustomer) {
                        hotelRent = hotelRent + hotelDetails.getRewardCustomerWeekendrate();
                    } else {
                        hotelRent = hotelRent + hotelDetails.getWeekendRate();
                    }
                }
                else{
                	 if(rewardCustomer) {
                         hotelRent = hotelRent + hotelDetails.getRewardCustomerWeekdayRate();
                     } else {
                         hotelRent = hotelRent + hotelDetails.getWeekdayRate();
                     }
                }
                start = start.plusDays(1);
            }
            if(hotelDetails.getRating() > bestRating){
                bestRating = hotelDetails.getRating();
                BestRatedHotel = hotelDetails;
                totalHotelRent = hotelRent;
            }
        }
        System.out.println("Hotel Name: " + BestRatedHotel.getHotelName() + ", Rating: " + bestRating + " and Total Rate $" + totalHotelRent);
        return BestRatedHotel.getHotelName();
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
