package com.nextdot.firebasesample;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nextdot.firebasesample.model.NotificationItem;

import java.util.List;

/**
 * Created by imtiazkalamabir on 10/30/17.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder>{

    Context context;
    List<NotificationItem> notificationItemList;

    public NotificationAdapter(Context context, List<NotificationItem> notificationItemList) {
        this.context = context;
        this.notificationItemList = notificationItemList;
    }

    @Override
    public NotificationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_notification,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotificationAdapter.MyViewHolder holder, int position) {

        holder.tvTitle.setText(notificationItemList.get(position).getTitle());
        holder.tvSubtitle.setText(notificationItemList.get(position).getSubtitle());
        holder.tvTime.setText(notificationItemList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return notificationItemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvSubtitle, tvTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView)itemView.findViewById(R.id.tv_title);
            tvSubtitle = (TextView)itemView.findViewById(R.id.tv_subtitle);
            tvTime = (TextView)itemView.findViewById(R.id.tv_time);
        }
    }



}
