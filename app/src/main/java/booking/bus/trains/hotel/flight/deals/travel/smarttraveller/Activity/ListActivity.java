package booking.bus.trains.hotel.flight.deals.travel.smarttraveller.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import booking.bus.trains.hotel.flight.deals.travel.smarttraveller.PojoClasses.Config;
import booking.bus.trains.hotel.flight.deals.travel.smarttraveller.Adapters.CustomList;
import booking.bus.trains.hotel.flight.deals.travel.smarttraveller.PojoClasses.POJO;
import booking.bus.trains.hotel.flight.deals.travel.smarttraveller.R;

public class ListActivity extends AppCompatActivity {

    ListView lv;
    CustomList customListAdapter;
    private String[] url_list;
    private String[] websites_names;
    private String group_name;
    private POJO pojo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lv = (ListView) findViewById(R.id.list_item_flight);
        Log.d("Pojo length", "POJO length" + Config.getPojo().getName().length);
        getSupportActionBar().setTitle(Config.getPojo().getGroup_name());

        if (Config.getPojo().getName().length == 0) {
            findViewById(R.id.emptyLayout).setVisibility(View.VISIBLE);
            lv.setVisibility(View.GONE);
        } else {
            customListAdapter = new CustomList(ListActivity.this, ListActivity.this, Config.getPojo());
            Log.d("Pojo length", "POJO length" + Config.getPojo().getName().length);
            lv.setAdapter(customListAdapter);
            url_list = Config.getPojo().getUrl();
            websites_names = Config.getPojo().getName();
            group_name = Config.getPojo().getGroup_name();

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ListActivity.this, WebsiteVisit.class);
                    if (url_list.length > position) {
                        WebsiteVisit.setURL(url_list[position]);
                        WebsiteVisit.setName(websites_names[position]);
                        WebsiteVisit.setGROUP(group_name);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ListActivity.this, "NO urls available here", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}