package com.example.allen.cours_selection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ImageView;


public class Course extends AppCompatActivity {

    private TextView code;
    private TextView name;
    private TextView credits;
    private TextView pre;
    private TextView future;
    private TextView discrip;
    //test


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course);

        code = (TextView)findViewById(R.id.code);
        name = (TextView)findViewById(R.id.name);
        credits = (TextView)findViewById(R.id.credits);
        pre = (TextView)findViewById(R.id.pre);
        future = (TextView) findViewById(R.id.future);
        discrip = (TextView) findViewById(R.id.discrip);

        // code for the first page along with design to be completed
    }
}