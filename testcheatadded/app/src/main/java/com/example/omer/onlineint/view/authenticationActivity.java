package com.example.omer.onlineint.view;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.omer.onlineint.Model.Question;
import com.example.omer.onlineint.Model.State;
import com.example.omer.onlineint.R;
import com.example.omer.onlineint.Retrofit.ApiClient;
import com.example.omer.onlineint.Retrofit.RestInterface;

import java.io.Serializable;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class authenticationActivity extends AppCompatActivity {

    ArrayList<Question> question=new ArrayList<>();
    EditText UserId, UserPassword;
    Button check;
    State  state=new State();
    String flag="empty",flag2="empty";
    Bundle b = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);


        UserId =  findViewById(R.id.edUserId);
        UserPassword = findViewById(R.id.edUserPassword);
        check=findViewById(R.id.check);
    }




    public void check(View view)  {
        RestInterface restInterface = ApiClient.getClient().create(RestInterface.class);

        if (!UserId.getText().toString().isEmpty() && !UserPassword.getText().toString().isEmpty()) {

            if (!isOnline()){

                Toast.makeText(authenticationActivity.this,"Internet Bağlantınızı kontrol edin",Toast.LENGTH_SHORT).show();
            }
            else {


                Call<State> call = restInterface.CheckExam(Integer.parseInt(UserId.getText().toString()), UserPassword.getText().toString());
                call.enqueue(new Callback<State>() {
                    @Override
                    public void onResponse(@NonNull Call<State> call, @NonNull Response<State> response) {


                        if(response.isSuccessful()){
                        state.setExamType(response.body().getExamType());
                        state.setState(response.body().getState());
                        state.setStateId(response.body().getStateId());
                        state.setTime(response.body().getTime());
                        state.setExamId(response.body().getExamId());
                        state.setNumberOfQuestion(response.body().getNumberOfQuestion());
                        state.setClassicExamId(response.body().getClassicExamId());
                        flag="success";}

                        else flag="fail";


                    }


                    @Override
                    public void onFailure(@NonNull Call<State> call, @NonNull Throwable t) {

                        flag = "fail";

                    }
                });

            if(flag.equals("success")){


               if(state.getState().equals("invalid")){
                   Toast.makeText(authenticationActivity.this,"Böyle bir sınav yok ",Toast.LENGTH_SHORT).show();


               }

               if(state.getState().equals("notyet")){
                   Toast.makeText(authenticationActivity.this,"Sınav süresi henüz gelmedi.Bildirilen süreden en fazla 2 dakika önce kontrol edin",Toast.LENGTH_SHORT).show();


               }

               if(state.getState().equals("passed")){
                   Toast.makeText(authenticationActivity.this,"Sınav süresi geçmiş",Toast.LENGTH_SHORT).show();


               }

                if (state.getState().equals("ready")) {

                    //  Call<ArrayList<Question>> call2 = restInterface.DlCExam(state.getClassicExamId());
                    //  Call<ArrayList<Question>> call3 = restInterface.DlTExam(state.getExamId());

                    if (state.getExamType().equals("klasik")) {

                        try{
                        int examId = state.getClassicExamId();
                        Call<ArrayList<Question>> call2 = restInterface.DlCExam(examId);

                        call2.enqueue(new Callback<ArrayList<Question>>() {
                            @Override
                            public void onResponse(@NonNull Call<ArrayList<Question>> call, @NonNull Response<ArrayList<Question>> response) {
                                if (response.isSuccessful()) {
                                    question = response.body();
                                    getIntentInfos();
                                    flag2 = "success";
                                } else flag2 = "fail";

                            }

                            @Override
                            public void onFailure(@NonNull Call<ArrayList<Question>> call, Throwable t) {
                                flag2 = "fail";
                            }
                        });

                    }
                    catch (Exception e)
                    {
                        e.getCause().printStackTrace();
                        Toast.makeText(this, "Hata oluştu.Lütfen tekrar deneyin", Toast.LENGTH_SHORT).show();

                    }
                }

                    if (state.getExamType().equals("test")) {

                        Intent i = new Intent(this, ExamInfo.class);


                        try{
                                  int eId = state.getExamId();

                                    Call<ArrayList<Question>> call3 = restInterface.DlTExam(eId);

                            call3.enqueue(new Callback<ArrayList<Question>>() {
                                @Override
                                public void onResponse(Call<ArrayList<Question>> call, Response<ArrayList<Question>> response) {

                                    if(response.isSuccessful()){
                                        question = response.body();
                                        //Bundle bundle = new Bundle();
                                        //     b.putSerializable("exam", question);
                                        getIntentInfos();
                                        flag2="success";}
                                    else flag2="fail";
                                }

                                @Override
                                public void onFailure(Call<ArrayList<Question>> call, Throwable t) {
                                    flag2="fail";
                                }
                            });
                        } catch (Exception e) {

                            // generic exception handling
                            e.getCause().printStackTrace();
                            Toast.makeText(this, "Hata oluştu.Lütfen tekrar deneyin", Toast.LENGTH_SHORT).show();

                        }

                    }

                    if(flag2=="fail")
                        Toast.makeText(this, "Hata oluştu.Lütfen tekrar deneyin", Toast.LENGTH_SHORT).show();


                }


            }

   else{//  SUCCESSS olmazsa
                Toast.makeText(this, "Sınav kontrolü yapılırken hata oluştu.Lütfen tekrar deneyin", Toast.LENGTH_SHORT).show();
            }
        }


    } else {
        Toast.makeText(this, "Tüm alanlar dolu olmalıdır", Toast.LENGTH_SHORT).show();

    }
    }

    //Check internet connection
    protected boolean isOnline () {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public void exit(View view) {
        finish();
        moveTaskToBack(true);

    }

    public void getIntentInfos(){

         Intent i = new Intent(this, ExamInfo.class);
         i.putExtra("exam", question);
        i.putExtra("examduration", Integer.parseInt(state.getTime()));
        i.putExtra("questionnumber", state.getNumberOfQuestion());
        i.putExtra("examtype", state.getExamType());
        i.putExtras(b);
        startActivity(i);    }




}
