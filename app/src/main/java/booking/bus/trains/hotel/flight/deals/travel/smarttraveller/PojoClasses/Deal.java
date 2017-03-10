package booking.bus.trains.hotel.flight.deals.travel.smarttraveller.PojoClasses;

import org.json.JSONArray;

/**
 * Created by socket on 27/2/17.
 */

public class Deal {
    public static String DESCRIPTION = "description";
    public static String COUPON_CODE = "coupon_code";
    public static String COMPANY_NAME = "company_name";
    public static String LINK = "link";
    public static String DATE= "date";

    public Deal(String description, String coupon_code, String company_name, String link, String date) {
        this.DESCRIPTION = description;
        this.COUPON_CODE = coupon_code;
        this.COMPANY_NAME = company_name;
        this.LINK = link;
        this.DATE = date;
    }

    public static void setCompanyName(String companyName) {
        COMPANY_NAME = companyName;
    }

    public static void setCouponCode(String couponCode) {
        COUPON_CODE = couponCode;
    }

    public static void setDATE(String DATE) {
        Deal.DATE = DATE;
    }

    public static void setDESCRIPTION(String DESCRIPTION) {
        Deal.DESCRIPTION = DESCRIPTION;
    }

    public static void setLINK(String LINK) {
        Deal.LINK = LINK;
    }

    public static String getCompanyName() {
        return COMPANY_NAME;
    }

    public static String getCouponCode() {
        return COUPON_CODE;
    }

    public static String getDATE() {
        return DATE;
    }

    public static String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public static String getLINK() {
        return LINK;
    }
}
