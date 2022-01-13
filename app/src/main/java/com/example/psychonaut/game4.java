package com.example.psychonaut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class game4 extends AppCompatActivity {

    ImageView image;
    ListView listView;
    List<jpQuestion> listQ = new ArrayList<jpQuestion>();
    statsGenerator sg;
    TextView questionC;
    TextView questionText;
    TextView introvertStats,extrovertStats,intuitiveStats,sensorStats,thinkerStats,feelerStats,judgingStats,perceiveingStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game4);
        image = findViewById(R.id.imageViewR);
        listView = findViewById(R.id.listViewR);
        sg = new statsGenerator();
        listQ = loadImageQA();
        questionC = findViewById(R.id.textBoxQCR);
        questionText=findViewById(R.id.textViewQR);
        introvertStats=findViewById(R.id.textViewIntrovert);
        extrovertStats=findViewById(R.id.textViewExtrovert);
        intuitiveStats=findViewById(R.id.textViewIntuitive);
        sensorStats=findViewById(R.id.textViewSensor);
        thinkerStats=findViewById(R.id.textViewThinker);
        feelerStats=findViewById(R.id.textViewFeeler);
        judgingStats=findViewById(R.id.textViewJudging);
        perceiveingStats=findViewById(R.id.textViewPerceiving);



        ArrayList<String> answerAr = new ArrayList<>();
        String questionS = listQ.get(0).question;
        answerAr = listQ.get(0).answers;
        double answerPoints[] = listQ.get(0).points;
        ArrayAdapter<String> answerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, answerAr);
        listView.setAdapter(answerAdapter);

        //set starting stats

        introvertStats.setText("Introverted: "+Double.toString(Math.round(sg.introvertStats * 100)) + "%");
        extrovertStats.setText("Extroverted: "+Double.toString(0) + "%");
        intuitiveStats.setText("Intuitive: "+Double.toString(Math.round(sg.intuitiveStats * 100)) + "%");
        sensorStats.setText("Sensor: "+Double.toString(0) + "%");
        thinkerStats.setText("Thinker: "+Double.toString(Math.round(sg.thinkerStats * 100)) + "%");
        feelerStats.setText("Feeler: "+Double.toString(0) + "%");
        judgingStats.setText("Judging: "+Double.toString(Math.round(sg.judgingStats * 100)) + "%");
        perceiveingStats.setText("Perceiving: "+Double.toString(0) + "%");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (sg.numberOfQuestionsGlobal == 9) {
                    answerAdapter.clear();
                    questionText.setText("You successfully completed the Rorchach Blot test!");
                    image.setImageResource(R.drawable.congrats);
                    introvertStats.setText("");
                    extrovertStats.setText("");
                    intuitiveStats.setText("");
                    sensorStats.setText("");
                    thinkerStats.setText("");
                    feelerStats.setText("");
                    judgingStats.setText("");
                    perceiveingStats.setText("");
                    //
                } else {

                    switch (listQ.get(sg.numberOfQuestionsGlobal).questionType) {
                        case 0:
                            sg.evaluateIE(listQ.get(sg.numberOfQuestionsGlobal), position);
                            introvertStats.setText("Introverted: "+Double.toString(Math.round(sg.introvertStats * 100)) + "%");
                            extrovertStats.setText("Extroverted: "+Double.toString(Math.round(100-sg.introvertStats * 100)) + "%");
                            int questionCounter = sg.getNumberOfQuestionsGlobal();
                            ArrayList<String> answerList = new ArrayList<String>();
                            answerList = listQ.get(questionCounter).answers;
                            answerAdapter.clear();
                            answerAdapter.addAll(answerList);
                            listView.setAdapter(answerAdapter);
                            questionC.setText(Integer.toString(sg.numberOfQuestionsGlobal + 1) + "/10");
                            break;  //optional
                        case 1:
                            sg.evaluateIS(listQ.get(sg.numberOfQuestionsGlobal), position);
                            intuitiveStats.setText("Intuitive: "+Double.toString(Math.round(sg.intuitiveStats * 100)) + "%");
                            sensorStats.setText("Sensor: "+Double.toString(Math.round(100-sg.intuitiveStats * 100)) + "%");
                            questionCounter = sg.getNumberOfQuestionsGlobal();
                            ArrayList<String> answerList1 = new ArrayList<String>();
                            answerList1 = listQ.get(questionCounter).answers;
                            answerAdapter.clear();
                            answerAdapter.addAll(answerList1);
                            listView.setAdapter(answerAdapter);
                            questionC.setText(Integer.toString(sg.numberOfQuestionsGlobal + 1) + "/10");
                            break;  //optional
                        case 2:
                            sg.evaluateTF(listQ.get(sg.numberOfQuestionsGlobal), position);
                            thinkerStats.setText("Thinker: "+Double.toString(Math.round(sg.thinkerStats * 100)) + "%");
                            feelerStats.setText("Feeler: "+Double.toString(Math.round(100-sg.thinkerStats * 100)) + "%");
                            questionCounter = sg.getNumberOfQuestionsGlobal();
                            ArrayList<String> answerList2 = new ArrayList<String>();
                            answerList2 = listQ.get(questionCounter).answers;
                            answerAdapter.clear();
                            answerAdapter.addAll(answerList2);
                            listView.setAdapter(answerAdapter);
                            questionC.setText(Integer.toString(sg.numberOfQuestionsGlobal + 1) + "/10");
                            break;  //optional
                        case 3:
                            sg.evaluateJP(listQ.get(sg.numberOfQuestionsGlobal), position);
                            judgingStats.setText("Judging: "+Double.toString(Math.round(sg.judgingStats * 100)) + "%");
                            perceiveingStats.setText("Perceiving: "+Double.toString(Math.round(100-sg.judgingStats * 100)) + "%");
                            questionCounter = sg.getNumberOfQuestionsGlobal();
                            ArrayList<String> answerList3 = new ArrayList<String>();
                            answerList3 = listQ.get(questionCounter).answers;
                            answerAdapter.clear();
                            answerAdapter.addAll(answerList3);
                            listView.setAdapter(answerAdapter);
                            questionC.setText(Integer.toString(sg.numberOfQuestionsGlobal + 1) + "/10");
                            break;  //optional
                        default:
                            //code to be executed if all cases are not matched;
                    }
                    switch (sg.numberOfQuestionsGlobal) {
                        case 1:
                            image.setImageResource(R.drawable.rorschach2);
                            break;  //optional
                        case 2:
                            image.setImageResource(R.drawable.rorschach3);
                            break;  //optional
                        case 3:
                            image.setImageResource(R.drawable.rorschach4);
                            break;  //optional
                        case 4:
                            image.setImageResource(R.drawable.rorschach5);
                            break;  //optional
                        case 5:
                            image.setImageResource(R.drawable.rorschach6);
                            break;  //optional
                        case 6:
                            image.setImageResource(R.drawable.rorschach7);
                            break;  //optional
                        case 7:
                            image.setImageResource(R.drawable.rorschach8);
                            break;  //optional
                        case 8:
                            image.setImageResource(R.drawable.rorschach9);
                            break;  //optional
                        case 9:
                            image.setImageResource(R.drawable.rorschach10);
                            break;  //optional
                    }
                }
            }
        });

    }

    public void goToMainAct(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public List<jpQuestion> loadImageQA() {
        List<jpQuestion> ql = new ArrayList<jpQuestion>();
        ArrayList<String> answerArray = new ArrayList<String>();
        String questionS = "What do you see in the picture?";
        answerArray.add("bath");
        answerArray.add("butterfly");
        answerArray.add("moth");
        double answerPoints[] = {1, 0, 0.75};
        ql.add(new jpQuestion(questionS, answerPoints, answerArray, 0));

        ArrayList<String> answerArray1 = new ArrayList<String>();
        answerArray1.add("two humans");
        answerArray1.add("four-legged animal");
        answerArray1.add("elephant");
        answerArray1.add("bear");
        answerPoints = new double[4];
        answerPoints[0] = 1;
        answerPoints[1] = 0.25;
        answerPoints[2] = 0.33;
        answerPoints[3] = 0.66;
        ql.add(new jpQuestion(questionS, answerPoints, answerArray1, 1));

        ArrayList<String> answerArray2 = new ArrayList<String>();
        answerArray2.add("two people");
        answerArray2.add("human face");
        answerArray2.add("butterfly");
        answerPoints = new double[3];
        answerPoints[0] = 1;
        answerPoints[1] = 0.75;
        answerPoints[2] = 0.33;
        ql.add(new jpQuestion(questionS, answerPoints, answerArray2, 2));

        ArrayList<String> answerArray3 = new ArrayList<String>();
        answerArray3.add("animal hide");
        answerArray3.add("animal skin");
        answerArray3.add("skin rug");
        answerPoints = new double[3];
        answerPoints[0] = 0.15;
        answerPoints[1] = 0.65;
        answerPoints[2] = 0.30;
        ql.add(new jpQuestion(questionS, answerPoints, answerArray3, 3));

        ArrayList<String> answerArray4 = new ArrayList<String>();
        answerArray4.add("bat");
        answerArray4.add("butterfly");
        answerArray4.add("moth");
        answerPoints = new double[3];
        answerPoints[0] = 0.33;
        answerPoints[1] = 0.99;
        answerPoints[2] = 0.66;
        ql.add(new jpQuestion(questionS, answerPoints, answerArray4, 3));

        ArrayList<String> answerArray5 = new ArrayList<String>();
        answerArray5.add("animal hide");
        answerArray5.add("animal skin");
        answerArray5.add("skin rug");
        answerPoints = new double[3];
        answerPoints[0] = 0.99;
        answerPoints[1] = 0.33;
        answerPoints[2] = 0.66;
        ql.add(new jpQuestion(questionS, answerPoints, answerArray5, 2));

        ArrayList<String> answerArray6 = new ArrayList<String>();
        answerArray6.add("human heads");
        answerArray6.add("faces");
        answerArray6.add("heads of women or children");
        answerPoints = new double[3];
        answerPoints[0] = 0.5;
        answerPoints[1] = 0;
        answerPoints[2] = 1;
        ql.add(new jpQuestion(questionS, answerPoints, answerArray6, 1));

        ArrayList<String> answerArray7 = new ArrayList<String>();
        answerArray7.add("pink four-legged animal");
        answerArray7.add("animal");
        answerArray7.add("some animal other than a cat or a dog");
        answerPoints = new double[3];
        answerPoints[0] = 0.20;
        answerPoints[1] = 0.60;
        answerPoints[2] = 0.40;
        ql.add(new jpQuestion(questionS, answerPoints, answerArray7, 0));

        ArrayList<String> answerArray8 = new ArrayList<String>();
        answerArray8.add("human");
        answerArray8.add("deer");
        answerArray8.add("human organ");
        answerPoints = new double[3];
        answerPoints[0] = 0.1;
        answerPoints[1] = 0.45;
        answerPoints[2] = 0.85;
        ql.add(new jpQuestion(questionS, answerPoints, answerArray8, 3));

        ArrayList<String> answerArray9 = new ArrayList<String>();
        answerArray9.add("crab");
        answerArray9.add("lobster");
        answerArray9.add("blue spider");
        answerArray9.add("rabbit head");
        answerArray9.add("worms");
        answerArray9.add("snakes");
        answerArray9.add("caterpillars");
        answerPoints = new double[7];
        answerPoints[0] = 0.33;
        answerPoints[1] = 0.87;
        answerPoints[2] = 0.66;
        answerPoints[3] = 0.43;
        answerPoints[4] = 0.95;
        answerPoints[5] = 0.34;
        answerPoints[6] = 0.11;
        ql.add(new jpQuestion(questionS, answerPoints, answerArray9, 2));

        return ql;
    }
}