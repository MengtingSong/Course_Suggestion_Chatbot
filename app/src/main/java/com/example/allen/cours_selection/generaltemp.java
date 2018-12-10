package com.example.allen.cours_selection;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class generaltemp extends AppCompatActivity {
    ImageView list;

    MaterialButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generaltemp);

        back = (MaterialButton) findViewById(R.id.back);
        list = (ImageView)findViewById(R.id.courselist);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(generaltemp.this,MainActivity.class);
                startActivity(i);
            }
        });
        Intent i = getIntent();
        String type = (String) i.getStringExtra("generaltype");
        if (type.equals("humanity"))
        {
         list.setImageResource(R.drawable.humanity_elective);
        }
        else if(type.equals("social")){
            list.setImageResource(R.drawable.social_science_elective);
        }
        else if(type.equals("general")){
            list.setImageResource(R.drawable.general_elective);
        }
    }
}
