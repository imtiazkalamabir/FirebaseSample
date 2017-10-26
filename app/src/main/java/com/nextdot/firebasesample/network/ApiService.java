package com.nextdot.firebasesample.network;

import com.nextdot.firebasesample.model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by imtiazkalamabir on 10/26/17.
 */

public interface ApiService {


    @POST
    Call<List<Contact>> getContacts(@Url String url); //for calling dynamic url

    @POST("contacts.php")
    Call<List<Contact>> getContacts(); //for calling static url






}
