package com.example.yusuf.idonate;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by YUSUF on 11/28/2016.
 */
public class DonorAdapter extends BaseAdapter{
    private Activity activity;
    private LayoutInflater inflater;
    private List<user> movieItems;


    public DonorAdapter(Activity activity, List<user> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }

    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);



        ImageView thumbNail = (ImageView) convertView.findViewById(R.id.imf);
        TextView lname = (TextView) convertView.findViewById(R.id.dname);
        TextView lemail = (TextView) convertView.findViewById(R.id.demail);
        TextView lcity = (TextView) convertView.findViewById(R.id.dcity);
        TextView lblood = (TextView) convertView.findViewById(R.id.dbloodType);
        TextView lphone = (TextView) convertView.findViewById(R.id.dmob);






        user m = movieItems.get(position);


        lname.setText(m.getName());


        lemail.setText(m.getEmail());


        lcity.setText(m.getCity()+"-"+m.getPin());

        lblood.setText(m.getBlood());

        lphone.setText(""+m.getPhone());

        if(m.isMale()){
            thumbNail.setImageResource(R.drawable.m);
        }else{
            thumbNail.setImageResource(R.drawable.f);
        }

        return convertView;
    }
}
