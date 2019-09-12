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
import lk.uordcs.SLUG.REST_Classes.HockeyResults;
import lk.uordcs.SLUG.REST_Classes.WrestlingResults;


public class WrestlingAdapter extends RecyclerView.Adapter<WrestlingAdapter.WrestlingViewHolder> implements Filterable {
    private Context mCtx;
    private List<WrestlingResults> resultsList;
    private List<WrestlingResults> resultsListFull;



    public WrestlingAdapter(Context mCtx, List<WrestlingResults> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
        resultsListFull=new ArrayList<>(resultsList);

    }

    public WrestlingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.wrestling_result_card, null);
        return new WrestlingViewHolder(view);
    }

    public void onBindViewHolder(WrestlingViewHolder holder, int position) {
        //getting the product of the specified position
        WrestlingResults results = resultsList.get(position);

        //binding the data with the viewholder views


        holder.tvDate.setText(String.valueOf(results.getDate()));
        holder.tvWeight.setText(String.valueOf(results.getWeightCategory()));
        holder.tvUni1.setText(String.valueOf(results.getUni1()));
        holder.tvUni2.setText(String.valueOf(results.getUni2()));
        holder.tvPlayer1.setText(String.valueOf(results.getUni1Player()));
        holder.tvPlayer2.setText(String.valueOf(results.getUni2Player()));
        holder.tvScore1.setText(String.valueOf(results.getUni1Score()));
        holder.tvScore2.setText(String.valueOf(results.getUni2Score()));
        holder.tvWinner.setText(String.valueOf(results.getWinner()+" won the match"));
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

    class WrestlingViewHolder extends RecyclerView.ViewHolder {

        private TextView tvUni1,tvUni2,tvPlayer1,tvPlayer2,tvScore1,tvScore2,tvWeight,tvDate,tvWinner,tvMatchNo;
        ImageView imgLogo1,imgLogo2;

        public WrestlingViewHolder(View itemView) {
            super(itemView);

            tvDate=itemView.findViewById(R.id.date);
            tvWeight=itemView.findViewById(R.id.weight);
            tvUni1=itemView.findViewById(R.id.uni1);
            tvUni2=itemView.findViewById(R.id.uni2);
            tvPlayer1=itemView.findViewById(R.id.playerName1);
            tvPlayer2=itemView.findViewById(R.id.playerName2);
            tvScore1=itemView.findViewById(R.id.score1);
            tvScore2=itemView.findViewById(R.id.score2);
            tvWinner=itemView.findViewById(R.id.winner);
            tvMatchNo=itemView.findViewById(R.id.matchNo);
            imgLogo1=itemView.findViewById(R.id.logo1);
            imgLogo2=itemView.findViewById(R.id.logo2);

        }
    }
    private Filter resultFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<WrestlingResults> filteredList=new ArrayList<>();

            if(constraint==null || constraint.length()==0){
                filteredList.addAll(resultsListFull);
            }
            else{
                String filterPattern=constraint.toString().toLowerCase().trim();

                for(WrestlingResults item:resultsListFull){
                    if(item.getUni1().toLowerCase().contains(filterPattern)||item.getUni2().toLowerCase().contains(filterPattern)||item.getDate().toLowerCase().contains(filterPattern)) {
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


