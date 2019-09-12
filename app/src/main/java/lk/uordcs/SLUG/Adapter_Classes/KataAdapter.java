package lk.uordcs.SLUG.Adapter_Classes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lk.uordcs.SLUG.R;
import lk.uordcs.SLUG.REST_Classes.HockeyResults;
import lk.uordcs.SLUG.REST_Classes.KataResults;

public class KataAdapter extends RecyclerView.Adapter<KataAdapter.KataViewHolder> implements Filterable {
    private Context mCtx;
    private List<KataResults> resultsList;
    private List<KataResults> resultsListFull;


    public KataAdapter(Context mCtx, List<KataResults> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
        resultsListFull=new ArrayList<>(resultsList);

    }

    public KataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.kata_result_card, null);
        return new KataViewHolder(view);
    }

    public void onBindViewHolder(KataViewHolder holder, int position) {
        //getting the product of the specified position
        KataResults results = resultsList.get(position);

        //binding the data with the viewholder views

        if(String.valueOf(results.getGender()).equals("M")){
            holder.tvGender.setText("Men's");
        }
        else if(String.valueOf(results.getGender()).equals("W")){
            holder.tvGender.setText("Women's");
        }

        holder.tvDate.setText(String.valueOf(results.getDate()));
        holder.tvRound.setText(String.valueOf(results.getRound()));
        holder.tvWeight.setText(String.valueOf(results.getWeightCategory()));
        if(String.valueOf(results.getTeamIndividual()).equals("I")){
            holder.tvType.setText("Individual");
        }
        else if(String.valueOf(results.getTeamIndividual()).equals("T")){
            holder.tvType.setText("Team");
        }


        holder.tvUni.setText(String.valueOf(results.getUni()));
        holder.tvPName.setText(String.valueOf(results.getPlayerName()));
        holder.tvPoints.setText(String.valueOf(results.getPoints()));
        holder.tvMatchNo.setText(String.valueOf(results.getMatchNo()));

    }

    public int getItemCount() {
        return resultsList.size();
    }


    @Override
    public Filter getFilter() {
        return resultFilter;
    }


    class KataViewHolder extends RecyclerView.ViewHolder {

        private TextView tvRound,tvGender,tvUni,tvWeight,tvType,tvPName,tvPoints,tvDate,tvMatchNo;

        public KataViewHolder(View itemView) {
            super(itemView);

            tvDate=itemView.findViewById(R.id.date);
            tvRound=itemView.findViewById(R.id.round);
            tvGender=itemView.findViewById(R.id.gender);
            tvUni=itemView.findViewById(R.id.uni);
            tvWeight=itemView.findViewById(R.id.weight);
            tvType=itemView.findViewById(R.id.type);
            tvPName=itemView.findViewById(R.id.playerName);
            tvPoints=itemView.findViewById(R.id.points);
            tvMatchNo=itemView.findViewById(R.id.matchNo);
        }
    }

    private Filter resultFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<KataResults> filteredList=new ArrayList<>();

            if(constraint==null || constraint.length()==0){
                filteredList.addAll(resultsListFull);
            }
            else{
                String filterPattern=constraint.toString().toLowerCase().trim();

                for(KataResults item:resultsListFull){
                    if(item.getUni().toLowerCase().contains(filterPattern)||item.getDate().toLowerCase().contains(filterPattern)||item.getRound().toLowerCase().contains(filterPattern)) {
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


