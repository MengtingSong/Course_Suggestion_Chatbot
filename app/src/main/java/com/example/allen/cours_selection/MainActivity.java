package com.example.allen.cours_selection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

//extends AppCompatActivity or Activity????
public class MainActivity extends AppCompatActivity implements OnClickListener {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    //Creating the EditText object
    /*private EditText editText_name;
    private EditText editText_buid;*/

    //Creating button objects, which extend (inherit) the V iew class
    private Button Freshman;
    private Button Sophomore;
    private Button Junior;
    private Button Senior;

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
        Freshman=(Button) findViewById(R.id.Freshman);
        Sophomore=(Button) findViewById(R.id.Sophomore);
        Junior=(Button) findViewById(R.id.Junior);
        Senior=(Button) findViewById(R.id.Senior);

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

        Freshman.setOnClickListener((View.OnClickListener)this);
        Junior.setOnClickListener((View.OnClickListener)this);
        Sophomore.setOnClickListener((View.OnClickListener)this);
        Senior.setOnClickListener((View.OnClickListener)this);
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
    //@Override
    public void onClick(View v) {


        //The switch statements grab the id values of the button pressed and calculates the tip accordingly
        switch (v.getId()) {
            case R.id.Freshman: {
                Intent fresmanintent = new Intent(this, Freshman.class);
                startActivity(fresmanintent);
                break;
            }

            case R.id.Sophomore: {
                Intent sophomoreintent = new Intent(this, Sophomore.class);
                startActivity(sophomoreintent);
                break;
            }
            case R.id.Junior: {
                Intent juniorintent = new Intent(this, Junior.class);
                startActivity(juniorintent);
                break;
            }
            case R.id.Senior: {
                Intent seniorintent = new Intent(this, Senior.class);
                startActivity(seniorintent);
                break;
            }
            default: {
                break;
            }
        }
    }


    //theStudent.name=nameinputted;




    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
