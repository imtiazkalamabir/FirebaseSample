package com.nextdot.firebasesample.model;

/**
 * Created by abir on 28/10/2017.
 */

import com.google.gson.annotations.SerializedName;

public class UserProfile{

    @SerializedName("allergies")
    private String allergies;

    @SerializedName("fees")
    private String fees;

    @SerializedName("gender")
    private String gender;

    @SerializedName("rating")
    private int rating;

    @SerializedName("bio")
    private String bio;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("promo_code")
    private int promoCode;

    @SerializedName("speciality")
    private String speciality;

    @SerializedName("doctor_id")
    private String doctorId;

    @SerializedName("work_experiences")
    private String workExperiences;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("id")
    private int id;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("profession")
    private String profession;

    @SerializedName("family_history")
    private String familyHistory;

    @SerializedName("address")
    private String address;

    @SerializedName("social")
    private String social;

    @SerializedName("doctor_promo_code")
    private String doctorPromoCode;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("featured_skill")
    private String featuredSkill;

    @SerializedName("user_id")
    private int userId;

    @SerializedName("dob")
    private String dob;

    @SerializedName("organization")
    private String organization;

    @SerializedName("main_problem")
    private String mainProblem;

    @SerializedName("district")
    private District district;

    @SerializedName("blood_group")
    private String bloodGroup;

    @SerializedName("doctor_recommendation")
    private String doctorRecommendation;

    @SerializedName("interests")
    private String interests;

    @SerializedName("fees_messaging")
    private String feesMessaging;

    @SerializedName("age")
    private int age;

    @SerializedName("upazilla")
    private Upazilla upazilla;

    @SerializedName("vaccination")
    private String vaccination;

    @SerializedName("surgery")
    private String surgery;

    public void setAllergies(String allergies){
        this.allergies = allergies;
    }

    public String getAllergies(){
        return allergies;
    }

    public void setFees(String fees){
        this.fees = fees;
    }

    public String getFees(){
        return fees;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public void setRating(int rating){
        this.rating = rating;
    }

    public int getRating(){
        return rating;
    }

    public void setBio(String bio){
        this.bio = bio;
    }

    public String getBio(){
        return bio;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setPromoCode(int promoCode){
        this.promoCode = promoCode;
    }

    public int getPromoCode(){
        return promoCode;
    }

    public void setSpeciality(String speciality){
        this.speciality = speciality;
    }

    public String getSpeciality(){
        return speciality;
    }

    public void setDoctorId(String doctorId){
        this.doctorId = doctorId;
    }

    public String getDoctorId(){
        return doctorId;
    }

    public void setWorkExperiences(String workExperiences){
        this.workExperiences = workExperiences;
    }

    public String getWorkExperiences(){
        return workExperiences;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setProfession(String profession){
        this.profession = profession;
    }

    public String getProfession(){
        return profession;
    }

    public void setFamilyHistory(String familyHistory){
        this.familyHistory = familyHistory;
    }

    public String getFamilyHistory(){
        return familyHistory;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setSocial(String social){
        this.social = social;
    }

    public String getSocial(){
        return social;
    }

    public void setDoctorPromoCode(String doctorPromoCode){
        this.doctorPromoCode = doctorPromoCode;
    }

    public String getDoctorPromoCode(){
        return doctorPromoCode;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setFeaturedSkill(String featuredSkill){
        this.featuredSkill = featuredSkill;
    }

    public String getFeaturedSkill(){
        return featuredSkill;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int getUserId(){
        return userId;
    }

    public void setDob(String dob){
        this.dob = dob;
    }

    public String getDob(){
        return dob;
    }

    public void setOrganization(String organization){
        this.organization = organization;
    }

    public String getOrganization(){
        return organization;
    }

    public void setMainProblem(String mainProblem){
        this.mainProblem = mainProblem;
    }

    public String getMainProblem(){
        return mainProblem;
    }

    public void setDistrict(District district){
        this.district = district;
    }

    public District getDistrict(){
        return district;
    }

    public void setBloodGroup(String bloodGroup){
        this.bloodGroup = bloodGroup;
    }

    public String getBloodGroup(){
        return bloodGroup;
    }

    public void setDoctorRecommendation(String doctorRecommendation){
        this.doctorRecommendation = doctorRecommendation;
    }

    public String getDoctorRecommendation(){
        return doctorRecommendation;
    }

    public void setInterests(String interests){
        this.interests = interests;
    }

    public String getInterests(){
        return interests;
    }

    public void setFeesMessaging(String feesMessaging){
        this.feesMessaging = feesMessaging;
    }

    public String getFeesMessaging(){
        return feesMessaging;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setUpazilla(Upazilla upazilla){
        this.upazilla = upazilla;
    }

    public Upazilla getUpazilla(){
        return upazilla;
    }

    public void setVaccination(String vaccination){
        this.vaccination = vaccination;
    }

    public String getVaccination(){
        return vaccination;
    }

    public void setSurgery(String surgery){
        this.surgery = surgery;
    }

    public String getSurgery(){
        return surgery;
    }

    @Override
    public String toString(){
        return
                "UserProfile{" +
                        "allergies = '" + allergies + '\'' +
                        ",fees = '" + fees + '\'' +
                        ",gender = '" + gender + '\'' +
                        ",rating = '" + rating + '\'' +
                        ",bio = '" + bio + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",promo_code = '" + promoCode + '\'' +
                        ",speciality = '" + speciality + '\'' +
                        ",doctor_id = '" + doctorId + '\'' +
                        ",work_experiences = '" + workExperiences + '\'' +
                        ",updated_at = '" + updatedAt + '\'' +
                        ",id = '" + id + '\'' +
                        ",first_name = '" + firstName + '\'' +
                        ",profession = '" + profession + '\'' +
                        ",family_history = '" + familyHistory + '\'' +
                        ",address = '" + address + '\'' +
                        ",social = '" + social + '\'' +
                        ",doctor_promo_code = '" + doctorPromoCode + '\'' +
                        ",last_name = '" + lastName + '\'' +
                        ",featured_skill = '" + featuredSkill + '\'' +
                        ",user_id = '" + userId + '\'' +
                        ",dob = '" + dob + '\'' +
                        ",organization = '" + organization + '\'' +
                        ",main_problem = '" + mainProblem + '\'' +
                        ",district = '" + district + '\'' +
                        ",blood_group = '" + bloodGroup + '\'' +
                        ",doctor_recommendation = '" + doctorRecommendation + '\'' +
                        ",interests = '" + interests + '\'' +
                        ",fees_messaging = '" + feesMessaging + '\'' +
                        ",age = '" + age + '\'' +
                        ",upazilla = '" + upazilla + '\'' +
                        ",vaccination = '" + vaccination + '\'' +
                        ",surgery = '" + surgery + '\'' +
                        "}";
    }
}
