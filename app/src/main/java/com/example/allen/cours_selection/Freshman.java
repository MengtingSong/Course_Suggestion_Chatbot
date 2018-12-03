package com.example.allen.cours_selection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Freshman extends AppCompatActivity {

    //initialize
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    public List<Course> courselist= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freshman);
        readCourselist();
        //initialize the button
        Button course1 = (Button)findViewById(R.id.button1);

        Button course2 = (Button)findViewById(R.id.button2);

        Button course3 = (Button)findViewById(R.id.button3);

        Button course4 = (Button)findViewById(R.id.button4);

        Button course5 = (Button)findViewById(R.id.button5);

        Button course6 = (Button)findViewById(R.id.button6);
        button1.setText(courselist.get(0).getName());
        button2.setText(courselist.get(1).getName());
        button3.setText(courselist.get(2).getName());
        button4.setText(courselist.get(3).getName());
        //button5.setText(courselist.get(4).getName());
        //button6.setText(courselist.get(5).getName());
        course1.setOnClickListener((View.OnClickListener)this);
        course2.setOnClickListener((View.OnClickListener)this);
        course3.setOnClickListener((View.OnClickListener)this);
        course4.setOnClickListener((View.OnClickListener)this);
        course5.setOnClickListener((View.OnClickListener)this);
        course6.setOnClickListener((View.OnClickListener)this);





        //Intent courseinformation=new Intent(this, Freshman.class);

    }

    public void readCourselist()
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
                String[] token =line.split((","));
                //read the data
                Course onecourse = new Course();
                onecourse.setCode(token[0]);
                onecourse.setName(token[1]);
                /*onecourse.setType(token[2]);
                onecourse.setYear(token[3]);*/
                /*onecourse.setPrerequisite(token[4]);
                onecourse.setCredit(token[5]);
                onecourse.setFuture(token[6]);
                onecourse.setSubject_speci(token[7]);
                onecourse.setDescription(token[8]);
                //onecourse.setNotimportant(token[9]);
                onecourse.setAdvise(token[10]);*/
                if (onecourse.getYear() == "FRESHMAN 1") {
                    courselist.add(onecourse);
                }
            }
        } catch(IOException e){
            Log.wtf("MyActivity", "Error reading data file on line" + line,e);
            e.printStackTrace();
        }



    }
}
