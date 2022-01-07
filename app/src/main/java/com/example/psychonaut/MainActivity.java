package com.example.psychonaut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv1,iv2,iv3,iv4;
    Button buttonRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1=findViewById(R.id.imageView);
        iv1.setImageResource(R.drawable.icon1);
        iv2=findViewById(R.id.imageView2);
        iv2.setImageResource(R.drawable.icon2);
        iv3=findViewById(R.id.imageView3);
        iv3.setImageResource(R.drawable.icon3);
        iv4=findViewById(R.id.imageView4);
        iv4.setImageResource(R.drawable.icon4);
        buttonRes=findViewById(R.id.button);

        //onClick listeners:
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main1);
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main2);
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main3);
            }
        });
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main4);
            }
        });
    }


}