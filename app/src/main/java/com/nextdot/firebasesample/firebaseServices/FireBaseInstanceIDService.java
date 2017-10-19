package com.nextdot.firebasesample.firebaseServices;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by imtiazkalamabir on 10/15/17.
 */

public class FireBaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";


    @Override
    public void onTokenRefresh() {
//Getting registration token

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

//Displaying token on logcat

        Log.d(TAG, "REFRESHED TOKEN:"+refreshedToken);

    }

}
