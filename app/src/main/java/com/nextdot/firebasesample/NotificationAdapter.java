package com.nextdot.firebasesample;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import de.hdodenhof.circleimageview.CircleImageView;

import com.bumptech.glide.Glide;
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
        View view = LayoutInflater.from(context).inflate(R.layout.notification_list_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotificationAdapter.MyViewHolder holder, int position) {

        holder.tvTitle.setText(notificationItemList.get(position).getTitle());
        holder.tvSubtitle.setText(notificationItemList.get(position).getSubtitle());
        holder.tvTime.setText(notificationItemList.get(position).getTime());

        Glide.with(context)
                .load("http://via.placeholder.com/300.png").into(holder.userImage);




    }

    @Override
    public int getItemCount() {
        return notificationItemList.size();
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

                    NotificationItem item = notificationItemList.get(pos);

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
