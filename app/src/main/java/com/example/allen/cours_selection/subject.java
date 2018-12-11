package com.example.allen.cours_selection;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class subject extends AppCompatActivity implements View.OnClickListener{
    MaterialButton digital;
    MaterialButton computer;
    MaterialButton system_control;
    MaterialButton electro;
    MaterialButton optics;
    MaterialButton bioeng;
    ImageView ce;
    ImageView ee;
    ImageView optic;
    ImageView system;
    ImageView telecom;
    ImageView be;

    ArrayList<Course> courselists = new ArrayList<Course>();
    //Course onecourse;
    MaterialButton back;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);


        digital=(MaterialButton)findViewById(R.id.sub2);
        computer=(MaterialButton)findViewById(R.id.sub1);
        system_control=(MaterialButton)findViewById(R.id.sub4);
        electro=(MaterialButton)findViewById(R.id.sub3);
        optics=(MaterialButton)findViewById(R.id.sub8);
        bioeng=(MaterialButton)findViewById(R.id.sub6);
        ce=(ImageView)findViewById(R.id.cepic);
        ee=(ImageView)findViewById(R.id.eepic);
        optic=(ImageView)findViewById(R.id.opticpic);
        system=(ImageView)findViewById(R.id.systempic);
        telecom=(ImageView)findViewById(R.id.telecompic);
        be=(ImageView)findViewById(R.id.bepic);
        back = (MaterialButton) findViewById(R.id.back);

        digital.setOnClickListener(this);
        computer.setOnClickListener(this);
        system_control.setOnClickListener(this);
        electro.setOnClickListener(this);
        optics.setOnClickListener(this);
        bioeng.setOnClickListener(this);
        ce.setOnClickListener(this);
        ee.setOnClickListener(this);
        optic.setOnClickListener(this);
        system.setOnClickListener(this);
        telecom.setOnClickListener(this);
        be.setOnClickListener(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(subject.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
    private void generateListcontent(String type, String subject) {
        InputStream is = getResources().openRawResource(R.raw.overall_ece_sheet);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is)
        );

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                //Log.d("Myactivity","Line: "+line);
                //split by ','
                int i=0;
                String[] token = line.split((","));
                //read the data
                Log.d("Myactivity", token[2]);
                Log.d("Myactivity", token[7]);
                if (token[2].equals(type) && token[7].equals(subject)) {
                    Course onecourse = new Course();
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
                    Log.d("Myactivity", onecourse.getName());
                    Log.d("Myactivity", onecourse.getType());
                    courselists.add(onecourse);
                    Log.d("Myactivity", courselists.get(i).getSubject_speci());
                    i=i+1;
                }
            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v){
        Intent i = getIntent();
        String electivename= (String)i.getStringExtra("electivename");
        switch (v.getId()){
            case R.id.sub2: {
                courselists.clear();
                Log.d("Myactivity", Integer.toString(courselists.size()));
                generateListcontent(electivename, "Digital Signal Processing & Telecommunication");
                if (courselists.size()!=0) {
                    Intent theelectivename = new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "Digital Signal Processing & Telecommunication");
                    theelectivename.putExtra("electivename", electivename);

                    startActivity(theelectivename);
                }
                else
                {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }
                break;
            }
            case R.id.telecompic:{
                courselists.clear();
                Log.d("Myactivity", Integer.toString(courselists.size()));
                generateListcontent(electivename, "Digital Signal Processing & Telecommunication");
                if (courselists.size()!=0) {
                    Intent theelectivename = new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "Digital Signal Processing & Telecommunication");
                    theelectivename.putExtra("electivename", electivename);

                    startActivity(theelectivename);
                }
                else
                {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }
                break;
            }
            case R.id.sub1: {
                courselists.clear();
                generateListcontent(electivename, "Computer Engineering");
                if (courselists.size()!=0) {
                    Intent theelectivename = new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "Computer Engineering");
                    theelectivename.putExtra("electivename", electivename);

                    startActivity(theelectivename);
                }
                else
                {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }
                break;
            }
            case R.id.cepic:{
                courselists.clear();
                generateListcontent(electivename, "Computer Engineering");
                if (courselists.size()!=0) {
                    Intent theelectivename = new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "Computer Engineering");
                    theelectivename.putExtra("electivename", electivename);

                    startActivity(theelectivename);
                }
                else
                {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }
                break;
            }
            case R.id.sub4: {
                courselists.clear();
                generateListcontent(electivename, "System Control & Microsystem & Electrical Energy ");
                if (courselists.size()!=0){
                    Intent theelectivename =new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "System Control & Microsystem & Electrical Energy ");
                    theelectivename.putExtra("electivename", electivename);
                    startActivity(theelectivename);}
                else
                {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }
                break;
            }
            case R.id.systempic:{
                courselists.clear();
                generateListcontent(electivename, "System Control & Microsystem & Electrical Energy ");
                if (courselists.size()!=0){
                    Intent theelectivename =new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "System Control & Microsystem & Electrical Energy ");
                    theelectivename.putExtra("electivename", electivename);
                    startActivity(theelectivename);}
                else
                {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }
                break;
            }
            case R.id.sub3: {
                courselists.clear();
                generateListcontent(electivename, "Electromagnetic & Electronic Design");
                if (courselists.size()!=0) {

                    Intent theelectivename = new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "Electromagnetic & Electronic Design");
                    theelectivename.putExtra("electivename", electivename);
                    startActivity(theelectivename);
                }
                else
                {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }

                break;
            }
            case R.id.eepic: {
                courselists.clear();
                generateListcontent(electivename, "Electromagnetic & Electronic Design");
                if (courselists.size()!=0) {

                    Intent theelectivename = new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "Electromagnetic & Electronic Design");
                    theelectivename.putExtra("electivename", electivename);
                    startActivity(theelectivename);
                }
                else
                {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }

                break;
            }
            case R.id.sub8: {
                courselists.clear();
                generateListcontent(electivename, "Optics and Photonics");
                if (courselists.size()!=0) {
                    Intent theelectivename = new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "Optics and Photonics");
                    theelectivename.putExtra("electivename", electivename);
                    startActivity(theelectivename);
                }
                else
                {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }
                break;
            }
            case R.id.opticpic: {
                courselists.clear();
                generateListcontent(electivename, "Optics and Photonics");
                if (courselists.size()!=0) {
                    Intent theelectivename = new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "Optics and Photonics");
                    theelectivename.putExtra("electivename", electivename);
                    startActivity(theelectivename);
                }
                else
                {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }
                break;
            }
            case R.id.sub6: {
                courselists.clear();
                generateListcontent(electivename, "Bioengineering ");
                if (courselists.size()!=0) {
                    Intent theelectivename = new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "Bioengineering ");
                    startActivity(theelectivename);
                }
                else
                {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }
                break;
            }
            case R.id.bepic:{
                courselists.clear();
                generateListcontent(electivename, "Bioengineering ");
                if (courselists.size()!=0) {
                    Intent theelectivename = new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "Bioengineering ");
                    startActivity(theelectivename);
                }
                else
                {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }
                break;
            }

        }
    }
}
