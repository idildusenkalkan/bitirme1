package com.example.omer.onlineint.view;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.omer.onlineint.Model.ClassicResult;
import com.example.omer.onlineint.Model.ResultResponse;
import com.example.omer.onlineint.Model.TestResult;
import com.example.omer.onlineint.R;
import com.example.omer.onlineint.Retrofit.ApiClient;
import com.example.omer.onlineint.Retrofit.RestInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CandidateInfo extends AppCompatActivity {
    ResultResponse resultResponse = new ResultResponse();
    String test = "test", classic = "classic", cheated = "cheated", notCheated = "notCheated";
    String examType;
    int examtypee;
    EditText name, surname, tc, mail, phoneNumber;
    Button send;
    String ClassicAnswerHolder;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_info);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        tc = findViewById(R.id.tc);
        mail = findViewById(R.id.mail);
        phoneNumber = findViewById(R.id.phoneNumber);
        send = findViewById(R.id.send);

        builder = new AlertDialog.Builder(CandidateInfo.this);

    }

    public void SendAnswer(View view) {

          if (isOnline()) {


        Intent mIntent = getIntent();

        examType = mIntent.getStringExtra("examtype");

        if (name.getText().toString().isEmpty() || surname.getText().toString().isEmpty() ||
                tc.getText().toString().isEmpty() || mail.getText().toString().isEmpty() ||
                phoneNumber.getText().toString().isEmpty()) {
            Toast.makeText(this, "tüm alanlar dolu olmalıdır", Toast.LENGTH_SHORT).show();
        } else {
            if (examType.equals("test")) {
                TestResult testResult = new TestResult();


                testResult.setTrueAnswer(String.valueOf(getIntent().getIntExtra("trueAns", 0)));
                testResult.setFalseAnswer(String.valueOf(getIntent().getIntExtra("falseAns", 0)));
                testResult.setUnAnswered(String.valueOf(getIntent().getIntExtra("unAnswered", 0)));
                testResult.setCheatControl(getIntent().getStringExtra("cheat"));
                testResult.setEmail(mail.getText().toString());
                testResult.setName(name.getText().toString());
                testResult.setSurname(surname.getText().toString());
                testResult.setPhoneNumber(phoneNumber.getText().toString());

                testResult.setExamId(0); //BURASIII
                testResult.setUserId(0);  //BURASIII


                RestInterface restInterface = ApiClient.getClient().create(RestInterface.class);
                Call<ResultResponse> call = restInterface.sendTR(testResult);
                call.enqueue(new Callback<ResultResponse>() {
                    @Override
                    public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                        if(response.isSuccessful()){
                        resultResponse.setResponse(response.body().getResponse());
                        resultResponse.setResultResponseId(response.body().getResultResponseId());
                        control();}
                        else  TryAgain();
                    }

                    @Override
                    public void onFailure(Call<ResultResponse> call, Throwable t) {
                        resultResponse.setResponse("fail");

                        control();
                    }
                });


            }

            if (examType.equals("classic")) {
                ClassicAnswerHolder = getIntent().getStringExtra("answers");

                ClassicResult classicResult = new ClassicResult();

                classicResult.setAnswer(getIntent().getStringExtra("answer"));
                classicResult.setCheatControl(getIntent().getStringExtra("cheat"));
                classicResult.setEmail(mail.getText().toString());
                classicResult.setName(name.getText().toString());
                classicResult.setSurname(surname.getText().toString());
                classicResult.setPhoneNumber(phoneNumber.getText().toString());


                RestInterface restInterface = ApiClient.getClient().create(RestInterface.class);
                Call<ResultResponse> call = restInterface.sendCR(classicResult);
                call.enqueue(new Callback<ResultResponse>() {
                    @Override
                    public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                        if(response.isSuccessful()){
                        resultResponse.setResponse(response.body().getResponse());
                        resultResponse.setResultResponseId(response.body().getResultResponseId());
                        control();}
                        else TryAgain();
                    }

                    @Override
                    public void onFailure(Call<ResultResponse> call, Throwable t) {
                        resultResponse.setResponse("fail");

                        control();
                    }
                });

            }
        }
    }
         else{
              Toast.makeText(CandidateInfo.this,"Hata oluştu,kısa süre içinde tekrar denenecek",Toast.LENGTH_SHORT).show();

              Handler handler= new Handler();
              handler.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                   send.performClick();                }



              },1000);

          }

        }


        public void control () {
            if (resultResponse.getResponse().equals("OK")) {
                startActivity(new Intent(this, finishpage.class));

            } else {

                Toast.makeText(this, "HATA oluştu...Tekrar deneniyor...", Toast.LENGTH_LONG).show();


            }
        }


        @Override
        public void onBackPressed () {


            builder.setTitle("Results has not saved  yet!");
            builder.setMessage("Press OK  to leave without saving");
            builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    startActivity(new Intent(CandidateInfo.this, starterPage.class));
                    finish();
                }
            });
            builder.show();


        }


    protected boolean isOnline () {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

    public void TryAgain(){

        Toast.makeText(CandidateInfo.this,"İnternet bağlantısı yok. Kısa süre içinde tekrar denenecek", Toast.LENGTH_LONG).show();

        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                send.performClick();
            }
        },1000);





    }


}
