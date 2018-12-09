package com.example.allen.cours_selection;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class generalelective extends AppCompatActivity implements View.OnClickListener{
    MaterialButton humanity;
    MaterialButton social;
    MaterialButton general;
    MaterialButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generalelective);
        humanity = (MaterialButton) findViewById(R.id.humanity);
        social = (MaterialButton) findViewById(R.id.social);
        general = (MaterialButton) findViewById(R.id.general);
        //back = (MaterialButton) findViewById(R.id.back);

        humanity.setOnClickListener(this);
        social.setOnClickListener(this);
        general.setOnClickListener(this);
        //back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.humanity: {
                Intent i = new Intent(this, generaltemp.class);
                i.putExtra("generaltype", "humanity");
                startActivity(i);
                break;
            }
            case R.id.social: {
                Intent i = new Intent(this, generaltemp.class);
                i.putExtra("generaltype", "social");
                startActivity(i);
                break;
            }
            case R.id.general: {
                Intent i = new Intent(this, generaltemp.class);
                i.putExtra("generaltype", "general");
                startActivity(i);
                break;
            }

        }
    }
}
