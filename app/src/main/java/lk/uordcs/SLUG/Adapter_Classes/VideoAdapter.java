package lk.uordcs.SLUG.Adapter_Classes;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import lk.uordcs.SLUG.R;
import lk.uordcs.SLUG.REST_Classes.VideoDetails;
import lk.uordcs.SLUG.VideoPlayActivity;

public class VideoAdapter extends BaseAdapter {

    Activity activity;
    ArrayList<VideoDetails> videoDetailsArrayList;
    LayoutInflater inflater;

    public VideoAdapter(Activity activity, ArrayList<VideoDetails> videoDetailsArrayList){
        this.activity=activity;
        this.videoDetailsArrayList=videoDetailsArrayList;
    }

    @Override
    public Object getItem(int position) {
        return this.videoDetailsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long)position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater=this.activity.getLayoutInflater();
        }
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.custom_item, null);
        }
        ImageView imageView=(ImageView)convertView.findViewById(R.id.imgeview);
        TextView textView=(TextView)convertView.findViewById(R.id.mytitle);
        LinearLayout linearLayout=(LinearLayout)convertView.findViewById(R.id.root);
        final VideoDetails videoDetails =(VideoDetails)this.videoDetailsArrayList.get(position);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity, VideoPlayActivity.class);
                intent.putExtra("videoId",videoDetails.getVideoId());
                activity.startActivity(intent);
            }
        });


        Picasso.get().load(videoDetails.getUrl()).into(imageView);

        textView.setText(videoDetails.getTitle());

        return convertView;
    }

    @Override
    public int getCount() {
        return this.videoDetailsArrayList.size();
    }

}
