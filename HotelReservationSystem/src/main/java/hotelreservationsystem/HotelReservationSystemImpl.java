package hotelreservationsystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HotelReservationSystemImpl implements HotelReservationSystemService {

	ArrayList<HotelDetails> HotelList = new ArrayList<>();

    public String getCheapestHotelAndRate(String arrivalDate,String checkoutDate) throws ParseException {
        Date StartDate = convertStringToDate(arrivalDate);
        Date EndDate = convertStringToDate(checkoutDate);
        long Duration = EndDate.getTime()-StartDate.getTime();
        int Days = (int) TimeUnit.DAYS.convert(Duration,TimeUnit.MILLISECONDS);

        HotelList.add(new HotelDetails("Lakewood", 110,90));
        HotelList.add(new HotelDetails("Bridgewood", 150,50));
        HotelList.add(new HotelDetails("Ridgewood", 220,150));

        for (int hotel = 0; hotel < HotelList.size(); hotel++) {
            int newRate = HotelList.get(hotel).getWeekdayRate() * (Days+1);
            HotelList.get(hotel).setWeekdayRate(newRate);
        }
        int regularRate = HotelList.stream().min(Comparator.comparing(HotelDetails::getWeekdayRate)).get().getWeekdayRate();
        String hotelName = HotelList.stream().min(Comparator.comparing(HotelDetails::getWeekdayRate)).get().getHotelName();

        System.out.println(hotelName + ", Total Rates: $" + regularRate);

        return hotelName + ", $" + regularRate;

    }
    public Date convertStringToDate(String dateString) throws ParseException {
        Date date;
        DateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
        date = dateFormat.parse(dateString);
        return date;
    }
}
