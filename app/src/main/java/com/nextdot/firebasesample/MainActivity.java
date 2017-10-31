package com.nextdot.firebasesample;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nextdot.firebasesample.Utils.PreferenceManager;
import com.nextdot.firebasesample.model.LogoutResponse;
import com.nextdot.firebasesample.network.ApiClient;
import com.nextdot.firebasesample.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    PreferenceManager preferenceManager;

    String userId;

    Button btnLogout, btnNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferenceManager = PreferenceManager.getInstance(MainActivity.this);

        btnLogout = (Button) findViewById(R.id.button_logout);

        btnNotification = (Button) findViewById(R.id.button_Notification);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Signing out and clearing data

                Toast.makeText(MainActivity.this, "Signing out...", Toast.LENGTH_SHORT).show();


                userId = Integer.toString(preferenceManager.getProfileInfo().getUser().getId());
                String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                        Settings.Secure.ANDROID_ID);


                preferenceManager.clearAllData();
                Intent intent1=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent1);
                finish();


    // ------------  Starting the logoutAPI call from here, in order to remove the corresponding fcm registration token ------------ //


                //Enclose this with BroadcastReceiver in order to make the call successfully when interner is available

                logoutAPI(deviceID);


            }
        });

        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2=new Intent(MainActivity.this,NotificationListActivity.class);
                startActivity(intent2);


            }
        });

    }

    private void logoutAPI(String deviceID) {
        Toast.makeText(MainActivity.this, "Wow, Im here", Toast.LENGTH_SHORT).show();

        Log.d("USER_ID", userId);

        Log.d("DEVICE_ID", deviceID);

        ApiService apiInterface = ApiClient.getApiInterface();
        Call<LogoutResponse> logoutResponseCall = apiInterface.logout(userId,deviceID);
        logoutResponseCall.enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                if (response.isSuccessful()) {
                    try {
                        String msg = response.body().getMsg();

                        if (msg.equals("success")) {


                            Log.e("logoutAPICALL", " MESSAGE" + " id=" + msg);

                            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();




//                            String token = user.getToken();
//                            String id = user.getUserProfile().getUserId() + "";
//
//                            loadProfileInfoWithRetrofit(token, id);


                        } else {

                            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {


                // Do something to make a continuous call until success!

                Toast.makeText(getApplicationContext(), "Please check your internet connection...", Toast.LENGTH_SHORT).show();
                Log.e("log_in", t + "");

            }
        });
    }
}
