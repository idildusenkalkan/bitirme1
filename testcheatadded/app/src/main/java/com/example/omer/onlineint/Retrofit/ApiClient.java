package com.example.omer.onlineint.Retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

private static final String Base_URL="http://10.0.2.2:8181/";

    private static Retrofit retrofit=null;
    public static Retrofit getClient(){
        if(retrofit== null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient())
                    .build();
            return retrofit;
        }
        return retrofit;

    }//ApiClient.class
}
