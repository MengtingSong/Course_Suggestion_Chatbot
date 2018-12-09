package com.example.allen.cours_selection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class engelelist extends AppCompatActivity{
    ListView courselist;
    ArrayList<Course> courselists = new ArrayList<Course>();
    String type;
    String subject;
    Course thecourse = new Course();

    MaterialButton back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engelelist);
        Intent i = getIntent();
        subject = (String) i.getStringExtra("subject");
        type = (String) i.getStringExtra("electivename");
        courselist = (ListView) findViewById(R.id.courselist);
        generateListcontent(type);

        back = (MaterialButton) findViewById(R.id.back);

        Log.d("Myactivity", "here!!!!!!!!!!!!!!!!!!!!!");
        //Log.d("Myactivity", type);
        Log.d("Myactivity", Integer.toString(courselists.size()));


        ListViewAdapter adaptor = new ListViewAdapter(getApplicationContext(), courselists);
        Log.d("dsbfskf", "problem==================");
        courselist.setAdapter(adaptor);
        courselist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                    Intent intent = new Intent(engelelist.this, Courseinfor.class);
                    intent.putExtra("MyClass", courselists.get(pos));
                    startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(engelelist.this,MainActivity.class);
                startActivity(i);
            }
        });
       // courselist.setAdapter(customAdaptor);
    }


    public class ListViewAdapter extends ArrayAdapter<Course>{
        private ArrayList<Course> allcourse;
        private Context mcontext;
        public ListViewAdapter(Context mcontext, ArrayList<Course> allcourse){
            super(mcontext, R.layout.thelist, allcourse);
            this.allcourse=allcourse;
            this.mcontext=mcontext;
        }
        @Override
        public View getView(int position, View convertview, ViewGroup parent)
        {
            LayoutInflater inflater = LayoutInflater.from(mcontext);
            View listVeiewItem=inflater.inflate(R.layout.thelist,null,true);
            TextView name = listVeiewItem.findViewById(R.id.name);
            TextView code = listVeiewItem.findViewById(R.id.code);
            Course thecourse = allcourse.get(position);
            name.setText(thecourse.getName());
            code.setText(thecourse.getCode());
            return listVeiewItem;
        }
    }


    private void generateListcontent(String type) {
        InputStream is = getResources().openRawResource(R.raw.overall_ece_sheet);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is)
        );

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                //Log.d("Myactivity","Line: "+line);
                //split by ','
                int i=0;
                String[] token = line.split((","));
                //read the data
                if (token[2].equals(type) && token[7].equals(subject)) {
                    Course onecourse = new Course();
                    onecourse.setCode(token[0]);
                    onecourse.setName(token[1]);
                    //Log.d("Myactivity", onecourse.getName());
                    onecourse.setType(token[2]);
                    onecourse.setYear(token[3]);
                    onecourse.setPrerequisite(token[4]);
                    onecourse.setCredit(token[5]);
                    onecourse.setFuture(token[6]);
                    onecourse.setSubject_speci(token[7]);
                    onecourse.setDescription(token[8]);
                    Log.d("Myactivity", "here!!!!!!!!!!!!!!!!!!!!!");
                    Log.d("Myactivity", onecourse.getName());
                    Log.d("Myactivity", onecourse.getType());
                    courselists.add(onecourse);
                    Log.d("Myactivity", courselists.get(i).getType());
                    i=i+1;
                }
            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }
    }


}
