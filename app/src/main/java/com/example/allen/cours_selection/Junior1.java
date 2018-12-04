package com.example.allen.cours_selection;

import android.content.Intent;
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

public class Junior1 extends AppCompatActivity implements View.OnClickListener{
    Button sub1;
    Button sub2;
    Button sub3;
    Button sub4;
    Button sub5;

    TextView txt1;

    Course thecourse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior1);

        sub1 = (Button)findViewById(R.id.btn1);
        sub2 = (Button)findViewById(R.id.btn2);
        sub3 = (Button)findViewById(R.id.btn3);
        sub4 = (Button)findViewById(R.id.btn4);
        sub5 = (Button)findViewById(R.id.btn5);

        txt1 = (TextView)findViewById(R.id.txt1);

        sub1.setOnClickListener(this);

        sub2.setOnClickListener(this);

        sub3.setOnClickListener(this);

        sub4.setOnClickListener(this);

        sub5.setOnClickListener(this);
    }
    public void readCourselist(String coursecode, Course onecourse)
    {
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
                    onecourse.setCode(token[0]);
                    onecourse.setName(token[1]);
                    //Log.d("Myactivity", onecourse.getName());
                    onecourse.setType(token[2]);
                    onecourse.setYear(token[3]);
                    onecourse.setPrerequisite(token[4]);
                    onecourse.setCredit(token[5]);
                    onecourse.setFuture(token[6]);
                    onecourse.setSubject_speci(token[7]);
                    onecourse.setDescription(token[8]);
                    Log.d("Myactivity", "here!!!!!!!!!!!!!!!!!!!!!");
                    Log.d("Myactivity", onecourse.getYear());
                    break;
                }
            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }

    }
    public void readCourselistbytype(String coursetype, Course onecourse)
    {
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
                if (token[7].equals(coursetype)) {
                    //Course onecourse = new Course();
                    onecourse.setCode(token[0]);
                    onecourse.setName(token[1]);
                    //Log.d("Myactivity", onecourse.getName());
                    onecourse.setType(token[2]);
                    onecourse.setYear(token[3]);
                    onecourse.setPrerequisite(token[4]);
                    onecourse.setCredit(token[5]);
                    onecourse.setFuture(token[6]);
                    onecourse.setSubject_speci(token[7]);
                    onecourse.setDescription(token[8]);
                    Log.d("Myactivity", "here!!!!!!!!!!!!!!!!!!!!!");
                    Log.d("Myactivity", onecourse.getYear());
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
                readCourselist("ENG EK 381", thecourse);
                courseinforintent.putExtra("MyClass", thecourse);
                startActivity(courseinforintent);
                break;
            }

            case R.id.btn2: {
                Intent courseinforintent = new Intent(this, Courseinfor.class);
                readCourselist("ENG EC 413", thecourse);
                courseinforintent.putExtra("MyClass", thecourse);
                startActivity(courseinforintent);
                break;
            }
            case R.id.btn3: {
                Intent courseinforintent = new Intent(this, Courseinfor.class);
                readCourselist("CAS MA 193", thecourse);
                courseinforintent.putExtra("MyClass", thecourse);
                startActivity(courseinforintent);
                break;
            }
            case R.id.btn4: {
                Intent courseinforintent = new Intent(this, Courseinfor.class);
                readCourselist("CE Elective", thecourse);
                courseinforintent.putExtra("MyClass", thecourse);
                startActivity(courseinforintent);
                break;
            }
            /*case R.id.btn5: {
                Intent junior1intent = new Intent(this, Courseinfor.class);
                //readCourselistbytype("Optics & Photonics", thecourse);
                junior1intent.putExtra("MyClass", thecourse);
                startActivity(junior1intent);
                break;
            }*/
            default: {
                break;
            }
        }
    }
}
