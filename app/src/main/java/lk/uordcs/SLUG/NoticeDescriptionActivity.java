package lk.uordcs.SLUG;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;



public class NoticeDescriptionActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_description);
        ViewNotice();
    }

    public void ViewNotice(){

        textView=(TextView)findViewById(R.id.tvNotice);
        //Get the bundle
        Bundle bundle = getIntent().getExtras();

        //Extract the data…
        String notice= bundle.getString("notice");
        textView.setText(notice);
        textView.setTextSize(20);

    }

}
