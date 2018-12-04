package com.example.allen.cours_selection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Junior2 extends AppCompatActivity {

     Button sub1;
     Button sub2;
     Button sub3;
     Button sub4;

     TextView txt1;

     ImageView icon;
     TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.junior2);

        sub1 = (Button)findViewById(R.id.btn1);
        sub2 = (Button)findViewById(R.id.btn2);
        sub3 = (Button)findViewById(R.id.btn3);
        sub4 = (Button)findViewById(R.id.btn4);

        txt1 = (TextView)findViewById(R.id.name);

        icon = (ImageView)findViewById(R.id.icon);
        msg = (TextView)findViewById(R.id.msg);

        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for ee breadth ele. screen to be added here
            }
        });

        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for computer eng ele. screen to be added here
            }
        });

        sub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for ce core ele. screen to be added here
            }
        });

        sub4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for humanities ele. screen to be added here
            }
        });
    }
}
