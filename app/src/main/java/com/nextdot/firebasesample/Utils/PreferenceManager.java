package com.nextdot.firebasesample.Utils;

/**
 * Created by abir on 28/10/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.nextdot.firebasesample.model.ProfileBasicInfo;

//import com.Orkodoctor.nextdot.Network.RetrofitModel.DoctorProfileDetails.DoctorProfileDetailsInfo;
//import com.nextdot.firebasesample.model.DistrictList;
//import com.nextdot.firebasesample.model.AppintmentDurations;

/**
 * Created by ASUS on 16-Aug-17.
 */

public class PreferenceManager {


    private static PreferenceManager preferenceManager;

    public static final String FCM_TOKEN = "FCMToken";
    public String appointmentId = "appointmentID";
    public String userTocken = "userToken";
    public String userProfile = "userProfile";
    public String userProfileDetailsinfo = "com.arkodoctor.nextdot.RetrofitModel.DoctorProfileDetails_info.profileDetails";
    public String othersuserProfileDetailsinfo = "com.arkodoctor.nextdot.RetrofitModel.othersuserProfileDetails.othersuserProfileDetailsinfo";
    public String districtListcount = "com.arkodoctor.nextdot.RetrofitModel.DistrictListCount";
    public String districtListTag = "com.arkodoctor.nextdot.RetrofitModel.DistrictList";
    public String loginChecker = "com.arkodoctor.nextdot.loginChecker";
    public String isFbLoginPhoneSubmitted = "com.arkodoctor.nextdot.isFbLoginPhoneSubmitted";
    public String fbloginChecker = "fb.com.arkodoctor.nextdot.loginChecker";
    public String appointmentdurations = "com.arkodoctor.nextdot.appointmentDuration";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences nSharedPreferences;


    private PreferenceManager(Context context) {
        mSharedPreferences = context.getSharedPreferences(Constants.APPLICATION_ID, Context.MODE_PRIVATE);
    }


    public static synchronized PreferenceManager getInstance(Context context) {

        if (preferenceManager == null) {
            preferenceManager = new PreferenceManager(context);
        }

        return preferenceManager;
    }

    public boolean setProfileInfo(ProfileBasicInfo user){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        editor.putString(userProfile, json);

        return editor.commit();
    }


    public boolean setFCMToken(String token){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(FCM_TOKEN, token);

        return editor.commit();

    }

    public String getFcmToken(){

        String fcmToken = mSharedPreferences.getString(FCM_TOKEN,"");
        return fcmToken;
    }


    public ProfileBasicInfo getProfileInfo(){
        Gson gson = new Gson();
        String json = mSharedPreferences.getString(userProfile, "");
        return gson.fromJson(json, ProfileBasicInfo.class);
    }

//    public DoctorProfileDetailsInfo getProfileDetailsInfo(){
//        Gson gson = new Gson();
//        String json = mSharedPreferences.getString(userProfileDetailsinfo, "");
//        return gson.fromJson(json, DoctorProfileDetailsInfo.class);
//    }
//    public DoctorProfileDetailsInfo getOthersProfileDetailsInfo(){
//        Gson gson = new Gson();
//        String json = mSharedPreferences.getString(othersuserProfileDetailsinfo, "");
//        return gson.fromJson(json, DoctorProfileDetailsInfo.class);
//    }
//
//    public boolean setProfileDetailsInfo(DoctorProfileDetailsInfo DoctorProfileDetailsinformation){
//        SharedPreferences.Editor editor = mSharedPreferences.edit();
//        Gson gson = new Gson();
//        String json = gson.toJson(DoctorProfileDetailsinformation);
//        editor.putString(userProfileDetailsinfo, json);
//
//        return editor.commit();
//    }
//
//    public boolean setOthersProfileDetailsInfo(DoctorProfileDetailsInfo DoctorProfileDetailsinformation){
//        SharedPreferences.Editor editor = mSharedPreferences.edit();
//        Gson gson = new Gson();
//        String json = gson.toJson(DoctorProfileDetailsinformation);
//        editor.putString(othersuserProfileDetailsinfo, json);
//
//        return editor.commit();
//    }
//
//    public boolean setDistrictList(DistrictList districtList){
//        SharedPreferences.Editor editor = mSharedPreferences.edit();
//        Gson gson = new Gson();
//        String json = gson.toJson(districtList);
//        editor.putString(districtListTag, json);
//
//        return editor.commit();
//    }
//    public DistrictList getDistrictList(){
//        Gson gson = new Gson();
//        String json = mSharedPreferences.getString(districtListTag, "");
//        return gson.fromJson(json, DistrictList.class);
//    }
//
//    public void setFbLogedIn( boolean value){
//
//        SharedPreferences.Editor editor = mSharedPreferences.edit();
//        editor.putBoolean(fbloginChecker,value);
//        editor.apply();
//        editor.commit();
//    }
//
//    public void setIsFbLoginPhoneSubmitted (boolean value){
//
//        SharedPreferences.Editor editor = mSharedPreferences.edit();
//        editor.putBoolean(isFbLoginPhoneSubmitted,value);
//        editor.apply();
//        editor.commit();
//    }
//
//
//    public boolean getIsFbLoginPhoneSubmitted(){
//        return mSharedPreferences.getBoolean(isFbLoginPhoneSubmitted,false);
//    }
//    public boolean getFbLogedIn(){
//        return mSharedPreferences.getBoolean(fbloginChecker,false);
//    }

    public void clearAllData(){

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.apply();
        editor.commit();
    }

    public void setLogedIn( boolean value){

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(loginChecker, true);
        editor.apply();
        editor.commit();
    }

    public boolean getLogedIn(){
        return mSharedPreferences.getBoolean(loginChecker,false);
    }

//    public void setAppinmentDurations(AppintmentDurations value){
//
//        SharedPreferences.Editor editor = mSharedPreferences.edit();
//        Gson gson=new Gson();
//        String json=gson.toJson(value);
//        editor.putString(appointmentdurations,json);
//        editor.apply();
//        editor.commit();
//    }
//
//    public AppintmentDurations getAppinmentDurations(){
//
//        Gson gson = new Gson();
//        String json = mSharedPreferences.getString(appointmentdurations, "");
//        return gson.fromJson(json,AppintmentDurations.class);
//    }
//
//    public void setPatientSpinnerArray(ArrayList<String> spinneritemList) {
//
//        SharedPreferences.Editor editor = mSharedPreferences.edit();
//        Gson gson = new Gson();
//
//        String json = gson.toJson(spinneritemList);
//
//        editor.putString(Constants.patientsAppintmentTimeList, json);
//        editor.commit();
//    }
//
//    public ArrayList<String> getPatientSpinnerArray() {
//        //String[] spinneritemList=mSharedPreferences.getString("").split(",");
//
//        Gson gson = new Gson();
//        String json = mSharedPreferences.getString(Constants.patientsAppintmentTimeList, null);
//        Type type = new TypeToken<ArrayList<String>>() {}.getType();
//        ArrayList<String> spinneritemList = gson.fromJson(json, type);
//        return spinneritemList;
//    }
//
//    public void setAppointmentTimeRangeArray(ArrayList<String> spinneritemList) {
//
//        SharedPreferences.Editor editor = mSharedPreferences.edit();
//        Gson gson = new Gson();
//
//        String json = gson.toJson(spinneritemList);
//
//        editor.putString(Constants.setAppointmentTimeList, json);
//        editor.commit();
//    }
//
//
//    public ArrayList<String> getAppointmentTimeRangeArray() {
//        //String[] spinneritemList=mSharedPreferences.getString("").split(",");
//
//        Gson gson = new Gson();
//        String json = mSharedPreferences.getString(Constants.setAppointmentTimeList, null);
//        Type type = new TypeToken<ArrayList<String>>() {}.getType();
//        ArrayList<String> spinneritemList = gson.fromJson(json, type);
//        return spinneritemList;
//    }

    public void setAppointmentID(String appointmentID) {

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(appointmentId, "");
        editor.apply();
        editor.commit();
    }


    public String getAppointmentID() {

        return mSharedPreferences.getString(appointmentId, "");
    }

}