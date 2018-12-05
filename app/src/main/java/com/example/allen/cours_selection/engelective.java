package com.example.allen.cours_selection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);

        opt3.setOnClickListener(this);

        opt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1: {
                Intent EE_Breadth =new Intent(this, engelelist.class);
                EE_Breadth.putExtra("electivename", "EE Breadth");
                startActivity(EE_Breadth);
            }
            case R.id.btn2: {
                Intent Core_Elective = new Intent(this, engelelist.class);
                Core_Elective.putExtra("electivename", "Core Elective");
                startActivity(Core_Elective);
            }
            case R.id.btn3: {
                Intent CE_Elective = new Intent(this, engelelist.class);
                CE_Elective.putExtra("electivename", "CE Elective");
                startActivity(CE_Elective);
            }
            case R.id.btn4: {
                Intent technical = new Intent(this, engelelist.class);
                technical.putExtra("electivename", "technical");
                startActivity(technical);
            }
        }
    }
}
