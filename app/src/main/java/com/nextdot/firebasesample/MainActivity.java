package com.nextdot.firebasesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;



public class MainActivity extends AppCompatActivity {

    Button buttonBadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBadge = (Button) findViewById(R.id.button_badge);

        buttonBadge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String refreshedToken = FirebaseInstanceId.getInstance().getToken();

//Displaying token on logcat

                Log.d("TOKEN", "REFRESHED TOKEN:"+refreshedToken);


            }
        });

    }
}
