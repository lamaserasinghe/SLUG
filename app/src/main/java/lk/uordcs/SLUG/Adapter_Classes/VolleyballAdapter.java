package lk.uordcs.SLUG.Adapter_Classes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import lk.uordcs.SLUG.R;
import lk.uordcs.SLUG.REST_Classes.BadmintonResults;
import lk.uordcs.SLUG.REST_Classes.HockeyResults;
import lk.uordcs.SLUG.REST_Classes.VolleyballResults;

public class VolleyballAdapter extends RecyclerView.Adapter<VolleyballAdapter.VolleyballViewHolder> implements Filterable {
    private Context mCtx;
    private List<VolleyballResults> resultsList;
    private List<VolleyballResults> resultsListFull;

    public VolleyballAdapter(Context mCtx, List<VolleyballResults> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
        resultsListFull=new ArrayList<>(resultsList);
    }

    public VolleyballViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.badminton_result_card, null);
        return new VolleyballViewHolder(view);
    }

    public void onBindViewHolder(VolleyballViewHolder holder, int position) {
        //getting the product of the specified position
        VolleyballResults results=resultsList.get(position);

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
        holder.tvUni1Wins.setText(String.valueOf(results.getUni1Score()+"/5"));
        holder.tvUni2.setText(String.valueOf(results.getUni2()));
        holder.tvUni2Wins.setText(String.valueOf(results.getUni2Score()+"/5"));
        holder.tvResult.setText(String.valueOf(results.getWinner()+" has won the match"));
        holder.tvMatchNo.setText(String.valueOf(results.getMatchNo()));
        Picasso.get().load(String.valueOf(results.getLogoLink1())).into(holder.imgLogo1);
        Picasso.get().load(String.valueOf(results.getLogoLinks2())).into(holder.imgLogo2);


    }

    public int getItemCount() {
        return resultsList.size();
    }

    public Filter getFilter() {
        return resultFilter;
    }


    class VolleyballViewHolder extends RecyclerView.ViewHolder {

        private TextView tvRound,tvGender,tvUni1,tvUni2,tvUni1Wins,tvUni2Wins,tvResult,tvDate,tvMatchNo;
        ImageView imgLogo1,imgLogo2;
        public VolleyballViewHolder(View itemView) {
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
            List<VolleyballResults> filteredList=new ArrayList<>();

            if(constraint==null || constraint.length()==0){
                filteredList.addAll(resultsListFull);
            }
            else{
                String filterPattern=constraint.toString().toLowerCase().trim();

                for(VolleyballResults item:resultsListFull){
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


