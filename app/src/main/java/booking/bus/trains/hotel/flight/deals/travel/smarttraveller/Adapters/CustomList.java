package booking.bus.trains.hotel.flight.deals.travel.smarttraveller.Adapters;

/**
 * Created by socket on 25/2/17.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import booking.bus.trains.hotel.flight.deals.travel.smarttraveller.PojoClasses.POJO;
import booking.bus.trains.hotel.flight.deals.travel.smarttraveller.R;

public class CustomList extends BaseAdapter{
    private Context context;
    private Activity activity;
    //private ArrayList<IconsPOJO> icons;
    private POJO pojo;
    private String[] pojoname;
    public CustomList(Activity activity,Context context, POJO pojo) {
        //this.icons = android;
        this.context = context;
        this.pojo = pojo;
        pojoname = pojo.getName();
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return pojoname.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        //use converview recycle
        View rootView = convertView;
        LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (rootView == null)
            rootView = inflater.inflate(R.layout.list_single, null);;
            TextView textView= (TextView) rootView.findViewById(R.id.txt);
            ImageView imageView= (ImageView) rootView.findViewById(R.id.img);
        imageView.setImageResource(pojo.getImage_id());
        textView.setText(pojoname[position]);
        return rootView;
    }


}