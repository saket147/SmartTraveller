package booking.bus.trains.hotel.flight.deals.travel.smarttraveller;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by socket on 27/2/17.
 */

public class AppRater {
    private final static String APP_TITLE = "SmartTraveller";
    private final static String APP_PNAME = "booking.bus.trains.hotel.flight.deals.travel.smarttraveller";// Package Name

    private final static int DAYS_UNTIL_PROMPT = 3;
    private final static int LAUNCHES_UNTIL_PROMPT = 4;

    public static void app_launched(Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("apprater", 0);
        if (prefs.getBoolean("dontshowagain", false)) { return ; }


        SharedPreferences.Editor editor = prefs.edit();

        // Increment launch counter
        long launch_count = prefs.getLong("launch_count", 0) + 1;
        editor.putLong("launch_count", launch_count);

        // Get date of first launch
        Long date_firstLaunch = prefs.getLong("date_firstlaunch", 0);
        if (date_firstLaunch == 0) {
            date_firstLaunch = System.currentTimeMillis();
            editor.putLong("date_firstlaunch", date_firstLaunch);
        }

        // Wait at least n days before opening
        if (launch_count >= LAUNCHES_UNTIL_PROMPT) {
            if (System.currentTimeMillis() >= date_firstLaunch +
                    (DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000)) {
                showRateDialog(mContext, editor);
            }
        }

        editor.commit();
    }

    public static void showRateDialog(final Context mContext, final SharedPreferences.Editor editor) {
        final Dialog dialog = new Dialog(mContext);
        dialog.setTitle("Rate " + APP_TITLE);
        dialog.setContentView(R.layout.rate_app_layout);
        dialog.getWindow().setLayout(1085,700);


        LinearLayout ll = new LinearLayout(mContext);

        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setPadding(40,20,40,0);

        TextView tv = new TextView(mContext);
        tv.setText("Love this app?");
        tv.setTextColor(Color.BLACK);
        tv.setWidth(100);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setTextSize(20);
        ll.addView(tv);


        TextView tv2 = new TextView(mContext);
        tv2.setText("Please take a moment to rate us");
        tv2.setTextColor(Color.BLACK);
        tv2.setTextSize(18);
        tv2.setPadding(0,20,0,0);
        tv2.setWidth(100);
        ll.addView(tv2);

        ContextThemeWrapper newContext = new ContextThemeWrapper(mContext, R.style.RatingBar);
        RatingBar ratingBar = new RatingBar(newContext);
        ratingBar.setNumStars(5);
        ratingBar.setStepSize(1);
        ratingBar.setPadding(0,40,0,0);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;

        ratingBar.setLayoutParams(params);
        ll.addView(ratingBar);

        LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.setPadding(0,20,0,0);

        LinearLayout.LayoutParams paramLinear = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        paramLinear.gravity = Gravity.RIGHT;

        TextView textView = new TextView(mContext);
        textView.setText("djfksjkdflksfdlksghdf");
        textView.setVisibility(View.INVISIBLE);
        linearLayout.addView(textView);

        Button b1 = new Button(mContext);
        b1.setText("RATE NOW");
        b1.setLayoutParams(paramLinear);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME)));
                dialog.dismiss();
            }
        });
        linearLayout.addView(b1);


        Button b3 = new Button(mContext);
        b3.setText("LATER");
        b3.setLayoutParams(paramLinear);
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (editor != null) {
                    editor.putBoolean("dontshowagain", true);
                    editor.commit();
                }
                dialog.dismiss();
            }
        });

        linearLayout.addView(b3);

        ll.addView(linearLayout);
        dialog.setContentView(ll);
        dialog.show();
    }
}
