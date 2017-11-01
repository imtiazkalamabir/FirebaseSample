package com.nextdot.firebasesample;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.nextdot.firebasesample.Utils.Constants;
import com.nextdot.firebasesample.Utils.PreferenceManager;

import com.nextdot.firebasesample.model.NotificationList;
import com.nextdot.firebasesample.model.NotificationsItem;
import com.nextdot.firebasesample.network.ApiClient;
import com.nextdot.firebasesample.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationListActivity extends AppCompatActivity {

    List<NotificationsItem> notificationItemList;

    RecyclerView recyclerView;
    NotificationAdapter recyclerAdapter;

    PreferenceManager preferenceManager;

    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notificationItemList = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
//        recyclerAdapter = new NotificationAdapter(getApplicationContext(),notificationItemList);
//        recyclerView.setAdapter(recyclerAdapter);

        preferenceManager = PreferenceManager.getInstance(NotificationListActivity.this);

        userId = Integer.toString(preferenceManager.getProfileInfo().getUser().getId());




//      Calling the Notification API to fetch the notification list

        String url = ApiClient.BASE_URL+Constants.notification_list+userId;

        Log.d("URL_NOTIFICATION", "NotificationListAPICall: "+url);

        NotificationListAPICall(url);



    }

    private void NotificationListAPICall(String url) {


        Log.d("NotCallAPI", "NotificationListAPICall: I AM HERE");

        ApiService apiInterface = ApiClient.getApiInterface();
        Call<NotificationList> call = apiInterface.getNotification(url);

        call.enqueue(new Callback<NotificationList>() {
            @Override
            public void onResponse(Call<NotificationList> call, Response<NotificationList> response) {
                notificationItemList = response.body().getNotifications();

                Log.d("NotificationList","Response = "+notificationItemList.get(0));

                recyclerAdapter = new NotificationAdapter(getApplicationContext(),notificationItemList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NotificationList> call, Throwable t) {
                Log.d("FailedMsg","Response = "+t.toString());
            }
        });
    }
}
