package com.nextdot.firebasesample.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abir on 28/10/2017.
 */

public class ApiClient {

    public static final String BASE_URL = "https://someurl.com/";
    private static Retrofit retrofit = null;

    public static Retrofit getApiClient(){

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
