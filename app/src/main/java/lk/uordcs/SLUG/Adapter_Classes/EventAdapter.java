package lk.uordcs.SLUG.Adapter_Classes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import lk.uordcs.SLUG.EventScheduleActivity;
import lk.uordcs.SLUG.R;
import lk.uordcs.SLUG.REST_Classes.EventSchedule;
import lk.uordcs.SLUG.REST_Classes.Points;


public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventsViewHolder> implements Filterable {
    private Context mCtx;
    private List<EventSchedule> resultsList;
    private List<EventSchedule> resultsListFull;

    public EventAdapter(Context mCtx, List<EventSchedule> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
        this.resultsListFull =  new ArrayList<>(resultsList);
    }

    public EventAdapter.EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.event, null);
        return new EventAdapter.EventsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsViewHolder holder, int position) {
        //getting the product of the specified position
        EventSchedule results=resultsList.get(position);

        //binding the data with the viewholder views


        //holder.tvLogo.setText(String.valueOf(results.getUniName()));
        holder.tvEvent.setText(String.valueOf(results.getEvent()));
        holder.tvDate.setText(String.valueOf(results.getDates()));
        holder.tvVenue.setText(String.valueOf(results.getVenue()));




    }

    @Override
    public int getItemCount() {

        return resultsList.size();
    }

    @Override
    public Filter getFilter() {
        return resultFilter;

    }


    class EventsViewHolder extends RecyclerView.ViewHolder {

        private TextView tvEvent,tvDate,tvVenue;
        ImageView imgLogo1;

        public EventsViewHolder(View itemView) {
            super(itemView);

            tvEvent=itemView.findViewById(R.id.tvEvent);
            tvDate=itemView.findViewById(R.id.tvDate);
            tvVenue=itemView.findViewById(R.id.tvVenue);
    }

}

    private Filter resultFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<EventSchedule> filteredList=new ArrayList<>();

            if(constraint==null || constraint.length()==0){
                filteredList.addAll(resultsListFull);
            }
            else{
                String filterPattern=constraint.toString().toLowerCase().trim();

                for(EventSchedule item:resultsListFull){
                    if(item.getEvent().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results=new FilterResults();
            results.values=filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            resultsList.clear();
            resultsList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
