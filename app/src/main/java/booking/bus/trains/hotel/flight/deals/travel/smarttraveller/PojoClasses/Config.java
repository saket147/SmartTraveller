package booking.bus.trains.hotel.flight.deals.travel.smarttraveller.PojoClasses;

/**
 * Created by socket on 26/2/17.
 */

public class Config {
    public static POJO pojo;
    public static Deal deal;
    public static String LOAD_DEALS="https://tools.vcommission.com/api/coupons.php?apikey=e69e4c05c4fb49f34e4c14bf7d74396fa21f84a08c525cf4e1aef9174bd551a3";

    public static POJO getPojo() {
        return pojo;
    }

    public static void setPojo(POJO pojo) {
        Config.pojo = pojo;
    }

    public static void setDeal(Deal deal) {
        Config.deal = deal;
    }

    public static Deal getDeal() {
        return deal;
    }

    public static String POST = "POST";
    public static String GET = "GET";

}
