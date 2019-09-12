package lk.uordcs.SLUG;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOError;
import java.util.List;

import lk.uordcs.SLUG.Adapter_Classes.SparringAdapter;
import lk.uordcs.SLUG.REST_Classes.SparringResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SparringFragment extends Fragment {

    private static final String TAG="Sparringfragment";
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.sparring_poomsae_fragment,container,false);


        //getting the recyclerview from xml
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ApiInterface apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call call=apiInterface.getSparringResults();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                try{
                    if(response.body()!=null){
                        List<SparringResults> resultsList=(List<SparringResults>)response.body();
                        SparringAdapter adapter = new SparringAdapter(getActivity(), resultsList);

                        recyclerView.setAdapter(adapter);
                    }
                    else{
                        Toast.makeText(getActivity(),"No results found...",Toast.LENGTH_SHORT).show();
                    }
                }
                catch (IOError error){
                    error.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getActivity(),"No connection...",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}


