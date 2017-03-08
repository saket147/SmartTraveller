package booking.bus.trains.hotel.flight.deals.travel.smarttraveller.PojoClasses;

import java.util.ArrayList;

/**
 * Created by socket on 26/2/17.
 */

public class POJO {
    String[] url,name;
    int image_id;
    String group_name;

    public POJO(String[] url,String[] name, int imageId, String group_name){
        this.url = url;
        this.name = name;
        this.image_id = imageId;
        this.group_name = group_name;
    };

    public String[] getName() {
        return name;
    }

    public String[] getUrl() {
        return url;
    }

    public int getImage_id() {
        return image_id;
    }

    public String getGroup_name() {
        return group_name;
    }
}
