package com.example.allen.cours_selection;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Freshman extends AppCompatActivity{

    //initialize
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    public List<Course> courselist= new ArrayList<Course>(100);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freshman);
        readCourselist("fff");
        //Log.d(courselist[0].getname());
        //initialize the button
        Button course1 = (Button)findViewById(R.id.btn1);

        Button course2 = (Button)findViewById(R.id.btn2);

        Button course3 = (Button)findViewById(R.id.btn3);

        Button course4 = (Button)findViewById(R.id.btn4);


        course1.setText(courselist.get(0).getName());
        course2.setText(courselist.get(1).getName());
        course3.setText(courselist.get(2).getName());
        course4.setText(courselist.get(3).getName());






        Intent courseinformation=new Intent(this, Freshman.class);

    }

    public void readCourselist(String coursename)
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
                String[] token =line.split((","));
                //read the data
                Course onecourse = new Course();
                onecourse.setCode(token[0]);
                onecourse.setName(token[1]);
                //Log.d("Myactivity", onecourse.getName());
                onecourse.setType(token[2]);
                onecourse.setYear(token[3]);


                String theYear;
                theYear="Freshman 1";
                Log.d("Myactivity","here!!!!!!!!!!!!!!!!!!!!!");
                Log.d("Myactivity",onecourse.getYear());
                if (onecourse.getYear().equals(theYear)) {
                    Log.d("Myactivity", onecourse.getName());
                    courselist.add(onecourse);
                }
            }
        } catch(IOException e){
            Log.wtf("MyActivity", "Error reading data file on line" + line,e);
            e.printStackTrace();
        }



    }
}
