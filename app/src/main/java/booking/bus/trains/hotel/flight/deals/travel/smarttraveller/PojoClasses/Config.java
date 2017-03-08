package booking.bus.trains.hotel.flight.deals.travel.smarttraveller.PojoClasses;

/**
 * Created by socket on 26/2/17.
 */

public class Config {
    public static POJO pojo;
    public static String LOAD_DEALS="";

    public static POJO getPojo() {
        return pojo;
    }

    public static void setPojo(POJO pojo) {
        Config.pojo = pojo;
    }
    public static String POST = "POST";
    public static String GET = "GET";

}
