package booking.bus.trains.hotel.flight.deals.travel.smarttraveller;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,NetworkResponseListener{
    EditText editTextInput;
    RecyclerView recyclerView;
    private AdapterView.OnItemClickListener mListener;
    private POJO pojo;
    private EditText googleSearchEditText;
    Context context;

    private RecyclerView dealsList;

    private final String items_names[] = {
            "Flight",
            "Trains",
            "Bus",
            "Cabs",
            "Hotels",
            "Packages",
            "Explore",
            "Support"
    };

    private final int android_image_urls[] = {
            R.drawable.flights_min,R.drawable.trains_min,R.drawable.bus_min,R.drawable.taxi_min,R.drawable.hotels_min,
            R.drawable.packages_min,R.drawable.explore_min,R.drawable.customer_support_min

    };

    private final String flight_names[] = {
            "Air India",
            "AirVistara",
            "CheapFlights",
            "Cleartrip",
            "EaseMyTrip",
            "Emirates",
            "etihad",
            "Expedia",
            "GoAir",
            "Goibibo",
            "Goindigo",
            "Irctc",
            "ixigo",
            "Jet Airways",
            "Kayak",
            "Lufthansa",
            "MakeMyTrip",
            "Musafir",
            "Paytm ",
            "Skyscanner",
            "SpiceJet ",
            "Via",
            "Wego",
            "Yatra",
    };
    private final String flight_urls[] = {
            "http://tiny.cc/m9tgjy",
            "https://www.airvistara.com/trip/",
            "http://tiny.cc/j5tgjy",
            "http://tiny.cc/sssgjy",
            "https://www.easemytrip.com/",
            "https://linksredirect.com/?pub_id=13700CL12385&source=linkkit&url=http%3A//www.emirates.com/",
            "http://tiny.cc/91sgjy",
            "http://tracking.vcommission.com/aff_c?offer_id=779&aff_id=55764",
            "http://tiny.cc/waugjy",
            "http://tiny.cc/m7tgjy",
            "http://tiny.cc/dwtgjy",
            "http://www.air.irctc.co.in/IndianRailways/",
            "http://tiny.cc/3ztgjy",
            "https://linksredirect.com/?pub_id=13700CL12385&source=linkkit&url=http%3A//www.jetairways.com/EN/IN/Home.aspx",
            "http://tiny.cc/maugjy",
            "http://tiny.cc/rytgjy",
            "https://www.makemytrip.com/flights",
            "https://linksredirect.com/?pub_id=13700CL12385&subid=4.0&source=linkkit&url=http%3A//in.musafir.com/",
            "http://tiny.cc/uusgjy",
            "http://tiny.cc/hztgjy",
            "http://www.spicejet.com/",
            "http://tiny.cc/srsgjy",
            "https://www.wego.co.in/",
            "http://tiny.cc/30sgjy"


    };
    private final String train_names[] = {
            "Cleartrip",
            "IRCTC",
            "MakeMyTrip",
            "PNR Status",
            "Train Running Status"
    };

    private final String train_urls[] = {
            "http://tiny.cc/sssgjy",
            "https://www.irctc.co.in/eticketing/loginHome.jsf",
            "https://www.makemytrip.com/railways",
            "http://www.indianrail.gov.in/pnr_Enq.html",
            "http://enquiry.indianrail.gov.in/mntes/"

    };
    private final String bus_names[] ={
            "AbhiBus",
            "Bookmybus",
            "MakemyTrip",
            "Paytm ",
            "Redbus",
            "TicketGoose",
            "TravelYaari",
            "Yatra"
    };
    private final String bus_urls[] = {
            "http://tiny.cc/2jugjy",
            "http://tiny.cc/rlugjy",
            "http://tiny.cc/jrsgjy",
            "http://tiny.cc/uusgjy",
            "http://tiny.cc/wcugjy",
            "http://tiny.cc/dzsgjy",
            "http://tiny.cc/1kugjy",
            "http://tiny.cc/30sgjy"
    };
    private final String cab_names[] ={
            "Blablacar",
            "Clearcarrentals",
            "Easy Cabs ",
            "ibibo Ryde",
            "Mega Cabs ",
            "Meru Cabs",
            "Myles",
            "Savaari",
            "Uber",
            "ZoomCar"
    };
    private final String cab_urls[] = {
            "http://tiny.cc/8qugjy",
            "http://tiny.cc/2rugjy",
            "http://tiny.cc/7sugjy",
            "http://tiny.cc/3tugjy",
            "http://tiny.cc/uuugjy",
            "http://tiny.cc/0uugjy",
            "http://tiny.cc/97sgjy",
            "http://tiny.cc/evugjy",
            "https://play.google.com/store/apps/details?id=com.ubercab&referrer=mat_click_id%3D91fbd4358aab63036222877bc3fcd4ea-20170226-7336%26utm_campaign%3DInternal%26utm_content%3DInternal%26utm_medium%3DInternal%26utm_source%3DUber.com%26utm_term%3DInternal",
            "http://tiny.cc/c7sgjy"
    };
    private final String hotel_names[] ={
            "Agoda",
            "Airbnb",
            "Booking",
            "CheapHotels",
            "Cleartrip",
            "Expedia",
            "Goibibo",
            "Hostel World",
            "Hotel Tonight",
            "Hotels.com",
            "Smart Stay",
            "Home Stay",
            "Ixigo",
            "Kayak",
            "MakeMyTrip",
            "Oyo",
            "RedBus",
            "Right Stay(by MakeMyTrip)",
            "Skyscanner",
            "TravelGuru",
            "Treebo",
            "Trip Advisor",
            "Trivago",
            "Via",
            "Vistaroom",
            "Wego",
            "Yatra",
            "Zoom",
            "Zostel"
    };
    private final String hotel_urls[] = {
            "http://tiny.cc/hwsgjy",
            "http://tiny.cc/xeugjy",
            "http://tiny.cc/4dugjy",
            "http://tiny.cc/7cugjy",
            "http://tiny.cc/sssgjy",
            "http://tracking.vcommission.com/aff_c?offer_id=779&aff_id=55764",
            "http://tiny.cc/m7tgjy",
            "http://www.hostelworld.com/",
            "http://tiny.cc/ebugjy",
            "http://tiny.cc/vwsgjy",
            "http://www.smartstay.in/",
            "https://www.homestays.in/",
            "http://tiny.cc/3ztgjy",
            "http://tiny.cc/maugjy",
            "http://tiny.cc/9rsgjy",
            "http://tiny.cc/avsgjy",
            "https://www.redbus.in/hotels/",
            "http://tiny.cc/c5sgjy",
            "http://tiny.cc/hztgjy",
            "http://tiny.cc/x5sgjy",
            "http://tiny.cc/tvsgjy",
            "http://tiny.cc/2gugjy",
            "http://tiny.cc/hcugjy",
            "http://tiny.cc/srsgjy",
            "http://tiny.cc/o6sgjy",
            "http://tiny.cc/47tgjy",
            "http://tiny.cc/30sgjy",
            "http://zoomsmarthotels.com/",
            "http://tiny.cc/khugjy"
    };

    private final String packages_names[] = {
            "Goibibo",
            "HolidayIQ",
            "IRCTC",
            "MakeMyTrip",
            "Musafir",
            "Oyo",
            "SOTC",
            "Thomas & Cook",
            "Travel Guru",
            "Travel Triangle",
            "Via",
            "Yatra"
    };

    private final String packages_urls[] = {
            "http://tiny.cc/m7tgjy",
            "http://tiny.cc/pmugjy",
            "https://www.irctc.co.in/",
            "http://tiny.cc/jrsgjy",
            "https://linksredirect.com/?pub_id=13700CL12385&subid=4.0&source=linkkit&url=http%3A//in.musafir.com/",
            "http://tiny.cc/avsgjy",
            "http://tiny.cc/bqugjy",
            "http://tiny.cc/dpugjy",
            "http://tiny.cc/x5sgjy",
            "http://tiny.cc/dmugjy",
            "http://tiny.cc/srsgjy",
            "http://tiny.cc/30sgjy"
    };

    private final String explore_names[] ={
            "Google Maps",
            "Lonely Planet ",
            "Trip Advisor",
            "Whether info",
            "XE - Currency Converter"
    };
    private final String explore_urls[] = {

    };

    private final String support_names[] ={};
    private final String support_urls[] = {};
    private void SearchView(){
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        String term = googleSearchEditText.getText().toString();
        intent.putExtra(SearchManager.QUERY, term);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AppRater.app_launched(this);
        dealsList = (RecyclerView) findViewById(R.id.dealsList);
        googleSearchEditText = (EditText) findViewById(R.id.search_google);
        googleSearchEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });
//        googleSearchEditText.setOnKeyListener(new View.OnKeyListener()
//        {
//            public boolean onKey(View v, int keyCode, KeyEvent event)
//            {
//                if (event.getAction() == KeyEvent.ACTION_DOWN)
//                {
//                    switch (keyCode)
//                    {
//                        case KeyEvent.KEYCODE_DPAD_CENTER:
//                        case KeyEvent.KEYCODE_ENTER:
//                            SearchView();
//                            return true;
//                        default:
//                            break;
//                    }
//                }
//                return false;
//            }
//        });
        googleSearchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    SearchView();
                    return true;
                }
                return false;
            }
        });
        recyclerView = (RecyclerView)findViewById(R.id.iconsView);
        //recyclerView.setHasFixedSize(false);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0 :
                        pojo = new POJO(flight_urls,flight_names, android_image_urls[0], items_names[0]);
                        break;
                    case 1 :
                        pojo = new POJO(train_urls,train_names, android_image_urls[1], items_names[1]);
                        break;
                    case 2 :
                        pojo = new POJO(bus_urls,bus_names, android_image_urls[2], items_names[2]);
                        break;
                    case 3 :
                        pojo = new POJO(cab_urls,cab_names, android_image_urls[3], items_names[3]);
                        break;
                    case 4 :
                        pojo = new POJO(hotel_urls,hotel_names, android_image_urls[4], items_names[4]);
                        break;
                    case 5 :
                        pojo = new POJO(packages_urls,packages_names, android_image_urls[5], items_names[5]);
                        break;
                    case 6 :
                        pojo = new POJO(explore_urls,explore_names, android_image_urls[6], items_names[6]);
                        break;
                    case 7 :
                        pojo = new POJO(support_urls,support_names, android_image_urls[7], items_names[7]);
                        break;
                }
                Intent intent = new Intent(MainActivity.this,ListActivity.class);
             Config.setPojo(pojo);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                // ...
            }
        }));
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//      //  ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//       //         this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        //drawer.setDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
        initViews();
//        loadDeals();
    }

private void loadDeals(){
    FetchData fetchData = new FetchData(MainActivity.this,MainActivity.this);
    fetchData.setType_of_request(Config.GET);
    fetchData.setUrl(Config.LOAD_DEALS);
    fetchData.execute();
}


    @Override
    public void preRequest() {

    }

    @Override
    public void postRequest(Object object) {
        //Parse object to convert to array for deals






    //Set Deals adapter
    }
    private void initViews(){
     //   recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),4);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<IconsPOJO> androidVersions = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(),androidVersions);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager newLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        dealsList.setLayoutManager(newLayoutManager);
        DealsAdapter dealsAdapter = new DealsAdapter(MainActivity.this);
        dealsList.setAdapter(dealsAdapter);
    }
    private ArrayList<IconsPOJO> prepareData(){
        ArrayList<IconsPOJO> android_version = new ArrayList<>();
        for(int i=0;i<items_names.length;i++){
            IconsPOJO androidVersion = new IconsPOJO();
            androidVersion.setItem_name(items_names[i]);
            androidVersion.setImage_id(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }

    @Override
    public void onBackPressed() {
        Log.d("Back Pressed","Bp");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_search) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
