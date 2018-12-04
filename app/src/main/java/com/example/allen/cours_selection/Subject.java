package com.example.allen.cours_selection;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;


public class Subject extends AppCompatActivity {

     Button opt1;
     Button opt2;
     Button opt3;
     Button opt4;
     Button opt5;
     Button opt6;

     TextView txt;

    ImageView icon;
    TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject);

        opt1 = (Button)findViewById(R.id.btn1);
        opt2 = (Button)findViewById(R.id.btn2);
        opt3 = (Button)findViewById(R.id.btn3);
        opt4 = (Button)findViewById(R.id.btn4);
        opt5 = (Button)findViewById(R.id.btn5);
        opt6 = (Button)findViewById(R.id.btn6);

        txt = (TextView)findViewById(R.id.txt);

        icon = (ImageView)findViewById(R.id.icon);
        msg = (TextView)findViewById(R.id.msg);

        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for opt1 screen to be added here
            }
        });
        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for opt2 screen to be added here
            }
        });

        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for opt3 screen to be added here
            }
        });

        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for opt4 screen to be added here
            }
        });

        opt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for opt5 screen to be added here
            }
        });

        opt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for opt6 screen to be added here
            }
        });
    }
}