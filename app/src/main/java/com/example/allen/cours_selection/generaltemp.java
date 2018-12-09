package com.example.allen.cours_selection;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class generaltemp extends AppCompatActivity {
    ImageView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generaltemp);

        list = (ImageView)findViewById(R.id.list);
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
