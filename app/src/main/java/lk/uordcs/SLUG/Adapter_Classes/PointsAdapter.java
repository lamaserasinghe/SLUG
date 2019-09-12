package lk.uordcs.SLUG.Adapter_Classes;

import android.content.Context;
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

import lk.uordcs.SLUG.PointsActivity;
import lk.uordcs.SLUG.R;
import lk.uordcs.SLUG.REST_Classes.Points;

public class PointsAdapter extends RecyclerView.Adapter<PointsAdapter.PointsViewHolder> implements Filterable {
    private Context mCtx;
    private List<Points> resultsList;
    private List<Points> resultsListFull;

    public PointsAdapter(Context mCtx, List<Points> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
        this.resultsListFull = new ArrayList<>(resultsList);
    }




    public PointsAdapter.PointsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.points_result_card, null);
        return new PointsAdapter.PointsViewHolder(view);
    }

    public void onBindViewHolder(PointsViewHolder holder, int position) {
        //getting the product of the specified position
        Points results=resultsList.get(position);

        //binding the data with the viewholder views


        //holder.tvLogo.setText(String.valueOf(results.getUniName()));
        holder.tvUniName.setText(String.valueOf(results.getUniName()));
        holder.tvMen.setText(String.valueOf(results.getMensTotal()));
        holder.tvWomen.setText(String.valueOf(results.getWomensTotal()));
        holder.tvTotal.setText(String.valueOf(results.getTotal()));
        Picasso.get().load(String.valueOf(results.getLogoLink1())).into(holder.imgLogo1);
        //Picasso.get().load(String.valueOf(results.getLogoLinks2())).into(holder.imgLogo2);



    }

    @Override
    public int getItemCount() {

            return resultsList.size();
    }

    @Override
    public Filter getFilter() {
        return resultFilter;
    }


    class PointsViewHolder extends RecyclerView.ViewHolder {

    private TextView tvLogo,tvUniName,tvMen,tvWomen,tvTotal;
    ImageView imgLogo1;

    public PointsViewHolder(View itemView) {
        super(itemView);

        tvLogo=itemView.findViewById(R.id.tvUniName);
        tvUniName=itemView.findViewById(R.id.tvUniName);
        tvMen=itemView.findViewById(R.id.tvMen);
        tvWomen=itemView.findViewById(R.id.tvWomen);
        tvTotal=itemView.findViewById(R.id.tvTotal);
        imgLogo1=itemView.findViewById(R.id.logo1);

    }
}


    private Filter resultFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Points> filteredList=new ArrayList<>();

            if(constraint==null || constraint.length()==0){
                filteredList.addAll(resultsListFull);
            }
            else{
                String filterPattern=constraint.toString().toLowerCase().trim();

                for(Points item:resultsListFull){
                    if(item.getUniName().toLowerCase().contains(filterPattern)) {
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
