package com.example.omer.onlineint.view;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.omer.onlineint.Model.ParentClass;
import com.example.omer.onlineint.Model.Question;
import com.example.omer.onlineint.R;

import java.io.Serializable;
import java.util.ArrayList;

public class ExamInfo extends AppCompatActivity {

    private int duration,questionNumber;
    private String examType;
    private TextView l_format, l_number, l_duration;
    ArrayList<Question> question=new ArrayList<>();
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_info);

        l_duration =  (TextView) findViewById(R.id.duration);
        l_number   = findViewById(R.id.questionNumber);
        l_format   =  findViewById(R.id.format);
        builder = new AlertDialog.Builder(ExamInfo.this);
        Intent mIntent = getIntent();
        String numberOfQuestion = null;
        String format =null;

        try {
            String key = "exam";

         //   Bundle b = mIntent.getBundleExtra("b");
        //    question=(ArrayList<Question>) b.getSerializable(key);
            question = (ArrayList<Question>)  mIntent.getSerializableExtra("exam");
            duration= mIntent.getIntExtra("examduration",0);
            questionNumber= mIntent.getIntExtra("questionnumber",0);
            examType= mIntent.getStringExtra("examtype");

             numberOfQuestion = String.valueOf(questionNumber);
             format = question.get(0).getExamFormat();
        }

        catch (Exception e){
            e.getCause().printStackTrace();
        }

      /*  question=(ArrayList<Question>) mIntent.getSerializableExtra("exam");
        duration= mIntent.getIntExtra("examduration",0);
        questionNumber= mIntent.getIntExtra("questionnumber",0);
        examType= mIntent.getStringExtra("examtype");

        String numberOfQuestion = String.valueOf(questionNumber);
        String format = question.get(0).getExamFormat();
        */


            l_duration.setText(String.valueOf(duration));
            l_number.setText(numberOfQuestion);
            l_format.setText(format);


    }

    public void start(View view) {
        Bundle b=new Bundle();
        Intent i;
        if(question.get(0).getExamFormat().equals("test"))
        {i=new Intent(this,testexampage.class);
            i.putExtra("examduration",duration);
            i.putExtra("questionnumber",questionNumber);
            i.putExtra("testexam", (Serializable) question);
            startActivity(i);}

        if(question.get(0).getExamFormat().equals("klasik"))
        {i=new Intent(this,classicexampage.class);
            i.putExtra("examduration",duration);
            i.putExtra("questionnumber",questionNumber);
            i.putExtra("classicexam", (Serializable) question);
            startActivity(i);}


    }


    @Override
    public void onBackPressed() {

        builder.setTitle("Attention!");
        builder.setMessage("Press OK togo Starter Page");
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                startActivity(new Intent(ExamInfo.this, starterPage.class));
                finish();
            }
        });
        builder.show();


    }











}