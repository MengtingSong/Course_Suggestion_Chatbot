package com.example.allen.cours_selection;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Senior2 extends AppCompatActivity implements View.OnClickListener{
    MaterialButton sub1;
    MaterialButton sub2;
    MaterialButton sub3;
    MaterialButton sub4;


    TextView txt1;

    Course thecourse = new Course();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior2);

        sub1 = (MaterialButton)findViewById(R.id.btn1);
        sub2 = (MaterialButton)findViewById(R.id.btn2);
        sub3 = (MaterialButton)findViewById(R.id.btn3);
        sub4 = (MaterialButton)findViewById(R.id.btn4);


        txt1 = (TextView)findViewById(R.id.msg);

        sub1.setOnClickListener(this);

        sub2.setOnClickListener(this);

        sub3.setOnClickListener(this);

        sub4.setOnClickListener(this);


    }
    public void readCourselist(String coursecode)
    {
        InputStream is = getResources().openRawResource(R.raw.overall_ece_sheet);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is)
        );

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                Log.d("Myactivity","Line: "+line);
                //split by ','
                String[] token = line.split((","));
                //read the data
                if (token[0].equals(coursecode)) {
                    //Course onecourse = new Course();
                    thecourse.setCode(token[0]);
                    thecourse.setName(token[1]);
                    //Log.d("Myactivity", onecourse.getName());
                    thecourse.setType(token[2]);
                    thecourse.setYear(token[3]);
                    thecourse.setPrerequisite(token[4]);
                    thecourse.setCredit(token[5]);
                    thecourse.setFuture(token[6]);
                    thecourse.setSubject_speci(token[7]);
                    thecourse.setDescription(token[8]);
                    Log.d("Myactivity", "here!!!!!!!!!!!!!!!!!!!!!");
                    Log.d("Myactivity", thecourse.getYear());
                    break;
                }
            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }

    }
    @Override
    public void onClick(View v) {


        //The switch statements grab the id values of the button pressed and calculates the tip accordingly
        switch (v.getId()) {
            case R.id.btn1: {
                Intent courseelectiveintent = new Intent(this, engelective.class);
                startActivity(courseelectiveintent);
                break;
            }

            case R.id.btn2: {
                Intent courseelectiveintent = new Intent(this, engelective.class);
                startActivity(courseelectiveintent);
                break;
            }
            case R.id.btn3: {
                Intent courseinforintent = new Intent(this, Courseinfor.class);
                readCourselist("CAS MA 123");
                courseinforintent.putExtra("MyClass", thecourse);
                startActivity(courseinforintent);
                break;
            }
            case R.id.btn4: {
                Intent generalelective = new Intent(this, generalelective.class);
                startActivity(generalelective);
                break;
            }
            default: {
                break;
            }
        }
    }
}
