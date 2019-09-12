package lk.uordcs.SLUG;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class EventResultsActivity extends AppCompatActivity {
    CardView basketball,badminton,baseball,trackandfield,volleyball,netball,ttennis,roadrace,cricket,football;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_results);

        getSupportActionBar().setTitle("Sports");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        volleyball=(CardView)findViewById(R.id.volleyball);
        volleyball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventResultsActivity.this,VolleyballActivity.class);
                startActivity(intent);
            }
        });



        badminton=(CardView)findViewById(R.id.Badminton);
        badminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventResultsActivity.this,BadmintonActivity.class);
                startActivity(intent);            }
        });

        baseball=(CardView)findViewById(R.id.Baseball);
        baseball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventResultsActivity.this,BaseballActivity.class);
                startActivity(intent);            }
        });

        basketball=(CardView)findViewById(R.id.Basketball);
        basketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventResultsActivity.this,BasketballActivity.class);
                startActivity(intent);            }
        });

        netball=(CardView)findViewById(R.id.Netball);
        netball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventResultsActivity.this,NetballActivity.class);
                startActivity(intent);
            }
        });

        trackandfield=(CardView)findViewById(R.id.trackAndFeild);
        trackandfield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventResultsActivity.this,TrackAndFieldActivity.class);
                startActivity(intent);            }
        });

        ttennis=(CardView)findViewById(R.id.tabletennis);
        ttennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventResultsActivity.this,TTennisActivity.class);
                startActivity(intent);            }
        });

        roadrace=(CardView)findViewById(R.id.Roadrace);
        roadrace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventResultsActivity.this,RoadRaceActivity.class);
                startActivity(intent);            }
        });

        cricket=(CardView)findViewById(R.id.Cricket);
        cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventResultsActivity.this,CricketActivity.class);
                startActivity(intent);            }
        });

        football=(CardView)findViewById(R.id.Football);
        football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventResultsActivity.this,FootballActivity.class);
                startActivity(intent);
            }
        });

    }


}

