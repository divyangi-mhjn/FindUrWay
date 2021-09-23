package com.hp.major.FindUrWay;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.List;


/**
 * Created by HP on 06-04-2018.
 */

public class MetroAdapter extends RecyclerView.Adapter<MetroAdapter.MyViewHolder>  {

    private Context mContext;
    private List<Metro> metroList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;
        RelativeLayout relativelayout;



        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);

            relativelayout =(RelativeLayout) itemView.findViewById(R.id.rl);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

        }


    }



    public MetroAdapter(Context mContext, List<Metro> metroList) {
        this.mContext = mContext;
        this.metroList = metroList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card1, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Metro metro = metroList.get(position);
        holder.title.setText(metro.getName());
        Glide.with(mContext).load(metro.getThumbnail()).into(holder.thumbnail);
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                metro.getName();

                switch (metro.getName()){
                    case "ROUTE":
                    {
                        Intent intent=new Intent(mContext,MetroRouteActivity.class);
                        mContext.startActivity(intent);
                        break;
                    }

                    case "FARE":
                    {
                        Intent intent=new Intent(mContext,MetroFareActivity.class);
                        mContext.startActivity(intent);
                        break;
                    }
                    case "DIRECTIONS":
                    {
                        Intent intent=new Intent(mContext,GateActivity.class);


                        mContext.startActivity(intent);
                        break;
                    }

                    case "RECHARGE" :
                    {
                        Intent intent=new Intent(mContext,RechargeActivity.class);
                        mContext.startActivity(intent);
                        break;
                    }
                    case "MAP" :
                    {
                        Intent intent=new Intent(mContext,MetroMapActivity.class);
                        mContext.startActivity(intent);
                        break;
                    }
                    case "UPCOMING" :
                    {
                        Intent intent=new Intent(mContext,UpcomingActivity.class);
                        mContext.startActivity(intent);
                        break;
                    }


                }


            }
        });



        // loading metro cover using Glide library



    }

    /**
     * Showing popup menu when tapping on 3 dots
     */



    @Override
    public int getItemCount() {
        return metroList.size();
    }
}
