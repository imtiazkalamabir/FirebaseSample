package com.nextdot.firebasesample.model;

/**
 * Created by abir on 28/10/2017.
 */

import com.google.gson.annotations.SerializedName;

public class Upazilla{

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    @SerializedName("district_id")
    private int districtId;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setDistrictId(int districtId){
        this.districtId = districtId;
    }

    public int getDistrictId(){
        return districtId;
    }

    @Override
    public String toString(){
        return
                "Upazilla{" +
                        "name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        ",district_id = '" + districtId + '\'' +
                        "}";
    }
}