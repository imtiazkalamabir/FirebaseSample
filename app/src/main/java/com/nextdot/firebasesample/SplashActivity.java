package com.nextdot.firebasesample;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.nextdot.firebasesample.Utils.PreferenceManager;

public class SplashActivity extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    PreferenceManager preferenceManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusBar();
        setContentView(R.layout.activity_splash);

        preferenceManager = PreferenceManager.getInstance(SplashActivity.this);
        /*try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
        } catch (NoSuchAlgorithmException e) {

        }*/


        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Log.e("LoginMessage", preferenceManager.getLogedIn() + " message");

                if (preferenceManager.getLogedIn()) {

                    if(preferenceManager.getProfileInfo().getUser().getPhone()!=null){

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        Log.e("LoginMessage", preferenceManager.getLogedIn() + " message");

                        finish();

                    }else {

                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));

                        Log.e("LoginMessage", preferenceManager.getLogedIn() + " message");

                        finish();

                    }

                }

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);







    }

    private void hideStatusBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
