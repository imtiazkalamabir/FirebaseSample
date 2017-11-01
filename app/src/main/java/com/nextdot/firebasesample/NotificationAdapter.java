package com.nextdot.firebasesample;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import de.hdodenhof.circleimageview.CircleImageView;

import com.bumptech.glide.Glide;

import com.nextdot.firebasesample.model.NotificationsItem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by imtiazkalamabir on 10/30/17.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder>{

    Context context;
    List<NotificationsItem> notificationItemList;

    public NotificationAdapter(Context context, List<NotificationsItem> notificationItemList) {
        this.context = context;
        this.notificationItemList = notificationItemList;
    }

    @Override
    public NotificationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_list_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotificationAdapter.MyViewHolder holder, int position) {

        holder.tvTitle.setText(notificationItemList.get(position).getTitle());
        holder.tvSubtitle.setText(notificationItemList.get(position).getSubtitle());

        String time = convertToAgoFormat(notificationItemList.get(position).getCreatedAt());

        Log.d("TimeCount", "onBindViewHolder: "+time);

        holder.tvTime.setText(time);

        Glide.with(context)
                .load(notificationItemList.get(position).getImageUrl()).into(holder.userImage);




    }

    private String convertToAgoFormat(String receivedTime) {

        Log.d("ReceivedTime", "convertToAgoFormat: "+receivedTime);

        String finalTime = "";

        try
        {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date past = format.parse(receivedTime);
            Date now = new Date();
            long seconds= TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime());
            long minutes=TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime());
            long hours=TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime());
            long days=TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime());
//
//          System.out.println(TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime()) + " milliseconds ago");
//          System.out.println(TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime()) + " minutes ago");
//          System.out.println(TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime()) + " hours ago");
//          System.out.println(TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime()) + " days ago");



            if(seconds<60)
            {
                finalTime = seconds+" seconds ago";
            }
            else if(minutes<60)
            {
                finalTime = minutes+" minutes ago";
            }
            else if(hours<24)
            {
                finalTime = hours+" hours ago";
            }
            else
            {
                finalTime = days+" days ago";
            }

            return finalTime;
        }
        catch (Exception j){
            j.printStackTrace();
        }


    return finalTime;



    }

    @Override
    public int getItemCount() {

        int a ;

        if(notificationItemList != null && !notificationItemList.isEmpty()) {

            a = notificationItemList.size();
        }
        else {

            a = 0;

        }

        return a;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvSubtitle, tvTime;
         CircleImageView userImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView)itemView.findViewById(R.id.tv_title);
            tvSubtitle = (TextView)itemView.findViewById(R.id.tv_subtitle);
            tvTime = (TextView)itemView.findViewById(R.id.tv_time);
            userImage = (CircleImageView) itemView.findViewById(R.id.user_image);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int pos = getAdapterPosition();

                    NotificationsItem item = notificationItemList.get(pos);

                    String id = String.valueOf(item.getId());

                    String type = item.getType();

                    //Start the specific activity

                    Intent intent;

                    if(type.equals("appointment")){

                       intent = new Intent(context, AppointmentDetailsActivity.class);
                       intent.putExtra("appointment_id", id);


                    }else{
                        intent = new Intent(context, MainActivity.class);   // Place the other activities here as per requirement by using else if
                        intent.putExtra("SOME_ID", id);
                    }

                    context.startActivity(intent);

                }
            });
        }
    }



}
