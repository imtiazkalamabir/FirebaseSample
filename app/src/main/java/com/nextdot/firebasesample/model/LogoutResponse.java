package com.nextdot.firebasesample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by abir on 29/10/2017.
 */

public class LogoutResponse {

    @SerializedName("msg")
    @Expose
    String msg;

    public String getMsg() {
        return msg;
    }
}
