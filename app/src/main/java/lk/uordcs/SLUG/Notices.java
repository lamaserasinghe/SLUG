package lk.uordcs.SLUG;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;



import lk.uordcs.SLUG.REST_Classes.Notice_;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Notices extends AppCompatActivity {

    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notices);

        getSupportActionBar().setTitle("Notices");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tableLayout=(TableLayout)findViewById(R.id.tableLayout);
        createColumns();
        fillData();

        //  etnic = (EditText) findViewById(R.id.etNIC);
        //  listView=(ListView)findViewById(R.id.listViewNotices);
        //   ViewNotices();
    }

    private void createColumns(){
        TableRow tableRow=new TableRow(this);
        tableRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        TextView textViewDate=new TextView(this);
        textViewDate.setText("Date");
        textViewDate.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewDate.setPadding(5,5,5,0);
        tableRow.addView(textViewDate);

        TextView textViewTime=new TextView(this);
        textViewTime.setText("Time");
        textViewTime.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewTime.setPadding(5,5,5,0);
        tableRow.addView(textViewTime);

        TextView textViewTitle=new TextView(this);
        textViewTitle.setText("Title");
        textViewTitle.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewTitle.setPadding(5,5,5,0);
        tableRow.addView(textViewTitle);

        TextView textViewNotice=new TextView(this);
        textViewNotice.setText(" ");
        textViewNotice.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewNotice.setPadding(5,5,5,0);
        tableRow.addView(textViewNotice);

        tableLayout.addView(tableRow,new TableLayout.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT
        ));
    }

    private void onResponseRestful(Call call,Response response){
        if(response.body()!=null){
            List<Notice_> notices=(List<Notice_>)response.body();

            for (final Notice_ notice_:notices){
                TableRow tableRow=new TableRow(this);
                tableRow.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.FILL_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT
                ));

                TextView textViewDate=new TextView(this);
                textViewDate.setText(String.valueOf(notice_.getDate()));
                textViewDate.setTypeface(Typeface.DEFAULT,Typeface.NORMAL);
                textViewDate.setPadding(5,30,5,0);
                tableRow.addView(textViewDate);

                TextView textViewTime=new TextView(this);
                textViewTime.setText(String.valueOf(notice_.getTime()));
                textViewTime.setTypeface(Typeface.DEFAULT,Typeface.NORMAL);
                textViewTime.setPadding(5,5,5,0);
                tableRow.addView(textViewTime);

                TextView textViewTitle=new TextView(this);
                textViewTitle.setText(String.valueOf(notice_.getTitle()));
                textViewTitle.setTypeface(Typeface.DEFAULT,Typeface.NORMAL);
                textViewTitle.setPadding(5,5,5,0);
                tableRow.addView(textViewTitle);

                TextView textViewNotice=new TextView(this);
                //textViewNotice.setText(String.valueOf(notice_.getNotice()));
                textViewNotice.isClickable();
                textViewNotice.setText("View");

                final String notice=String.valueOf(notice_.getNotice());

                textViewNotice.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                   /* Intent intent = new Intent(Notices.this, NoticeDescriptionActivity.class);
                    String notice=String.valueOf(notice_.getNotice());
//Create the bundle
                    Bundle bundle = new Bundle();
//Add your data to bundle
                    bundle.putString("notice", notice);
//Add the bundle to the intent
                   // intent.putExtras(bundle);
                    // startActivity(intent);
                */
                        openDialog(notice);


                    }
                });


                textViewNotice.setTextSize(20);
                textViewNotice.setTextColor(Color.parseColor("#FF0000"));
                textViewNotice.setTypeface(Typeface.DEFAULT,Typeface.NORMAL);
                textViewNotice.setPadding(5,5,5,0);
                tableRow.addView(textViewNotice);

                tableLayout.addView(tableRow,new TableLayout.LayoutParams(
                        TableRow.LayoutParams.FILL_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT
                ));
            }
        }
        else{
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            TextView alert=new TextView(this);
            alert.setText("No notices to view");
            alertDialog.setView(alert);
        }

    }

    public void openDialog(String message) {

        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        // Set Custom Title
        TextView title = new TextView(this);
        // Title Properties
        title.setText("Notice");
        title.setPadding(10, 10, 10, 10);   // Set Position
        title.setGravity(Gravity.CENTER);
        title.setTextColor(Color.BLACK);
        title.setTextSize(20);
        alertDialog.setCustomTitle(title);


        TextView msg = new TextView(this);
        // Message Properties
        msg.setText(message);
        msg.setGravity(Gravity.CENTER_HORIZONTAL);
        msg.setTextColor(Color.BLACK);
        alertDialog.setView(msg);

        // Set Button
        // you can more buttons
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Perform Action on Button
               // alertDialog.cancel();
            }
        });


        new Dialog(getApplicationContext());
        alertDialog.show();

        final Button okBT = alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
        LinearLayout.LayoutParams neutralBtnLP = (LinearLayout.LayoutParams) okBT.getLayoutParams();
        neutralBtnLP.gravity = Gravity.RIGHT;
        //okBT.setPadding(50, 10, 10, 10);   // Set Position
        okBT.setTextColor(Color.BLUE);
        okBT.setLayoutParams(neutralBtnLP);
    }

    public void fillData(){
        ApiInterface apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call call=apiInterface.getNotices();
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
