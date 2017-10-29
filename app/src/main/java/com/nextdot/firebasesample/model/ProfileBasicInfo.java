package com.nextdot.firebasesample.model;

/**
 * Created by abir on 28/10/2017.
 */

import com.google.gson.annotations.SerializedName;

public class ProfileBasicInfo{

    @SerializedName("msg")
    private String msg;

    @SerializedName("user")
    private User user;

    @SerializedName("userProfile")
    private UserProfile userProfile;

    @SerializedName("token")
    private String token;

    public void setMsg(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    public void setUserProfile(UserProfile userProfile){
        this.userProfile = userProfile;
    }

    public UserProfile getUserProfile(){
        return userProfile;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getToken(){
        return token;
    }

    @Override
    public String toString(){
        return
                "ProfileBasicInfo{" +
                        "msg = '" + msg + '\'' +
                        ",user = '" + user + '\'' +
                        ",userProfile = '" + userProfile + '\'' +
                        ",token = '" + token + '\'' +
                        "}";
    }
}
