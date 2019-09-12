package lk.uordcs.SLUG;


import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import lk.uordcs.SLUG.REST_Classes.Points;
import lk.uordcs.SLUG.REST_Classes.Points;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Ranking extends AppCompatActivity {

    private TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        getSupportActionBar().setTitle("PointsActivity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tableLayout=(TableLayout)findViewById(R.id.tableLayout);
        createColumns();
        fillData();
    }

    private void createColumns(){
        TableRow tableRow=new TableRow(this);
        tableRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        TextView textViewUni=new TextView(this);
        textViewUni.setText("University");
        textViewUni.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewUni.setPadding(5,5,5,0);
        tableRow.addView(textViewUni);

        TextView textViewPoints=new TextView(this);
        textViewPoints.setText("PointsActivity");
        textViewPoints.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewPoints.setPadding(5,5,5,0);
        tableRow.addView(textViewPoints);

        tableLayout.addView(tableRow,new TableLayout.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT
        ));
    }

    private void onResponseRestful(Call call, Response response){
        if(response.body()!=null){
            List<Points> points=(List<Points>)response.body();

            for (final Points point:points){
                TableRow tableRow=new TableRow(this);
                tableRow.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.FILL_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT
                ));

                TextView textViewUni=new TextView(this);
                textViewUni.setText(String.valueOf(point.getUniName()));
                textViewUni.setTypeface(Typeface.DEFAULT,Typeface.NORMAL);
                textViewUni.setPadding(5,30,5,0);
                tableRow.addView(textViewUni);

                TextView textViewPoints=new TextView(this);
                textViewPoints.setText(String.valueOf(point.getTotal()));
                textViewPoints.setTypeface(Typeface.DEFAULT,Typeface.NORMAL);
                textViewPoints.setPadding(5,5,5,0);
                tableRow.addView(textViewPoints);

                tableLayout.addView(tableRow,new TableLayout.LayoutParams(
                        TableRow.LayoutParams.FILL_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT
                ));
            }
        }
        else{
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            TextView alert=new TextView(this);
            alert.setText("No results found");
            alertDialog.setView(alert);
        }

    }

    public void fillData(){
        ApiInterface apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call call=apiInterface.getPoints();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                onResponseRestful(call,response);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getApplicationContext(),"No internet connection",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
