package lk.uordcs.SLUG;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    CardView Schedule;
    CardView Rank;
    CardView Accommodation;
    CardView LiveStream;
    CardView notice;
    CardView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score=(CardView)findViewById(R.id.Score);
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScoreActivity();
            }
        });

        Schedule = (CardView) findViewById(R.id.EventSchedule);
        Schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openScheduleActivity();
            }
        });

        Accommodation=(CardView) findViewById(R.id.Accommodation);
        Accommodation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 openAccommodationActivity();

            }
        });

        Rank=(CardView) findViewById(R.id.UniversityRanking);
        Rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRankActivity();
            }
        });

        notice=(CardView)findViewById(R.id.Notices);
        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNoticeActivity();
            }
        });

        LiveStream=(CardView)findViewById(R.id.LiveStream);
        LiveStream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,YouTubeActivity.class);
                startActivity(intent);
            }
        });

    }

    public void openAccommodationActivity(){
        Intent intent=new Intent(MainActivity.this,Accomadation.class);
        startActivity(intent);

    }

    public void openScheduleActivity () {
        Intent intent = new Intent(MainActivity.this, EventScheduleActivity.class);
        startActivity(intent);
    }
    public void openRankActivity(){
        Intent intent=new Intent(MainActivity.this, PointsActivity.class);
        startActivity(intent);
    }

    public void openScoreActivity(){
        Intent intent=new Intent(MainActivity.this,ScoresTabActivity.class);
        startActivity(intent);
    }

    public  void openNoticeActivity(){
        Intent intent=new Intent(MainActivity.this,Notices.class);
        startActivity(intent);
    }



}



