package com.example.omer.onlineint.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Question implements Serializable {

    @SerializedName("questionId")
    @Expose
    private int questionId;

    @SerializedName("examId")
    @Expose
    private int examId;

    @SerializedName("classicExamId")
    @Expose
    private int classicExamId;

    @SerializedName("quest")
    @Expose
    private String quest;

    @SerializedName("choice1")
    @Expose
    private String choice1;

    @SerializedName("choice2")
    @Expose
    private String choice2;

    @SerializedName("choice3")
    @Expose
    private String choice3;

    @SerializedName("choice4")
    @Expose
    private String choice4;

    @SerializedName("examFormat")
    @Expose
    private String examFormat;

    @SerializedName("answer")
    @Expose
    private String answer;

    public int getClassicExamId() {
        return classicExamId;
    }

    public void setClassicExamId(int classicExamId) {
        this.classicExamId = classicExamId;
    }

    public Question(String questionText, String choice1, String choice2, String choice3, String choice4, String answer) {
    }


    public String getExamFormat() {
        return examFormat;
    }

    public void setExamFormat(String examFormat) {
        this.examFormat = examFormat;
    }

    public Question() {
    }


    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


}
