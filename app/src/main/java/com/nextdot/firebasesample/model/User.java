package com.nextdot.firebasesample.model;

/**
 * Created by abir on 28/10/2017.
 */

import com.google.gson.annotations.SerializedName;

public class User{

    @SerializedName("password")
    private String password;

    @SerializedName("is_active")
    private int isActive;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("phone")
    private String phone;

    @SerializedName("web")
    private String web;

    @SerializedName("assistant_of")
    private String assistantOf;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id")
    private int id;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("created_by")
    private String createdBy;

    @SerializedName("email")
    private String email;

    @SerializedName("username")
    private String username;

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setIsActive(int isActive){
        this.isActive = isActive;
    }

    public int getIsActive(){
        return isActive;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }

    public void setWeb(String web){
        this.web = web;
    }

    public String getWeb(){
        return web;
    }

    public void setAssistantOf(String assistantOf){
        this.assistantOf = assistantOf;
    }

    public String getAssistantOf(){
        return assistantOf;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setAvatar(String avatar){
        this.avatar = avatar;
    }

    public String getAvatar(){
        return avatar;
    }

    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }

    public String getCreatedBy(){
        return createdBy;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    @Override
    public String toString(){
        return
                "User{" +
                        "password = '" + password + '\'' +
                        ",is_active = '" + isActive + '\'' +
                        ",updated_at = '" + updatedAt + '\'' +
                        ",phone = '" + phone + '\'' +
                        ",web = '" + web + '\'' +
                        ",assistant_of = '" + assistantOf + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",id = '" + id + '\'' +
                        ",avatar = '" + avatar + '\'' +
                        ",created_by = '" + createdBy + '\'' +
                        ",email = '" + email + '\'' +
                        ",username = '" + username + '\'' +
                        "}";
    }
}
