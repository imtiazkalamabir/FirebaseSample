package com.nextdot.firebasesample.network;

/**
 * Created by abir on 29/10/2017.
 */
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by ASUS on 20-Aug-17.
 */

public class Connectivity {
    public static Connectivity connectivity;
    Context context;

    public Connectivity(Context context) {
        this.context=context;
    }

    public static synchronized Connectivity getInstance(Context context) {

        if (connectivity == null) {
            connectivity = new Connectivity(context);
        }

        return connectivity;
    }

    public boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo() ;

        if(networkInfo != null){
            return true;
        }
        return false;
    }
}
