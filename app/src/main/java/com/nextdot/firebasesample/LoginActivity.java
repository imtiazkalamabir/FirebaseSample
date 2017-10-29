package com.nextdot.firebasesample;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.iid.FirebaseInstanceId;
import com.nextdot.firebasesample.Utils.PreferenceManager;
import com.nextdot.firebasesample.model.ProfileBasicInfo;
import com.nextdot.firebasesample.network.ApiClient;
import com.nextdot.firebasesample.network.ApiService;
import com.nextdot.firebasesample.network.Connectivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    PreferenceManager preferenceManager;

    EditText userName, password;

    Button loginBtn;

    ProgressDialog pd_one;

    String usernameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        preferenceManager = PreferenceManager.getInstance(LoginActivity.this);
        pd_one = new ProgressDialog(this);

        userName = (EditText) findViewById(R.id.input_username);
        password = (EditText) findViewById(R.id.input_password);
        loginBtn = (Button) findViewById(R.id.btn_login);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                collectInfo();


            }
        });


    }

    private void collectInfo() {
        usernameText = userName.getText().toString();
        passwordText = password.getText().toString();

        String device_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);

        if (preferenceManager.getFcmToken() == null) {

            String refreshedToken = FirebaseInstanceId.getInstance().getToken();


            try {

                preferenceManager.setFCMToken(refreshedToken);


//Displaying token on logcat

                Log.d("LoginToken", "REFRESHED TOKEN:" + refreshedToken);


            } catch (Exception e) {
                e.printStackTrace();


                // If an exception happens while fetching the new token or updating our registration data
                // on a third-party server, this ensures that we'll attempt the update at a later time.


            }
        }


        String reg_token = preferenceManager.getFcmToken();

        //checking for play services on device asper firebase guidelines

        if (checkPlayServices()) {

            //Sending necessary data to the loginAPI

            loginAPI(usernameText, passwordText, reg_token, device_id);


        } else {


            showPlayServicesAlert();

        }
    }


    /**
     * Check the device to make sure it has the Google Play Services APK. If
     * it doesn't, display a dialog that allows users to download the APK from
     * the Google Play Store or enable it in the device's system settings.
     */
    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(this, resultCode, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE)
                        .show();
            } else {
                Log.i("MainActivity", "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }


    public void loginAPI(String username, String password, String reg_token, String deviceID) {

        if (!Connectivity.getInstance(this).isConnected()) {
            showAlert();
            return;
        }

        pd_one.setMessage("Logging in...");

        pd_one.show();
        ApiService apiInterface = ApiClient.getApiInterface();
        Call<ProfileBasicInfo> profileBasic = apiInterface.login(username,password,reg_token,deviceID);
        profileBasic.enqueue(new Callback<ProfileBasicInfo>() {
            @Override
            public void onResponse(Call<ProfileBasicInfo> call, Response<ProfileBasicInfo> response) {
                if (response.isSuccessful()) {
                    try {
                        String msg = response.body().getMsg();

                        if (msg.equals("success")) {

                            ProfileBasicInfo user = response.body();
                            Log.e("log_in", " " + user.getToken() + " id=" + user.getUserProfile().getUserId());

                            preferenceManager.setProfileInfo(user);


//                            String token = user.getToken();
//                            String id = user.getUserProfile().getUserId() + "";
//
//                            loadProfileInfoWithRetrofit(token, id);


                        } else {
                            userName.setError(msg);
                            pd_one.dismiss();
                            Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                    pd_one.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ProfileBasicInfo> call, Throwable t) {

                pd_one.dismiss();
                Toast.makeText(getApplicationContext(), "Please check your internet connection...", Toast.LENGTH_SHORT).show();
                Log.e("log_in", t + "");

            }
        });
    }


    public void showAlert() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Please Check internet connection");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }


    public void showPlayServicesAlert() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Please Google Play Services First");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

}
