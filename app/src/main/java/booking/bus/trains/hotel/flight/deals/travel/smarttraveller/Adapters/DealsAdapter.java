package booking.bus.trains.hotel.flight.deals.travel.smarttraveller.Adapters;

/**
 * Created by socket on 26/2/17.
 */

/**
 * Created by socket on 25/2/17.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import booking.bus.trains.hotel.flight.deals.travel.smarttraveller.PojoClasses.Config;
import booking.bus.trains.hotel.flight.deals.travel.smarttraveller.PojoClasses.Deal;
import booking.bus.trains.hotel.flight.deals.travel.smarttraveller.PojoClasses.POJO;
import booking.bus.trains.hotel.flight.deals.travel.smarttraveller.R;


public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.ViewHolder> {
    private Context context;
    private Deal deal;
    private Activity activity;
    //private String[] dealName;

    public DealsAdapter(Activity activity, Context context, Deal deal) {
        this.context = context;
        this.deal = deal;
        this.activity = activity;
        //this.dealName = deal.getClass();
    }

    @Override
    public DealsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.deals_adapter_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.codeRequired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Work still in progres",Toast.LENGTH_SHORT).show();
            }
        });
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/html");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml("<p>This is the text that will be shared.</p>"));
                context.startActivity(Intent.createChooser(sharingIntent,"Share using"));
            }
        });
        holder.date.setText("");
        holder.company_name.setText("");
        holder.description.setText("");
    }



    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private Button codeRequired;
        private ImageView share;
        private TextView date, company_name, description;
        public ViewHolder(View view) {
            super(view);
            codeRequired = (Button) view.findViewById(R.id.codeRequired);
            share = (ImageView) view.findViewById(R.id.share);
            date = (TextView) view.findViewById(R.id.date);
            company_name = (TextView) view.findViewById(R.id.companyName);
            description = (TextView) view.findViewById(R.id.description);
        }
    }

}

