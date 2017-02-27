package booking.bus.trains.hotel.flight.deals.travel.smarttraveller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    ListView lv;
    CustomList customListAdapter;
    private String[] url_list;
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
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ListActivity.this, WebsiteVisit.class);
                    if (url_list.length > position) {
                        WebsiteVisit.setURL(url_list[position]);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ListActivity.this, "NO urls available here", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}