package hotelreservationsystem;

public class HotelDetails {
	private String hotelName;
	private int weekdayRate;
    private int weekendRate;
    private int rating;
    private int rewardCustomerWeekdayRate;
    private int rewardCustomerWeekendrate;


    public HotelDetails(String hotelName, int weekdayRate, int weekendRate, int rating,int rewardCustomerWeekdayRate, int rewardCustomerWeekendrate) {
        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.rating = rating;
        this.rewardCustomerWeekdayRate = rewardCustomerWeekdayRate;
        this.rewardCustomerWeekendrate = rewardCustomerWeekendrate;

    }

    public int getRewardCustomerWeekdayRate() {
        return rewardCustomerWeekdayRate;
    }

    public void setRewardCustomerWeekdayRate(int rewardCustomerWeekdayRate) {
        this.rewardCustomerWeekdayRate = rewardCustomerWeekdayRate;
    }

    public int getRewardCustomerWeekendrate() {
        return rewardCustomerWeekendrate;
    }

    public void setRewardCustomerWeekendrate(int rewardCustomerWeekendrate) {
        this.rewardCustomerWeekendrate = rewardCustomerWeekendrate;
    }
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getWeekdayRate() {
        return weekdayRate;
    }

    public void setWeekdayRate(int weekdayRate) {
        this.weekdayRate = weekdayRate;
    }

    public int getWeekendRate() {
        return weekendRate;
    }

    public void setWeekendRate(int weekendRate) {
        this.weekendRate = weekendRate;
    }
}
