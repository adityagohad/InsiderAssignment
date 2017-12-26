package in.adzlab.insiderassignment.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.adzlab.insiderassignment.R;
import in.adzlab.insiderassignment.model.InsiderEvent;

/**
 * Created by adityagohad on 26/12/17.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewH> {
    private Context context;
    private List<InsiderEvent> insiderEvents;

    public EventsAdapter(Context context, List<InsiderEvent> insiderEvents) {
        this.context = context;
        this.insiderEvents = insiderEvents;
    }

    @Override
    public ViewH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventCardVH(LayoutInflater.from(context).inflate(R.layout.view_insider_event, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewH holder, int position) {
        if(insiderEvents != null){
            InsiderEvent insiderEvent = insiderEvents.get(position);
            EventCardVH eventCardVH = (EventCardVH) holder;
            if(insiderEvent.getHorizontal_cover_image() != null){
                if(!insiderEvent.getHorizontal_cover_image().equals("")){
                    Picasso.with(context).load(insiderEvent.getHorizontal_cover_image()).into(eventCardVH.bannerImage);
                }
            }
            try {
                eventCardVH.tiltle.setText(insiderEvent.getName());
                eventCardVH.time.setText(insiderEvent.getVenue_date_string());
                eventCardVH.venue.setText(insiderEvent.getVenue_name());
                eventCardVH.price.setText("\u20B9 "+insiderEvent.getPrice_display_string());
            }catch (NullPointerException e){

            }
        }
    }

    @Override
    public int getItemCount() {
        return insiderEvents == null ? 0 : insiderEvents.size();
    }

    public void swapData(List<InsiderEvent> insiderEvents) {
        this.insiderEvents = insiderEvents;
        notifyDataSetChanged();
    }

    class ViewH extends RecyclerView.ViewHolder {
        ViewH(View itemView) {
            super(itemView);
        }
    }

    private class EventCardVH extends ViewH{
        ImageView bannerImage;
        TextView tiltle, time, venue, price;
        EventCardVH(View itemView) {
            super(itemView);

            bannerImage = (ImageView) itemView.findViewById(R.id.ie_iv_banner);
            tiltle = (TextView) itemView.findViewById(R.id.ie_tv_title);
            time = (TextView) itemView.findViewById(R.id.ie_tv_date);
            venue = (TextView) itemView.findViewById(R.id.ie_tv_venue);
            price = (TextView) itemView.findViewById(R.id.ie_tv_price_range);
        }
    }
}
