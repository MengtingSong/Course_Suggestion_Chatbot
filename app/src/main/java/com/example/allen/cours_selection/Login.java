package com.example.allen.cours_selection;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button next = findViewById(R.id.next);
        final TextInputEditText id = findViewById(R.id.id);
        final TextInputLayout idInput = findViewById(R.id.IDInputLayout);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate(id)) {
                    idInput.setError(null);
                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                }
                else{
                    idInput.setError(getString(R.string.error_password));
                }
                //validate(id.getText().toString());
            }
        });


    }

    public boolean validate(TextInputEditText id)
    {
        String userid = id.getText().toString().trim();
        if(userid.length() == 9)
        {
            Toast.makeText(this,"GREAT! LET'S PROCEED",Toast.LENGTH_SHORT).show();
            return true;
        }
        else
        {
            return false;
        }

    }
}

