package lk.uordcs.SLUG;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOError;
import java.util.List;

import lk.uordcs.SLUG.Adapter_Classes.EventAdapter;
import lk.uordcs.SLUG.Adapter_Classes.PointsAdapter;
import lk.uordcs.SLUG.REST_Classes.EventSchedule;
import lk.uordcs.SLUG.REST_Classes.Points;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EventScheduleActivity extends AppCompatActivity {

    public EventAdapter adapter;
    private List<EventSchedule> resultsList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_schedule);

        getSupportActionBar().setTitle("Event Schedule");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.show();

    ApiInterface apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
    Call call=apiInterface.getEventSchedule();
        call.enqueue(new Callback() {
        @Override
        public void onResponse(Call call, Response response) {
            try{
                if(response.body()!=null){
                    progressDialog.dismiss();
                    resultsList=(List<EventSchedule>)response.body();
                    adapter = new EventAdapter(EventScheduleActivity.this,resultsList);
                    recyclerView.setAdapter(adapter);
                }
                else{
                    Toast.makeText(getApplicationContext(),"No results found...",Toast.LENGTH_LONG).show();
                }
            }
            catch (IOError error){
                error.printStackTrace();
            }
        }

        @Override
        public void onFailure(Call call, Throwable t) {
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(),"No internet connection...",Toast.LENGTH_SHORT).show();
        }
    });
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);

        MenuItem searchItem=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }

}
