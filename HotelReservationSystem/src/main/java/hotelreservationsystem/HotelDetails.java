package hotelreservationsystem;

public class HotelDetails {
	private String hotelName;
    private int regularRate;

    public HotelDetails(String hotelName, int regularRate) {
        this.hotelName = hotelName;
        this.regularRate = regularRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRegularRate() {
        return regularRate;
    }

    public void setRegularRate(int regularRate) {
        this.regularRate = regularRate;
    }
}
