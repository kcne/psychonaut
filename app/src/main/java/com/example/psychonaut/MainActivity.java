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



    }
    public void sendMessage(View view) {
        //Intent intent = new Intent(this, activitytest.class);
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);

    }
    public void openGame1(View view){
        Intent intent = new Intent(this, game1.class);
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void openGame2(View view){
        Intent intent = new Intent(this, game2.class);
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void openGame3(View view){
        Intent intent = new Intent(this, game3.class);
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void openGame4(View view){
        Intent intent = new Intent(this, game4.class);
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }



}