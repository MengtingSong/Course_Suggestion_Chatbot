package com.example.allen.cours_selection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Year extends AppCompatActivity {

    Button freshman1;
    Button freshman2;
    Button sophomore1;
    Button sophomore2;
    Button junior1;
    Button junior2;
    Button senior1;
    Button senior2;

    TextView textyear;

    ImageView icon;
    TextView msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.year);

        freshman1 = (Button)findViewById(R.id.btn1);
        freshman2 = (Button)findViewById(R.id.btn2);
        sophomore1 = (Button)findViewById(R.id.btn3);
        sophomore2 = (Button)findViewById(R.id.btn4);
        junior1 = (Button)findViewById(R.id.btn5);
        junior2 = (Button)findViewById(R.id.btn6);
        senior1 = (Button)findViewById(R.id.btn7);
        senior2 = (Button)findViewById(R.id.btn8);

        textyear = (TextView)findViewById(R.id.txtyr);

        icon = (ImageView)findViewById(R.id.icon);
        msg = (TextView)findViewById(R.id.msg);

        freshman1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for freshman1 screen to be added here
            }
        });

        freshman2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for freshman2 screen to be added here
            }
        });

        sophomore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for sophomore1 screen to be added here
            }
        });

        sophomore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for sophomore2 screen to be added here
            }
        });

        junior1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for junior1 screen to be added here
            }
        });

        junior2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for junior2 screen to be added here
            }
        });

        senior1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for senior1 screen to be added here
            }
        });

        senior2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for senior2 screen to be added here
            }
        });

    }
}
