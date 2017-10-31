package com.nextdot.firebasesample;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.nextdot.firebasesample.Utils.PreferenceManager;
import com.nextdot.firebasesample.model.NotificationItem;
import com.nextdot.firebasesample.network.ApiClient;
import com.nextdot.firebasesample.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationListActivity extends AppCompatActivity {

    List<NotificationItem> notificationItemList;
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        preferenceManager = PreferenceManager.getInstance(NotificationListActivity.this);

        userId = Integer.toString(preferenceManager.getProfileInfo().getUser().getId());


//      Calling the Notification API to fetch the notification list

        NotificationListAPICall();



    }

    private void NotificationListAPICall() {
        ApiService apiInterface = ApiClient.getApiInterface();
        Call<List<NotificationItem>> call = apiInterface.getNotification(userId);

        call.enqueue(new Callback<List<NotificationItem>>() {
            @Override
            public void onResponse(Call<List<NotificationItem>> call, Response<List<NotificationItem>> response) {
                notificationItemList = response.body();
                Log.d("TAG","Response = "+notificationItemList);
                recyclerAdapter = new NotificationAdapter(getApplicationContext(),notificationItemList);
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<NotificationItem>> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
            }
        });
    }
}
