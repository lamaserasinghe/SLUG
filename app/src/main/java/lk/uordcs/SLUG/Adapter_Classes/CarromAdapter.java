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

import lk.uordcs.SLUG.R;
import lk.uordcs.SLUG.REST_Classes.BaseballResults;
import lk.uordcs.SLUG.REST_Classes.CarromResults;

public class CarromAdapter extends RecyclerView.Adapter<CarromAdapter.CarromViewHolder> implements Filterable {

    private Context mCtx;

    private List<CarromResults> resultsListFull;
    private List<CarromResults> resultsList;

    public CarromAdapter(Context mCtx, List<CarromResults> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
        resultsListFull=new ArrayList<>(resultsList);
    }

    public CarromAdapter.CarromViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.badminton_result_card, null);
        return new CarromAdapter.CarromViewHolder(view);
    }

    public void onBindViewHolder(CarromAdapter.CarromViewHolder holder, int position) {
        //getting the product of the specified position
        CarromResults results = resultsList.get(position);

        //binding the data with the viewholder views
        holder.tvRound.setText(String.valueOf(results.getRound()));
        if(String.valueOf(results.getGender()).equals("M")){
            holder.tvGender.setText("Men's");
        }
        else if(String.valueOf(results.getGender()).equals("W")){
            holder.tvGender.setText("Women's");
        }

        holder.tvDate.setText(String.valueOf(results.getDate()));
        holder.tvUni1.setText(String.valueOf(results.getUni1()));
        holder.tvUni1Wins.setText(String.valueOf(results.getUni1Wins()));
        holder.tvUni2.setText(String.valueOf(results.getUni2()));
        holder.tvUni2Wins.setText(String.valueOf(results.getUni2Wins()));
        holder.tvResult.setText(String.valueOf(results.getWinner()+" won the match"));
        holder.tvMatchNo.setText(String.valueOf(results.getMatchNo()));
        Picasso.get().load(String.valueOf(results.getLogoLink1())).into(holder.imgLogo1);
        Picasso.get().load(String.valueOf(results.getLogoLinks2())).into(holder.imgLogo2);

    }

    public int getItemCount() {
        return resultsList.size();
    }

    @Override
    public Filter getFilter() {
        return resultFilter;
    }

    class CarromViewHolder extends RecyclerView.ViewHolder {

        private TextView tvRound,tvGender,tvUni1,tvUni2,tvUni1Wins,tvUni2Wins,tvResult,tvDate,tvMatchNo;
        ImageView imgLogo1,imgLogo2;

        public CarromViewHolder(View itemView) {
            super(itemView);

            tvDate=itemView.findViewById(R.id.date);
            tvRound=itemView.findViewById(R.id.round);
            tvGender=itemView.findViewById(R.id.gender);
            tvUni1=itemView.findViewById(R.id.uni1);
            tvUni1Wins=itemView.findViewById(R.id.uni1Wins);
            tvUni2=itemView.findViewById(R.id.uni2);
            tvUni2Wins=itemView.findViewById(R.id.uni2Wins);
            tvResult=itemView.findViewById(R.id.result);
            tvMatchNo=itemView.findViewById(R.id.matchNo);
            imgLogo1=itemView.findViewById(R.id.logo1);
            imgLogo2=itemView.findViewById(R.id.logo2);
        }
    }
    private Filter resultFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<CarromResults> filteredList=new ArrayList<>();

            if(constraint==null || constraint.length()==0){
                filteredList.addAll(resultsListFull);
            }
            else{
                String filterPattern=constraint.toString().toLowerCase().trim();

                for(CarromResults item:resultsListFull){
                    if(item.getUni1().toLowerCase().contains(filterPattern)||item.getUni2().toLowerCase().contains(filterPattern)||item.getDate().toLowerCase().contains(filterPattern)||item.getRound().toLowerCase().contains(filterPattern)) {
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








