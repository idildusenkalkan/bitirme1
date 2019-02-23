package com.example.omer.onlineint.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class State {

    @SerializedName("numberOfQuestion")
    @Expose
    private int numberOfQuestion;

    @SerializedName("classicExamId")
    @Expose
    private int classicExamId;


    @SerializedName("stateId")
    @Expose
    private int stateId;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("examId")
    @Expose
    private int examId;

    @SerializedName("examType")
    @Expose
    private String examType;

    @SerializedName("time")
    @Expose
    private String time;





    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public State() {
    }

    public State(String state, String examId, String examType, String time) {
        this.state = state;

//      !! kontrol et !!
//        this.examId = examId;
        this.examType = examType;
        this.time = time;
    }

    public State(State state) {

    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

//    !! kontrol et !!
//    public String getExamId() {
//        return examId;
//    }
//
//    public void setExamId(String examId) {
//        this.examId = examId;
//    }


    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public void setNumberOfQuestion(int numberOfQuestion) {
        this.numberOfQuestion = numberOfQuestion;
    }

    public int getClassicExamId() {
        return classicExamId;
    }

    public void setClassicExamId(int classicExamId) {
        this.classicExamId = classicExamId;
    }
}
