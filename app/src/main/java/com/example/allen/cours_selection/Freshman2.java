package com.example.allen.cours_selection;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Freshman2 extends AppCompatActivity implements View.OnClickListener{
    Button sub1;
    Button sub2;
    Button sub3;
    Button sub4;
    Button sub5;
    MaterialButton back;

    Course thecourse = new Course();
    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freshman2);
        sub1 = (Button)findViewById(R.id.btn1);
        sub2 = (Button)findViewById(R.id.btn2);
        sub3 = (Button)findViewById(R.id.btn3);
        sub4 = (Button)findViewById(R.id.btn4);
        sub5 = (Button)findViewById(R.id.btn5);
        back = (MaterialButton) findViewById(R.id.back);

        txt1 = (TextView)findViewById(R.id.msg);

        sub1.setOnClickListener(this);

        sub2.setOnClickListener(this);

        sub3.setOnClickListener(this);

        sub4.setOnClickListener(this);

        sub5.setOnClickListener(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Freshman2.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
    public void readCourselist(String coursecode) {
        InputStream is = getResources().openRawResource(R.raw.overall_ece_sheet);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is)
        );

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                //Log.d("Myactivity","Line: "+line);
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
                Intent courseinforintent = new Intent(this, Courseinfor.class);
                readCourselist("CAS MA 124");
                courseinforintent.putExtra("MyClass", thecourse);
                startActivity(courseinforintent);
                break;
            }

            case R.id.btn2: {
                Intent courseinforintent = new Intent(this, Courseinfor.class);
                readCourselist("CAS PY 211");
                courseinforintent.putExtra("MyClass", thecourse);
                startActivity(courseinforintent);
                break;
            }
            case R.id.btn3: {
                Intent courseinforintent = new Intent(this, Courseinfor.class);
                readCourselist("ENG EK 131");
                courseinforintent.putExtra("MyClass", thecourse);
                startActivity(courseinforintent);
                break;
            }
            case R.id.btn4: {
                Intent courseinforintent = new Intent(this, Courseinfor.class);
                readCourselist("ENG EK 103");
                courseinforintent.putExtra("MyClass", thecourse);
                startActivity(courseinforintent);
                break;
            }
            case R.id.btn5: {
                Intent courseinforintent = new Intent(this, Courseinfor.class);
                readCourselist("CAS WR 150");
                courseinforintent.putExtra("MyClass", thecourse);
                startActivity(courseinforintent);
                break;
            }
            default: {
                break;
            }
        }
    }
}
