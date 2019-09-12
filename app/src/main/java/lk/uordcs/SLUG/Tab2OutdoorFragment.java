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


public class Tab2OutdoorFragment extends Fragment {

    private static final String TAG="Tab1fragment";
    CardView trackandfield,baseball,cricket,elle,football,hockey,roadrace,rowing,rugbyfootball;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab2_outdoor_fragment,container,false);


        baseball=(CardView)view.findViewById(R.id.Baseball);
        baseball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),BaseballActivity.class);
                startActivity(intent);
            }
        });

        hockey=(CardView)view.findViewById(R.id.Hockey);
        hockey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),HockeyActivity.class);
                startActivity(intent);
            }
        });

        elle=(CardView)view.findViewById(R.id.Elle);
        elle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ElleActivity.class);
                startActivity(intent);
            }
        });

        rowing=(CardView)view.findViewById(R.id.Rowing);
        rowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),RowingActivity.class);
                startActivity(intent);
            }
        });


        trackandfield=(CardView)view.findViewById(R.id.trackAndFeild);
        trackandfield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TrackAndFieldActivity.class);
                startActivity(intent);            }
        });

        roadrace=(CardView)view.findViewById(R.id.Roadrace);
        roadrace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),RoadRaceActivity.class);
                startActivity(intent);            }
        });

        cricket=(CardView)view.findViewById(R.id.Cricket);
        cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),CricketActivity.class);
                startActivity(intent);            }
        });

        football=(CardView)view.findViewById(R.id.Football);
        football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),FootballActivity.class);
                startActivity(intent);
            }
        });

        rugbyfootball=(CardView)view.findViewById(R.id.Rugby);
        rugbyfootball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),RugbyFootballActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

