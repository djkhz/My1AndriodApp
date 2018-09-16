package com.example.techno.myapplication;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
private Button btn,btncal;
private TextView txt;
private CheckBox cb, cb2;
private EditText intxt,intxt1;
private View master_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.rootLayout);
        ConstraintSet set = new ConstraintSet();
        set.clone(layout);
        for(int i = 0; i<10; i++) {
            //Button 1:
            Button button = new Button(this);
            button.setText("Hello"+i);
            //button.setId(100);           // <-- Important= i+1000;
            button.setId(i+100);
            layout.addView(button);
        set.connect(button.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);
        set.connect(button.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT,0);
        set.connect(button.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,0);
            set.constrainHeight(button.getId(), 200);
            set.constrainWidth(button.getId(), ConstraintSet.MATCH_CONSTRAINT);
           // set.constrainWidth(secondButton.getId(), ConstraintSet.MATCH_CONSTRAINT);
            set.applyTo(layout);
        }
        //master_view = (View) findViewById(R.id.rootLayout);

        ///prgrammatically add new button linear layout
        //RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rootLayout);
        //relativeLayout.addView(button);
//        RelativeLayout layout = new RelativeLayout(this);
//        setContentView(layout, new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//
//
//
//        for(int i = 0; i<10; i++) {
//
//            Button button = new Button(this);
//            int id = i+1000;
//            button.setId(id);
//            button.setText("Button " + i);
//            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//            if(i==0) {
//                params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//            } else {
//                params.addRule(RelativeLayout.BELOW, id-1);
//            }
//            layout.addView(button, params);
//
//        }
///////////////////////////////////////////
        btn = (Button) findViewById(R.id.button2);
        btn.setText("xdOK");
        //btn.setOnClickListener(this);
        txt =(TextView) findViewById(R.id.txt);
        txt.setOnClickListener(this);

        cb =(CheckBox) findViewById(R.id.checkBox);
        cb2 =(CheckBox) findViewById(R.id.checkBox2);
        cb.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            cb.setChecked(b);
//                TransitionManager.beginDelayedTransition(viewGroup, new Explode());
//                toggle(textView, imageView, imageView2, imageView3);
        }
    });
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                txt.setText("test");
//                TransitionManager.beginDelayedTransition(viewGroup, new Explode());
//                toggle(textView, imageView, imageView2, imageView3);
            }
        });

//        this.setContentView(linear);
        intxt =(EditText) findViewById(R.id.intxt);
        intxt1 =(EditText) findViewById(R.id.intxt2);

        btn = (Button) findViewById(R.id.btncalc);

    }

    @Override
    public void onClick(View view) {
        btn.setText("XX");

    }
    public void onCalc(View view) {
        //String s = 8+8 +"";
        ///covert to string
        //int s=Integer.parseInt(intxt.getText()+"");
    int x=Integer.parseInt(intxt.getText().toString()) + Integer.parseInt(intxt1.getText().toString());
        txt.setText(Integer.toString(x));
        //txt.setText(s +"");


    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        cb2.setChecked(b);
    }
}
