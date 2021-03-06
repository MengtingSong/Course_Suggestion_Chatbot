package com.example.allen.cours_selection;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class engelective extends AppCompatActivity implements View.OnClickListener{

    Button opt1;
    Button opt2;
    Button opt3;
    Button opt4;


    ImageView icon;
    TextView msg;
    MaterialButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engelective);

        opt1 = (Button)findViewById(R.id.btn1);
        opt2 = (Button)findViewById(R.id.btn2);
        opt3 = (Button)findViewById(R.id.btn3);
        opt4 = (Button)findViewById(R.id.btn4);

        icon = (ImageView)findViewById(R.id.icon);
        msg = (TextView)findViewById(R.id.msg);

        back = (MaterialButton) findViewById(R.id.back);

        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);

        opt3.setOnClickListener(this);

        opt4.setOnClickListener(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(engelective.this,MainActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1: {
                Intent electivename =new Intent(this, subject.class);
                electivename.putExtra("electivename", "EE Breadth");
                startActivity(electivename);
                break;
            }
            case R.id.btn2: {
                Intent electivename = new Intent(this, subject.class);
                electivename.putExtra("electivename", "Core Elective");
                startActivity(electivename);
                break;
            }
            case R.id.btn3: {
                Intent electivename = new Intent(this, subject.class);
                electivename.putExtra("electivename", "CE Elective");
                startActivity(electivename);
                break;

            }
            case R.id.btn4: {
                Intent electivename = new Intent(this, subject.class);
                electivename.putExtra("electivename", "technical");
                startActivity(electivename);
                break;

            }
        }
    }
}
