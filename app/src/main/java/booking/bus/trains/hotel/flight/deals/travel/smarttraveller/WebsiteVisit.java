package booking.bus.trains.hotel.flight.deals.travel.smarttraveller;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by socket on 26/2/17.
 */

public class WebsiteVisit extends Activity{
    public static String URL = "";
    private ProgressBar progressDialog;
    public static void setURL(String URL) {
        WebsiteVisit.URL = URL;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.website_visit);
        WebView browser = (WebView) findViewById(R.id.webview);
        progressDialog = (ProgressBar) findViewById(R.id.progress_bar);
        // browser.setWebViewClient(new WebViewClient());
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
        browser.loadUrl(URL);


    }
}
