package lk.uordcs.SLUG;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab1IndoorFragment extends Fragment {

    private static final String TAG="Tab1IndoorFragment";
    CardView basketball,badminton,carrom,chess,karate,netball,swimming,taekwondo,ttennis,tennis,volleyball,weightLifting,wrestling;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab1_indoor_fragment,container,false);

        volleyball=(CardView)view.findViewById(R.id.volleyball);
        volleyball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openvolleyballscore();
            }
        });

        karate=(CardView)view.findViewById(R.id.Karate);
        karate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKaratescore();
            }
        });

        weightLifting=(CardView)view.findViewById(R.id.weightlifting);
        weightLifting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeightliftingscore();
            }
        });

        swimming=(CardView)view.findViewById(R.id.Swimming);
        swimming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSwimmingscore();
            }
        });

        taekwondo=(CardView)view.findViewById(R.id.taekwondo);
        taekwondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTaekwondoscore();
            }
        });


        tennis=(CardView)view.findViewById(R.id.tennis);
        tennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTennisscore();
            }
        });



        badminton=(CardView)view.findViewById(R.id.Badminton);
        badminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbadmintonscore();
            }
        });

        basketball=(CardView)view.findViewById(R.id.Basketball);
        basketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbasketballscore();
            }
        });

        netball=(CardView)view.findViewById(R.id.Netball);
        netball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opennetballscore();
            }
        });

        ttennis=(CardView)view.findViewById(R.id.tabletennis);
        ttennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openttennisscore();
            }
        });

        wrestling=(CardView)view.findViewById(R.id.wrestling);
        wrestling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openwrestlingscore();
            }
        });

        carrom=(CardView)view.findViewById(R.id.Carrom);
        carrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),CarromActivity.class);
                startActivity(intent);
            }
        });

        chess=(CardView)view.findViewById(R.id.Chess);
        chess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ChessActivity.class);
                startActivity(intent);
            }
        });



        return view;
    }

    private void openwrestlingscore() {
        Intent intent=new Intent(getActivity(),WrestlingActivity.class);
        startActivity(intent);
    }



    private void openWeightliftingscore() {

        Intent intent=new Intent(getActivity(),WeightliftingActivity.class);
        startActivity(intent);
    }

    private void openTennisscore() {
        Intent intent=new Intent(getActivity(),TennisActivity.class);
        startActivity(intent);
    }

    private void openTaekwondoscore() {
        Intent intent=new Intent(getActivity(),TaekwondoActivity.class);
        startActivity(intent);
    }

    private void openSwimmingscore() {
        Intent intent=new Intent(getActivity(),SwimmingActivity.class);
        startActivity(intent);
    }

    private void openKaratescore() {
        Intent intent=new Intent(getActivity(),KarateActivity.class);
        startActivity(intent);
    }


    private void openvolleyballscore() {
        Intent intent=new Intent(getActivity(),VolleyballActivity.class);
        startActivity(intent);
    }


    public void openbasketballscore(){
        Intent intent=new Intent(getActivity(),BasketballActivity.class);
        startActivity(intent);
    }

    public void openbadmintonscore(){
        Intent intent=new Intent(getActivity(),BadmintonActivity.class);
        startActivity(intent);
    }

    public void opennetballscore(){
        Intent intent=new Intent(getActivity(),NetballActivity.class);
        startActivity(intent);
    }

    private void openttennisscore() {
        Intent intent=new Intent(getActivity(),TTennisActivity.class);
        startActivity(intent);
    }

}
