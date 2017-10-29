package com.nextdot.firebasesample.network;

import com.nextdot.firebasesample.Utils.Constants;
import com.nextdot.firebasesample.model.LogoutResponse;
import com.nextdot.firebasesample.model.ProfileBasicInfo;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
                                 @Query("reg_token") String registrationToken,@Query("device_id") String deviceID) ;


    @POST(Constants.logout)
    Call<LogoutResponse> logout(@Query("user_id") String userID, @Query("device_id") String deviceID) ;

}
