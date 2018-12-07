package com.example.allen.cours_selection;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.allen.cours_selection.network.SubjectEntry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Subject_new extends AppCompatActivity implements View.OnClickListener {
    class InnerSubject_new extends Fragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setHasOptionsMenu(true);
        }

        @Override
        public View onCreateView(
                @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment with the ProductGrid theme
            View view = inflater.inflate(R.layout.activity_subject_new, container, false);

            // Set up the toolbar
            setUpToolbar(view);

            // Set up the RecyclerView
            RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
            SubjectCardRecyclerViewAdapter adapter = new SubjectCardRecyclerViewAdapter(
                    SubjectEntry.initSubjectEntryList(getResources()));
            recyclerView.setAdapter(adapter);
            int largePadding = getResources().getDimensionPixelSize(R.dimen.course_grid_spacing);
            int smallPadding = getResources().getDimensionPixelSize(R.dimen.course_grid_spacing_small);
            recyclerView.addItemDecoration(new SubjectGridItemDecoration(largePadding, smallPadding));

            return view;
        }

        private void setUpToolbar(View view) {
            Toolbar toolbar = view.findViewById(R.id.app_bar);
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            if (activity != null) {
                activity.setSupportActionBar(toolbar);
            }
        }
    }

    Button digital;
    Button computer;
    Button system_control;
    Button electro;
    Button optics;
    Button bioeng;
    ArrayList<Course> courselists = new ArrayList<Course>();
    //Course onecourse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);


        digital = (Button) findViewById(R.id.sub2);
        computer = (Button) findViewById(R.id.sub1);
        system_control = (Button) findViewById(R.id.sub4);
        electro = (Button) findViewById(R.id.sub3);
        optics = (Button) findViewById(R.id.sub8);
        bioeng = (Button) findViewById(R.id.sub6);

        digital.setOnClickListener(this);
        computer.setOnClickListener(this);
        system_control.setOnClickListener(this);
        electro.setOnClickListener(this);
        optics.setOnClickListener(this);
        bioeng.setOnClickListener(this);
    }

    private void generateListcontent(String type, String subject) {
        InputStream is = getResources().openRawResource(R.raw.overall_ece_sheet);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is)
        );

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                //Log.d("Myactivity","Line: "+line);
                //split by ','
                int i = 0;
                String[] token = line.split((","));
                //read the data
                Log.d("Myactivity", token[2]);
                Log.d("Myactivity", token[7]);
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
                    Log.d("Myactivity", courselists.get(i).getSubject_speci());
                    i = i + 1;
                }
            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        Intent i = getIntent();
        String electivename = (String) i.getStringExtra("electivename");
        switch (v.getId()) {
            case R.id.sub2: {
                courselists.clear();
                Log.d("Myactivity", Integer.toString(courselists.size()));
                generateListcontent(electivename, "Digital Signal Processing & Telecommunication");
                if (courselists.size() != 0) {
                    Intent theelectivename = new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "Digital Signal Processing & Telecommunication");
                    theelectivename.putExtra("electivename", electivename);

                    startActivity(theelectivename);
                } else {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }
                break;
            }
            case R.id.sub1: {
                courselists.clear();
                generateListcontent(electivename, "Computer Engineering");
                if (courselists.size() != 0) {
                    Intent theelectivename = new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "Computer Engineering");
                    theelectivename.putExtra("electivename", electivename);

                    startActivity(theelectivename);
                } else {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }
                break;
            }
            case R.id.sub4: {
                courselists.clear();
                generateListcontent(electivename, "System Control & Microsystem & Electrical Energy ");
                if (courselists.size() != 0) {
                    Intent theelectivename = new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "System Control & Microsystem & Electrical Energy ");
                    theelectivename.putExtra("electivename", electivename);
                    startActivity(theelectivename);
                } else {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }
                break;
            }
            case R.id.sub3: {
                courselists.clear();
                generateListcontent(electivename, "Electromagnetic & Electronic Design");
                if (courselists.size() != 0) {

                    Intent theelectivename = new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "Electromagnetic & Electronic Design");
                    theelectivename.putExtra("electivename", electivename);
                    startActivity(theelectivename);
                } else {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }

                break;
            }
            case R.id.sub8: {
                courselists.clear();
                generateListcontent(electivename, "Optics and Photonics");
                if (courselists.size() != 0) {
                    Intent theelectivename = new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "Optics and Photonics");
                    theelectivename.putExtra("electivename", electivename);
                    startActivity(theelectivename);
                } else {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }
                break;
            }
            case R.id.sub6: {
                courselists.clear();
                generateListcontent(electivename, "Bioengineering ");
                if (courselists.size() != 0) {
                    Intent theelectivename = new Intent(this, engelelist.class);
                    theelectivename.putExtra("subject", "Bioengineering ");
                    startActivity(theelectivename);
                } else {
                    Intent theempty = new Intent(this, empty.class);
                    startActivity(theempty);
                }
                break;
            }

        }
    }
}