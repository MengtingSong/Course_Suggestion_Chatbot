package com.example.allen.cours_selection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class GeneralEle extends AppCompatActivity {

    TextView social;
    TextView human;
    ScrollView socialpic;
    ScrollView humanpic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generalele);

        social = (TextView) findViewById(R.id.social);
        human = (TextView) findViewById(R.id.human);
        socialpic = (ScrollView) findViewById(R.id.socialpic);
        humanpic = (ScrollView) findViewById(R.id.humanpic);

    }
}