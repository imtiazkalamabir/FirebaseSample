package com.nextdot.firebasesample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AppointmentDetailsActivity extends AppCompatActivity {

    TextView tv_app_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_details);

        tv_app_details = (TextView) findViewById(R.id.appointment_id);


        String appointmentID = new Intent().getStringExtra("appointment_id");

        tv_app_details.setText(appointmentID);

        Toast.makeText(this, "YAHOOO..got ID: "+appointmentID, Toast.LENGTH_SHORT).show();


    }
}
