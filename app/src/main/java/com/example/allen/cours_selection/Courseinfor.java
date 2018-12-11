package com.example.allen.cours_selection;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class Courseinfor extends AppCompatActivity {
    TextView code;
    TextView name;
    TextView credits;
    TextView pre;
    TextView future;
    TextView discrip;
    ScrollView scroll;

    MaterialButton back;

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
        scroll=(ScrollView)findViewById(R.id.scroll);
        discrip.setMovementMethod(new ScrollingMovementMethod());

        back = (MaterialButton) findViewById(R.id.back);

        code.setText(thecourse.getCode());
        name.setText(thecourse.getName());
        credits.setText(thecourse.getCredit());
        pre.setText(thecourse.getPrerequisite());
        future.setText(thecourse.getFuture());
        discrip.setText(thecourse.getDescription());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Courseinfor.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
    private void appendTextAndScroll(String text)
    {
        if(discrip != null){
            discrip.append(text + "\n");
            final Layout layout = discrip.getLayout();
            if(layout != null){
                int scrollDelta = layout.getLineBottom(discrip.getLineCount() - 1)
                        - discrip.getScrollY() - discrip.getHeight();
                if(scrollDelta > 0)
                    discrip.scrollBy(0, scrollDelta);
            }
        }
    }


}
