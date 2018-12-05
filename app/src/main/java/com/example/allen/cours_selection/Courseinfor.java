package com.example.allen.cours_selection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Courseinfor extends AppCompatActivity {
    TextView code;
    TextView name;
    TextView credits;
    TextView pre;
    TextView future;
    TextView discrip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courseinfor);

        Intent i = getIntent();
        Course thecourse = (Course)i.getSerializableExtra("MyClass");

        code = (TextView)findViewById(R.id.code);
        name = (TextView)findViewById(R.id.name);
        credits = (TextView)findViewById(R.id.credits);
        pre = (TextView)findViewById(R.id.pre);
        future = (TextView) findViewById(R.id.future);
        discrip = (TextView) findViewById(R.id.discrip);

        code.setText(thecourse.getCode());
        name.setText(thecourse.getName());
        credits.setText(thecourse.getCredit());
        pre.setText(thecourse.getPrerequisite());
        future.setText(thecourse.getFuture());
        discrip.setText(thecourse.getDescription());
    }
}
