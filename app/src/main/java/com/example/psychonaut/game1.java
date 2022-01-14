package com.example.psychonaut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class game1 extends AppCompatActivity {
    Button button;
    SeekBar seekBar1,seekBar2,seekBar3,seekBar4;
    TextView ietv,istv,tftv,jptv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
        button=findViewById(R.id.homeAct1);
        seekBar1=findViewById(R.id.seekBar1);
        seekBar2=findViewById(R.id.seekBar2);
        seekBar3=findViewById(R.id.seekBar3);
        seekBar4=findViewById(R.id.seekBar4);
        ietv=findViewById(R.id.textViewInEx);
        istv=findViewById(R.id.textViewInSn);
        tftv=findViewById(R.id.textViewTnFe);
        jptv=findViewById(R.id.textViewJgPc);
        int  ie,is,tf,jp;
        SharedPreferences preferences = getSharedPreferences("settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        ie= (int)Math.round(preferences.getFloat("Introverted", 0));
        is=(int)Math.round(preferences.getFloat("Intuitive",0));
        tf=(int)Math.round(preferences.getFloat("Thinker",0));
        jp=(int)Math.round(preferences.getFloat("Judging",0));
        editor.apply();
        seekBar1.setProgress(ie);
        seekBar2.setProgress(is);
        seekBar3.setProgress(tf);
        seekBar4.setProgress(jp);

        seekBar1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        seekBar2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        seekBar3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        seekBar4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        if (ie<50){
            ietv.setText("An introvert is a person with qualities of a personality type known as introversion, which means that they feel more comfortable focusing on their inner thoughts and ideas, rather than what's happening externally.");
        }
        else{
            ietv.setText("A typically gregarious and unreserved person who enjoys and seeks out social interaction Extroverts are more recognized because of their affable nature, while introverts struggle to break out of their personal space");
        }
        if(is<50){
            istv.setText("Intuitive people live in the future and are immersed in the world of possibilities. They process information through patterns and impressions. Intuitive people value inspiration and imagination. They gather knowledge by reading between the lines.");
        }
        else{
            istv.setText("In the terminology of personality type, sensors are hands-on people who prefer to process information about the world in terms of what they can see, hear, feel, touch, and taste.");
        }
        if(tf<50){
            tftv.setText("Thinkers enjoy discovering the information behind the information and may know a little bit (or a great deal) about just about everything. They rely on their logic, time to think, and investigation of the facts to make decisions");
        }
        else{
            tftv.setText("Feelers are sensitive to their feelings and to the feelings of others. Some of the characteristics of feelers are: Are very sensitive to conflict; Make decisions based on relationships; React with strong feelings to interpersonal challenges; ");
        }
        if(jp<50){
            jptv.setText("Preferring to consider their options ahead of time, personality types with this trait prefer clarity and closure, sticking with the plan rather than going with the flow.");
        }
        else {
            jptv.setText("Perceiving personality types, or Ps, are relaxed. They cope with challenges by keeping an open schedule that allows them the flexibility to work at their own pace and change tasks as needed. In the workplace, people with a perceiving preference are adaptable and nonjudgmental.");
        }
    }
    public void setBars(){


    }
    public void goToMainAct(View view){
        Intent i=new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}