package com.example.omer.onlineint.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ClassicExam {

    @SerializedName("classicExamId")
    @Expose
    private int classicExamId;

    @SerializedName("duration")
    @Expose
    private String duration;

    @SerializedName("number")
    @Expose
    private String number;

    @SerializedName("format")
    @Expose
    private String format;

    @SerializedName("examStartingDate")
    @Expose
    private Date examStartingDate;

    @SerializedName("examFinishingDate")
    @Expose
    private Date examFinishingDate;


    public int getClassicExamId() {
        return classicExamId;
    }

    public void setClassicExamId(int classicExamId) {
        this.classicExamId = classicExamId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Date getExamStartingDate() {
        return examStartingDate;
    }

    public void setExamStartingDate(Date examStartingDate) {
        this.examStartingDate = examStartingDate;
    }

    public Date getExamFinishingDate() {
        return examFinishingDate;
    }

    public void setExamFinishingDate(Date examFinishingDate) {
        this.examFinishingDate = examFinishingDate;
    }
}
