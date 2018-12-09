package com.example.allen.cours_selection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//MT: Add BUID check function as below to the login page after setting it as the mainActivity
//Next, add a click listener to the "Next" button that sets and clears the error based on the isPasswordValid() method
//See LoginFragment_FR.java for reference

//extends AppCompatActivity or Activity???? MT: extends from AppCompatActivity
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // Used to load the 'native-lib' library on application startup.


    //Creating the EditText object
    /*private EditText editText_name;
    private EditText editText_buid;*/

    //Creating button objects, which extend (inherit) the V iew class
    private Button Freshman1;
    private Button Freshman2;
    private Button Sophomore1;
    private Button Sophomore2;
    private Button Junior1;
    private Button Junior2;
    private Button Senior1;
    private Button Senior2;


    //Creating the course and student class
    /*Course courselist=new Course();
    Intent courseinformation=new Intent(this, Freshman.class);
    Student theStudent=new Student();
    Intent studentinformation=new Intent(this, Freshman.class);*/


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //input the name and BUID
        /*editText_name=(EditText) findViewById(R.id.editText_name);
        editText_buid=(EditText) findViewById(R.id.editText_buid);*/

        //define the button
        Freshman1=(Button)findViewById(R.id.btn1);
        Freshman2=(Button)findViewById(R.id.btn2);
        Sophomore1=(Button)findViewById(R.id.btn3);
        Sophomore2=(Button)findViewById(R.id.btn4);
        Junior1=(Button)findViewById(R.id.btn5);
        Junior2=(Button)findViewById((R.id.btn6)) ;
        Senior1=(Button)findViewById(R.id.btn7);
        Senior2=(Button)findViewById(R.id.btn8);



        //define what run next when button is clicked
        /*Freshman.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                    openFreshman();
            }

        });
        Sophomore.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openSophomore();
            }
        });*/

        Freshman1.setOnClickListener(this);
        Freshman2.setOnClickListener(this);
        Sophomore1.setOnClickListener(this);
        Sophomore2.setOnClickListener(this);
        Junior1.setOnClickListener(this);
        Junior2.setOnClickListener(this);
        Senior1.setOnClickListener(this);
        Senior2.setOnClickListener(this);

        /*button_sophomore.setOnClickListener(this);
        button_junior.setOnClickListener(this);
        button_senior.setOnClickListener(this);
        // Example of a call to a native method*/
        //TextView tv = (TextView) findViewById(R.id.sample_text);
        //tv.setText(stringFromJNI());

        //passing the information to the next class
        /*courseinformation.putExtra("CourseObject", courselist);
        studentinformation.putExtra("StudentObject", theStudent);*/

    }

    /*public void openFreshman()
    {
        Intent i=new Intent(this, Freshman.class);
        startActivity(i);
    }

    public void openSophomore()
    {

    }*/
    @Override
    public void onClick(View v) {


        //The switch statements grab the id values of the button pressed and calculates the tip accordingly
        switch (v.getId()) {
            case R.id.btn1: {
                Intent fresman1intent = new Intent(this, Freshman1.class);
                startActivity(fresman1intent);
                break;
            }

            case R.id.btn2: {
                Intent freshman2intent = new Intent(this, Freshman2.class);
                startActivity(freshman2intent);
                break;
            }
            case R.id.btn3: {
                Intent sophomore1intent = new Intent(this, Sophomore1.class);
                startActivity(sophomore1intent);
                break;
            }
            case R.id.btn4: {
                Intent sophomore2intent = new Intent(this, Sophomore2.class);
                startActivity(sophomore2intent);
                break;
            }
            case R.id.btn5: {
                Intent junior1intent = new Intent(this, Junior1.class);
                startActivity(junior1intent);
                break;
            }
            case R.id.btn6: {
                Intent junior2intent = new Intent(this, Junior2.class);
                startActivity(junior2intent);
                break;
            }
            case R.id.btn7: {
                Intent senior1intent = new Intent(this, Senior1.class);
                startActivity(senior1intent);
                break;
            }
            case R.id.btn8: {
                Intent senior2intent = new Intent(this, Senior2.class);
                startActivity(senior2intent);
                break;
            }
            default: {
                break;
            }
        }
    }


    //theStudent.name=nameinputted;





    //public native String stringFromJNI();
}


