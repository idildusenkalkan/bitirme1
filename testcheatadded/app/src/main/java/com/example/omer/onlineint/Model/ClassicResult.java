package com.example.omer.onlineint.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClassicResult {

    @SerializedName("classicResultId")
    @Expose
    private int classicResultId;

    @SerializedName("userId")
    @Expose
    private int userId;

    @SerializedName("classicExamId")
    @Expose
    private int classicExamId;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("surname")
    @Expose
    private String surname;

    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("cheatControl")
    @Expose
    private String cheatControl;

    @SerializedName("answer")
    @Expose
    private String answer;

    public int getClassicResultId() {
        return classicResultId;
    }

    public void setClassicResultId(int classicResultId) {
        this.classicResultId = classicResultId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getClassicExamId() {
        return classicExamId;
    }

    public void setClassicExamId(int classicExamId) {
        this.classicExamId = classicExamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCheatControl() {
        return cheatControl;
    }

    public void setCheatControl(String cheatControl) {
        this.cheatControl = cheatControl;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
