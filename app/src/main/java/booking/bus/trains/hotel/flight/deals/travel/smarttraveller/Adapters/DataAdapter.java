package booking.bus.trains.hotel.flight.deals.travel.smarttraveller.Adapters;

/**
 * Created by socket on 25/2/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import booking.bus.trains.hotel.flight.deals.travel.smarttraveller.PojoClasses.IconsPOJO;
import booking.bus.trains.hotel.flight.deals.travel.smarttraveller.R;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<IconsPOJO> icons;
    private Context context;

    public DataAdapter(Context context,ArrayList<IconsPOJO> android) {
        this.icons = android;
        this.context = context;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        Log.d("i is ","i is "+i);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        if(i> (icons.size()-5)){
            viewHolder.greyView.setVisibility(View.GONE);
        }
        viewHolder.tv_android.setText(icons.get(i).getItem_name());
        //Picasso.with(context).load(icons.get(i).getImage_id()).into(viewHolder.img_android);
       // Picasso.with(context).setIndic0atorsEnabled(true);
        viewHolder.img_android.setImageResource(icons.get(i).getImage_id());
    }

    @Override
    public int getItemCount() {
        return icons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_android;
        private ImageView img_android;
        private View greyView;
        public ViewHolder(View view) {
            super(view);
            greyView = view.findViewById(R.id.greyEdge);
            tv_android = (TextView)view.findViewById(R.id.textIcon);
            img_android = (ImageView) view.findViewById(R.id.iconsImage);
        }
    }

}
