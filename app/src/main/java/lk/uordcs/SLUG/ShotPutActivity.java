package lk.uordcs.SLUG;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOError;
import java.util.List;

import lk.uordcs.SLUG.Adapter_Classes.ThrowingAdapter;
import lk.uordcs.SLUG.REST_Classes.ThrowingResults;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShotPutActivity extends AppCompatActivity {

    public ThrowingAdapter adapter;
    private List<ThrowingResults> resultsList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shot_put);

        getSupportActionBar().setTitle("Shot Put");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //final ProgressBar progressBar = new ProgressBar(this);
       final ProgressBar progressBar = (ProgressBar) findViewById(R.id.prog);

        //progressDialog.setTitle("Loading");
        progressBar.setVisibility(View.VISIBLE);

        ApiInterface apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call call=apiInterface.getShotPutResults();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                try{
                    if(response.body()!=null){
                        progressBar.setVisibility(View.GONE);
                        resultsList=(List<ThrowingResults>)response.body();
                        adapter = new ThrowingAdapter(ShotPutActivity.this, resultsList);

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
               // progressDialog.dismiss();
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(),"No connection...",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);

        MenuItem searchItem=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
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
