package com.nextdot.firebasesample.network;

import android.graphics.Movie;

import com.nextdot.firebasesample.Utils.Constants;
import com.nextdot.firebasesample.model.LogoutResponse;

import com.nextdot.firebasesample.model.NotificationList;
import com.nextdot.firebasesample.model.ProfileBasicInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by imtiazkalamabir on 10/26/17.
 */

public interface ApiService {

//
//    @POST
//    Call<List<Contact>> getContacts(@Url String url); //for calling dynamic url
//
//    @POST("contacts.php")
//    Call<List<Contact>> getContacts(); //for calling static url

    @POST(Constants.logIn)
    Call<ProfileBasicInfo> login(@Query("username") String username, @Query("password") String password,
                                 @Query("registration_token") String registrationToken,@Query("device_id") String deviceID) ;


    @POST(Constants.logout)
    Call<LogoutResponse> logout(@Query("username") String userID, @Query("device_id") String deviceID) ;

    @POST()
    Call<NotificationList> getNotification(@Url String url);

}
