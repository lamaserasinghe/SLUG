package lk.uordcs.SLUG;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import lk.uordcs.SLUG.Adapter_Classes.VideoAdapter;
import lk.uordcs.SLUG.REST_Classes.VideoDetails;

public class YouTubeActivity extends AppCompatActivity {

    ArrayList<VideoDetails> videoDetailsArrayList;
    ListView listview;
    String API_KEY="AIzaSyBVc5iSk5poLA1Xumc1SoIOitWXyMAMjwM";

    VideoAdapter myCustomAdapter;
    String url="https://www.googleapis.com/youtube/v3/search?part=snippet&channelId=UCBON5yY9wOQUGM-TepfwQug&key=AIzaSyBVc5iSk5poLA1Xumc1SoIOitWXyMAMjwM";
    // String VIDEO_ID="Hu9dqfvJ8pI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube);

        listview=(ListView)findViewById(R.id.listView);
        videoDetailsArrayList=new ArrayList<>();

        myCustomAdapter=new VideoAdapter(YouTubeActivity.this,videoDetailsArrayList);

        displayVideo();


        //
    }

    private void displayVideo() {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try{
                    JSONObject jsonObject=new JSONObject(response);

                    //JSONParser jsonParser = new JSONParser();
                    //JSONObject object = jsonParser.getJSONFromUrl(url);
                    //String content=object.getString("json key");

                    JSONArray jsonArray=jsonObject.getJSONArray("items");

                    for(int i=1;i<jsonArray.length();i++){
                        JSONObject jsonObject1=jsonArray.getJSONObject(i);
                        JSONObject jsonObjectid=jsonObject1.getJSONObject("id");
                        JSONObject jsonObjectsnippet=jsonObject1.getJSONObject("snippet");
                        JSONObject jsonObjectdefault=jsonObjectsnippet.getJSONObject("thumbnails").getJSONObject("medium");

                        String videoid=jsonObjectid.getString("videoId");

                        VideoDetails vd=new VideoDetails();
                        vd.setVideoId(videoid);
                        vd.setTitle(jsonObjectsnippet.getString("title"));
                        vd.setDescription(jsonObjectsnippet.getString("description"));
                        vd.setUrl(jsonObjectdefault.getString("url"));

                        videoDetailsArrayList.add(vd);
                        myCustomAdapter.notifyDataSetChanged();

                    }
                    listview.setAdapter(myCustomAdapter);
                    myCustomAdapter.notifyDataSetChanged();


                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
        );

        requestQueue.add(stringRequest);



    }


}
