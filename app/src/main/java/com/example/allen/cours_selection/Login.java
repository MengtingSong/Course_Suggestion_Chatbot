package com.example.allen.cours_selection;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button next;
    TextView info;

    private TextInputLayout id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button next = findViewById(R.id.next);
        EditText id = findViewById(R.id.id);
        TextView info = findViewById(R.id.info);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
                //validate(id.getText().toString());
            }
        });


    }

    public boolean validate()
    {
        String userid = id.getEditText().getText().toString().trim();
        if(userid.length() == 9)
        {
            Toast.makeText(this,"GREAT! LET'S PROCEED",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Login.this, MainActivity.class);
            startActivity(i);
            return true;
        }
        else
        {
            info.setError("Enter a valid BU ID!");
            next.setEnabled(false);
            return false;
        }

    }
}

