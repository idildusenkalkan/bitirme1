package com.example.omer.onlineint.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class TestExam implements Serializable {

    @SerializedName("examId")
    @Expose
    private int examId;

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


    public TestExam() {
    }


    public TestExam(String duration, String number, String format, Date examStartingDate, Date examFinishingDate) {
        this.duration = duration;
        this.number = number;
        this.format = format;
        this.examStartingDate = examStartingDate;
        this.examFinishingDate = examFinishingDate;
    }

    public int getExamId() {
        return examId;
    }


    public void setExamId(int examId) {
        this.examId = examId;
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


    @Override
    public String toString(){
        return "TestExam{" +
                "examId=" + examId +
                ", starting date for exam='" + examStartingDate + '\'' +
                ", last day for exam=" + examFinishingDate +
                ", duration=" + duration +
                '}';
    }
}


