package com.example.omer.onlineint.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultResponse {

    @SerializedName("resultResponseId")
    @Expose
    private int resultResponseId;

    @SerializedName("response")
    @Expose
   private String response;

    public String getResponse() {
        return response;
    }

    public int getResultResponseId() {
        return resultResponseId;
    }

    public void setResultResponseId(int resultResponseId) {
        this.resultResponseId = resultResponseId;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public ResultResponse() {
    }
}
