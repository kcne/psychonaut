package com.example.psychonaut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
        //iv3.setImageResource(R.drawable.icon3);
        iv4=findViewById(R.id.imageView4);
        //iv4.setImageResource(R.drawable.icon4);
        buttonRes=findViewById(R.id.buttonReset);
        buttonRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            resetAll();
            }
        });



    }
    public void sendMessage(View view) {
        //Intent intent = new Intent(this, activitytest.class);
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);

    }
    public void openGame1(View view){
        Intent intent = new Intent(this, game4.class);
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void openGame2(View view){
        Intent intent = new Intent(this, game3.class);
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


    public void goToMainAct(View view) {
    }

    public void openResults(View view) {
        Intent intent = new Intent(this, game1.class);
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void resetAll() {
        SharedPreferences preferences = getSharedPreferences("settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("Game3C", 0);
        editor.putInt("Game4C",0);
        editor.putBoolean("Game3Completed",false);
        editor.putInt("numberOfQuestionsIE", 0);
        editor.putFloat("Introverted", 0);
        editor.putFloat("Extroverted", 0);
        editor.putInt("numberOfQuestionsIS", 0);
        editor.putFloat("Intuitive", 0);
        editor.putFloat("Sensor", 0);
        editor.putInt("numberOfQuestionsTF", 0);
        editor.putFloat("Thinker", 0);
        editor.putFloat("Feeler", 0);
        editor.putInt("numberOfQuestionsJP", 0);
        editor.putFloat("Judging", 0);
        editor.putFloat("Perceiving", 0);
        editor.apply();
    }
}