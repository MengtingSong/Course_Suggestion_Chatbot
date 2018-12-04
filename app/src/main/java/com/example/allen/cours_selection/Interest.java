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

public class Interest extends AppCompatActivity implements View.OnClickListener{
    Button opt1;
    Button opt2;
    Button opt3;
    Button opt4;
    Button opt5;
    Button opt6;

    TextView txt;

    Course thecourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        opt1 = (Button)findViewById(R.id.btn1);
        opt2 = (Button)findViewById(R.id.btn2);
        opt3 = (Button)findViewById(R.id.btn3);
        opt4 = (Button)findViewById(R.id.btn4);
        opt5 = (Button)findViewById(R.id.btn5);
        opt6 = (Button)findViewById(R.id.btn6);

        txt = (TextView)findViewById(R.id.txt);

        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);

        opt3.setOnClickListener(this);

        opt4.setOnClickListener(this);

        opt5.setOnClickListener(this);

        opt6.setOnClickListener(this);
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
                if (token[7].equals(coursecode)) {
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
                Intent freshman1intent = new Intent(this, Freshman1.class);
                readCourselist("Bioengineering", thecourse);
                freshman1intent.putExtra("MyClass", thecourse);
                startActivity(freshman1intent);
                break;
            }

            case R.id.btn2: {
                Intent freshman2intent = new Intent(this, Courseinfor.class);
                readCourselist("System Ctrl./Microsystem/Electrical Energy", thecourse);
                freshman2intent.putExtra("MyClass", thecourse);
                startActivity(freshman2intent);
                break;
            }
            case R.id.btn3: {
                Intent sophomore1intent = new Intent(this, Courseinfor.class);
                readCourselist("Comp. Eng. Software Oriented", thecourse);
                sophomore1intent.putExtra("MyClass", thecourse);
                startActivity(sophomore1intent);
                break;
            }
            case R.id.btn4: {
                Intent sophomore2intent = new Intent(this, Courseinfor.class);
                readCourselist("Electromagnetic/Electronic Dsgn.", thecourse);
                sophomore2intent.putExtra("MyClass", thecourse);
                startActivity(sophomore2intent);
                break;
            }
            case R.id.btn5: {
                Intent junior1intent = new Intent(this, Courseinfor.class);
                readCourselist("Optics & Photonics", thecourse);
                junior1intent.putExtra("MyClass", thecourse);
                startActivity(junior1intent);
                break;
            }
            case R.id.btn6: {
                Intent junior1intent = new Intent(this, Courseinfor.class);
                readCourselist("Digital Signal Pross./Telecommunication", thecourse);
                junior1intent.putExtra("MyClass", thecourse);
                startActivity(junior1intent);
                break;
            }
            default: {
                break;
            }
        }
    }
}
