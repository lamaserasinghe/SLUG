package lk.uordcs.SLUG.Adapter_Classes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lk.uordcs.SLUG.R;
import lk.uordcs.SLUG.REST_Classes.SwimmingIndividualResults;


public class SwimmingIndividualAdapter extends RecyclerView.Adapter<SwimmingIndividualAdapter.SwimmingIndividualViewHolder> {
    private Context mCtx;
    private List<SwimmingIndividualResults> resultsList;

    public SwimmingIndividualAdapter(Context mCtx, List<SwimmingIndividualResults> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
    }

    public SwimmingIndividualViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.swimming_result_card, null);
        return new SwimmingIndividualViewHolder(view);
    }

    public void onBindViewHolder(SwimmingIndividualViewHolder holder, int position) {
        //getting the product of the specified position
        SwimmingIndividualResults results = resultsList.get(position);

        //binding the data with the viewholder views

        holder.tvMatchNo.setText(String.valueOf(results.getMatchNo()));
        holder.tvDate.setText(String.valueOf(results.getDate()));
        if(String.valueOf(results.getGender()).equals("M")){
            holder.tvGender.setText("Men's");
        }
        else if(String.valueOf(results.getGender()).equals("W")){
            holder.tvGender.setText("Women's");
        }
        holder.tvRound.setText(String.valueOf(results.getRound()));
        holder.tvUni.setText(String.valueOf(results.getUni()));
        holder.tvEvent.setText(String.valueOf(results.getEvent()));
        holder.tvFinishTime.setText(String.valueOf(results.getFinishTime()));
        holder.tvRank.setText(String.valueOf(results.getRank()));
        holder.tvPlayerName.setText(String.valueOf(results.getPlayerName()));
        holder.tvMatchNo.setText(String.valueOf(results.getMatchNo()));


    }

    public int getItemCount() {
        return resultsList.size();
    }

    class SwimmingIndividualViewHolder extends RecyclerView.ViewHolder {

        private TextView tvMatchNo,tvDate,tvUni,tvGender,tvEvent,tvPlayerName,tvRound,tvRank,tvFinishTime;

        public SwimmingIndividualViewHolder(View itemView) {
            super(itemView);

            tvMatchNo=itemView.findViewById(R.id.matchNo);
            tvDate=itemView.findViewById(R.id.date);
            tvEvent=itemView.findViewById(R.id.event);
            tvUni=itemView.findViewById(R.id.uni);
            tvRank=itemView.findViewById(R.id.rank);
            tvGender=itemView.findViewById(R.id.gender);
            tvRound=itemView.findViewById(R.id.round);
            tvPlayerName=itemView.findViewById(R.id.playerName);
            tvFinishTime=itemView.findViewById(R.id.finishTime);
            tvMatchNo=itemView.findViewById(R.id.matchNo);



        }
    }
}


