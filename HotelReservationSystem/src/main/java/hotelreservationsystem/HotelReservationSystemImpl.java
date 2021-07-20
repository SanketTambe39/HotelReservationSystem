package hotelreservationsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class HotelReservationSystemImpl implements HotelReservationSystemService {

	ArrayList<HotelDetails> HotelList = new ArrayList<>();

    public void addHotelDetails(String hotelName, int weekDayRate, int weekendRate) {
        HotelDetails hotelDetails = new HotelDetails(hotelName, weekDayRate, weekendRate);
        HotelList.add(hotelDetails);
    }

    public ArrayList<String> findCheapestHotelForRegularCustomer(String arrival, String checkout) {
        addHotelDetails("Lakewood",110,90);
        addHotelDetails("Bridgewood",150, 50);
        addHotelDetails("Ridgewood",220, 150);
        LocalDate arrivalDate = convertStringToDate(arrival);
        LocalDate checkoutDate = convertStringToDate(checkout);
        ArrayList<String> cheapestHotelNameList = new ArrayList<>();
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
            }
        }
        for (String hotel: cheapestHotelNameList){
            System.out.println("Hotel Name: "+hotel+" Total Rate $"+minRate);
        }
        return cheapestHotelNameList;
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
