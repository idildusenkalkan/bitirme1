package com.example.omer.onlineint.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersExam {

    @SerializedName("usersExamId")
    @Expose
    private int usersExamId;

    private int userId;

    private int examId;
    private String userPassword;

    private String examType;


    public int getUsersExamId() {
        return usersExamId;
    }

    public void setUsersExamId(int usersExamId) {
        this.usersExamId = usersExamId;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public UsersExam() {
    }

    public UsersExam(int userId, int examId) {
        this.userId = userId;
        this.examId = examId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }
}
