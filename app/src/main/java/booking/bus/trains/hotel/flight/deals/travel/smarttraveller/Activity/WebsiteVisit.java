package booking.bus.trains.hotel.flight.deals.travel.smarttraveller.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import booking.bus.trains.hotel.flight.deals.travel.smarttraveller.R;

/**
 * Created by socket on 26/2/17.
 */

public class WebsiteVisit extends Activity{
    public static String URL = "";
    public static String NAME = "";
    public static String GROUP = "";



    private String queryURL, notificationURl;
    private ProgressBar progressDialog;
    WebView browser;
    SwipeRefreshLayout mySwipeRefreshLayout;
    TextView title;
    ImageView share, close;
    public static void setURL(String URL) {
        WebsiteVisit.URL = URL;
    }
    public static void setName(String URL) {
        WebsiteVisit.NAME = URL;
    }
    public static void setGROUP(String URL) {
        WebsiteVisit.GROUP = URL;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.website_visit);

        title = (TextView) findViewById(R.id.title_website);
        share = (ImageView) findViewById(R.id.sharePage);
        close = (ImageView) findViewById(R.id.backWebpage);
        mySwipeRefreshLayout = (SwipeRefreshLayout)this.findViewById(R.id.swipeContainer);
         browser= (WebView) this.findViewById(R.id.webview);
        progressDialog = (ProgressBar) findViewById(R.id.progress_bar);
        title.setText(GROUP+ " > " +NAME);
        // browser.setWebViewClient(new WebViewClient());

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, URL);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (queryURL == null){
                    Intent goToA = new Intent(WebsiteVisit.this, ListActivity.class);
                    goToA.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(goToA);
                }else {
                    Intent goToA = new Intent(WebsiteVisit.this, MainActivity.class);
                    goToA.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(goToA);
                }

            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle!= null){
            queryURL= bundle.getString("googlequery");
            notificationURl = bundle.getString("notification_url");

        }


        browser.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if (progressDialog.getVisibility() == View.VISIBLE) {
                    progressDialog.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(WebsiteVisit.this, "Error:" + description, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressDialog.setVisibility(View.VISIBLE);
            }
        });
        browser.clearCache(true);
        browser.clearHistory();
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        if (queryURL == null){
            browser.loadUrl(URL);
        }else {
            browser.loadUrl(queryURL);
            title.setText("SmartTraveller");
        }
        browser.loadUrl(notificationURl);
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        browser.reload();
                    }
                }
        );

    }
}
