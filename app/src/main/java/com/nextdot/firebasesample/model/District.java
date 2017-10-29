package com.nextdot.firebasesample.model;

/**
 * Created by abir on 28/10/2017.
 */

import com.google.gson.annotations.SerializedName;

public class District{

    @SerializedName("name")
    private String name;

    @SerializedName("division_id")
    private int divisionId;

    @SerializedName("id")
    private int id;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setDivisionId(int divisionId){
        this.divisionId = divisionId;
    }

    public int getDivisionId(){
        return divisionId;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString(){
        return
                "District{" +
                        "name = '" + name + '\'' +
                        ",division_id = '" + divisionId + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }
}
