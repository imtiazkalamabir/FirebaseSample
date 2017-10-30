package com.nextdot.firebasesample.firebaseServices;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.nextdot.firebasesample.Utils.PreferenceManager;

/**
 * Created by imtiazkalamabir on 10/15/17.
 */

public class FireBaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";
    public static final String SENT_TOKEN_TO_SERVER = "sentTokenToServer";


    PreferenceManager preferenceManager = null;

//Not called generally

    @Override
    public void onTokenRefresh() {

        preferenceManager = PreferenceManager.getInstance(getApplicationContext());
//Getting registration token

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();


        try {

            preferenceManager.setFCMToken(refreshedToken);


//Displaying token on logcat

            Log.d(TAG, "REFRESHED TOKEN:" + refreshedToken);
            // pass along this data
            sendRegistrationToServer(refreshedToken);


        } catch (Exception e) {
            e.printStackTrace();
            // If an exception happens while fetching the new token or updating our registration data
            // on a third-party server, this ensures that we'll attempt the update at a later time.
//            sharedPreferences.edit().putBoolean(SENT_TOKEN_TO_SERVER, false).apply();

        }
    }

    private void sendRegistrationToServer(String token) {
        // send network request [will implement later]

        // if registration sent was successful, store a boolean that indicates whether the generated token has been sent to server
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        sharedPreferences.edit().putBoolean(SENT_TOKEN_TO_SERVER, true).apply();


    }
}