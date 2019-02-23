package com.example.omer.onlineint.Retrofit;


import com.example.omer.onlineint.Model.ClassicExam;
import com.example.omer.onlineint.Model.ClassicResult;
import com.example.omer.onlineint.Model.Question;
import com.example.omer.onlineint.Model.ResultResponse;
import com.example.omer.onlineint.Model.State;
import com.example.omer.onlineint.Model.TestExam;
import com.example.omer.onlineint.Model.TestResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestInterface {

//  sınav var mı kontrolü    field YERİNE query OLABİLİR
    @GET("checkexam")
    Call<State> CheckExam(@Query("userId") int id, @Query("userPassword") String password);

    //yazılı sınav indirmek için request at
    @FormUrlEncoded
    @POST("downloadclassicexam")
    Call<ArrayList<Question>> DlCExam(@Field("examId") int examId);

    //test sınav indirmek için request at
    @FormUrlEncoded
    @POST("downloadtestexam")
    Call<ArrayList<Question>> DlTExam(@Field("examId") int examId);

   // @FormUrlEncoded
    @POST("classicresult")
    Call<ResultResponse> sendCR(@Body ClassicResult classicResult);

   // @FormUrlEncoded
    @POST("testresult")
    Call<ResultResponse> sendTR(@Body TestResult testResult);


}
