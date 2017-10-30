package com.nextdot.firebasesample.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abir on 28/10/2017.
 */

public class ApiClient {

    public static final String BASE_URL = "http://182.160.109.132/api/";
    private static Retrofit retrofit = null;

    public static Retrofit getApiClient(){

        if (retrofit == null) {

            return retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }

    public static ApiService getApiInterface(){
        return getApiClient().create(ApiService.class);
    }

}
