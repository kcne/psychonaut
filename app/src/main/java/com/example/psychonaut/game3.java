package com.example.psychonaut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class game3 extends AppCompatActivity {

    TextView questionTV, judgStats, percStats, questionCountTV;
    statsGenerator sg;
    List<jpQuestion> listQ = new ArrayList<jpQuestion>();
    statsGenerator sq;
    ListView listViewAnswers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //listQ.add()
        SharedPreferences preferences = getSharedPreferences("settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);
        questionTV = findViewById(R.id.textViewQuestion);
        judgStats = findViewById(R.id.textViewJudgingStats);
        percStats = findViewById(R.id.textViewPercievingStats);
        listViewAnswers = findViewById(R.id.listView);
        judgStats.setText("");
        percStats.setText("");
        sg = new statsGenerator();
        questionCountTV = findViewById(R.id.textViewKRP);


        questionTV.setText("You sucesfully completed personality quiz!");
        listQ = getQuestions();
        ArrayList<String> answerAr = new ArrayList<>();
        int qc = preferences.getInt("Game3C", 0);

        String questionS = listQ.get(qc).question;
        sg.numberOfQuestionsGlobal = qc;
        editor.apply();
        answerAr = listQ.get(qc).answers;
        double answerPoints[] = listQ.get(qc).points;
        ArrayAdapter<String> answerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, answerAr);
        boolean comp = preferences.getBoolean("Game3Completed", false);
        editor.apply();
        if (comp) {
            questionTV.setText("You sucessfully completed the personality quiz!");
            questionCountTV.setText("");
        } else {
            questionTV.setText(questionS);
            listViewAnswers.setAdapter(answerAdapter);
            questionCountTV.setText(Integer.toString(qc + 1) + "/10");
        }

        listViewAnswers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (sg.numberOfQuestionsGlobal == 9) {
                    answerAdapter.clear();
                    questionTV.setText("You successfully completed the personality quiz!");
                    SharedPreferences preferences = getSharedPreferences("settings", MODE_PRIVATE);
                    editor.putInt("Game3C", sg.numberOfQuestionsGlobal);
                    editor.putBoolean("Game3Completed", true);
                    editor.apply();
                    questionCountTV.setText(Integer.toString(preferences.getInt("Game3C", 0) + 1) + "/10");
                    //
                } else {

                    switch (listQ.get(sg.numberOfQuestionsGlobal).questionType) {
                        case 0:
                            sg.evaluateIE(listQ.get(sg.numberOfQuestionsGlobal), position);
                            editor.putInt("numberOfQuestionsIE", sg.numberOfQuestionsIE);
                            editor.putFloat("Introverted", Math.round(sg.introvertStats * 100));
                            editor.putFloat("Extroverted", Math.round(100 - sg.introvertStats * 100));
                            editor.apply();
                            int questionCounter = sg.getNumberOfQuestionsGlobal();
                            ArrayList<String> answerList = new ArrayList<String>();
                            answerList = listQ.get(questionCounter).answers;
                            answerAdapter.clear();
                            answerAdapter.addAll(answerList);
                            listViewAnswers.setAdapter(answerAdapter);
                            questionCountTV.setText(Integer.toString(sg.numberOfQuestionsGlobal + 1) + "/10");
                            questionTV.setText(listQ.get(questionCounter).question);
                            break;  //optional
                        case 1:
                            sg.evaluateIS(listQ.get(sg.numberOfQuestionsGlobal), position);
                            editor.putInt("numberOfQuestionsIS", sg.numberOfQuestionsIS);
                            editor.putFloat("Intuitive", Math.round(sg.intuitiveStats * 100));
                            editor.putFloat("Sensor", Math.round(100 - sg.intuitiveStats * 100));
                            editor.apply();
                            questionCounter = sg.getNumberOfQuestionsGlobal();
                            ArrayList<String> answerList1 = new ArrayList<String>();
                            answerList1 = listQ.get(questionCounter).answers;
                            answerAdapter.clear();
                            answerAdapter.addAll(answerList1);
                            listViewAnswers.setAdapter(answerAdapter);
                            questionCountTV.setText(Integer.toString(sg.numberOfQuestionsGlobal + 1) + "/10");
                            questionTV.setText(listQ.get(questionCounter).question);
                            break;  //optional
                        case 2:
                            sg.evaluateTF(listQ.get(sg.numberOfQuestionsGlobal), position);
                            editor.putInt("numberOfQuestionsTF", sg.numberOfQuestionsTF);
                            editor.putFloat("Thinker", Math.round(sg.thinkerStats * 100));
                            editor.putFloat("Feeler", Math.round(100 - sg.thinkerStats * 100));
                            editor.apply();
                            questionCounter = sg.getNumberOfQuestionsGlobal();
                            ArrayList<String> answerList2 = new ArrayList<String>();
                            answerList2 = listQ.get(questionCounter).answers;
                            answerAdapter.clear();
                            answerAdapter.addAll(answerList2);
                            listViewAnswers.setAdapter(answerAdapter);
                            questionCountTV.setText(Integer.toString(sg.numberOfQuestionsGlobal + 1) + "/10");
                            questionTV.setText(listQ.get(questionCounter).question);
                            break;  //optional
                        case 3:
                            sg.evaluateJP(listQ.get(sg.numberOfQuestionsGlobal), position);
                            editor.putInt("numberOfQuestionsJP", sg.numberOfQuestionsJP);
                            editor.putFloat("Judging", Math.round(sg.thinkerStats * 100));
                            editor.putFloat("Perceiving", Math.round(100 - sg.thinkerStats * 100));
                            editor.apply();
                            questionCounter = sg.getNumberOfQuestionsGlobal();
                            ArrayList<String> answerList3 = new ArrayList<String>();
                            answerList3 = listQ.get(questionCounter).answers;
                            answerAdapter.clear();
                            answerAdapter.addAll(answerList3);
                            listViewAnswers.setAdapter(answerAdapter);
                            questionTV.setText(listQ.get(questionCounter).question);

                            break;  //optional
                        default:
                            //code to be executed if all cases are not matched;
                    }
                }
                SharedPreferences preferences = getSharedPreferences("settings", MODE_PRIVATE);
                editor.putInt("Game3C", sg.numberOfQuestionsGlobal);
                editor.apply();
                questionCountTV.setText(Integer.toString(preferences.getInt("Game3C", 0) + 1) + "/10");

            }
        });

    }

    public void goToMainAct(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public List<jpQuestion> getQuestions() {
        List<jpQuestion> ql = new ArrayList<jpQuestion>();
        ArrayList<String> answerArray = new ArrayList<String>();
        String questionS = "At a party do you:";
        answerArray.add("Interact with many, including strangers");
        answerArray.add("Interact with a few, known to you");
        double answerPoints[] = {0.25, 0.75};
        ql.add(new jpQuestion(questionS, answerPoints, answerArray, 0));

        ArrayList<String> answerArray1 = new ArrayList<String>();
        questionS = "Are you more:";
        answerArray1.add("Realistic than speculative");
        answerArray1.add("Speculative than realistic");
        answerPoints = new double[3];
        answerPoints[0] = 0.75;
        answerPoints[1] = 0.25;
        ql.add(new jpQuestion(questionS, answerPoints, answerArray1, 1));

        ArrayList<String> answerArray2 = new ArrayList<String>();
        questionS = "Are you more impressed by:";
        answerArray2.add("Principles");
        answerArray2.add("Emotions");
        answerPoints = new double[3];
        answerPoints[0] = 0.75;
        answerPoints[1] = 0.25;
        ql.add(new jpQuestion(questionS, answerPoints, answerArray2, 2));

        ArrayList<String> answerArray3 = new ArrayList<String>();
        questionS = "Do you prefer to work:";
        answerArray3.add("To deadlines");
        answerArray3.add("Just “whenever”");
        answerPoints = new double[3];
        answerPoints[0] = 0.75;
        answerPoints[1] = 0.25;
        ql.add(new jpQuestion(questionS, answerPoints, answerArray3, 3));

        ArrayList<String> answerArray4 = new ArrayList<String>();
        questionS = "Do you tend to choose:";
        answerArray4.add("Rather carefully");
        answerArray4.add("Somewhat impulsively");
        answerPoints = new double[3];
        answerPoints[0] = 0.75;
        answerPoints[1] = 0.25;
        ql.add(new jpQuestion(questionS, answerPoints, answerArray4, 3));

        ArrayList<String> answerArray5 = new ArrayList<String>();
        questionS = "Facts:";
        answerArray5.add("Speak for themselves");
        answerArray5.add("Illustrate principles");
        answerPoints = new double[3];
        answerPoints[0] = 0.75;
        answerPoints[1] = 0.25;
        ql.add(new jpQuestion(questionS, answerPoints, answerArray5, 1));

        ArrayList<String> answerArray6 = new ArrayList<String>();
        questionS = "Writers should:";
        answerArray6.add("Say what they mean and mean what they say");
        answerArray6.add("Express things more by use of analogy");
        answerPoints = new double[3];
        answerPoints[0] = 0.75;
        answerPoints[1] = 0.25;
        ql.add(new jpQuestion(questionS, answerPoints, answerArray6, 1));

        ArrayList<String> answerArray7 = new ArrayList<String>();
        questionS = "Do you go more by:";
        answerArray7.add("facts");
        answerArray7.add("principles");
        answerPoints = new double[3];
        answerPoints[0] = 0.75;
        answerPoints[1] = 0.25;
        ql.add(new jpQuestion(questionS, answerPoints, answerArray7, 3));

        ArrayList<String> answerArray8 = new ArrayList<String>();
        questionS = "Which is more satisfying:";
        answerArray8.add("to discuss an issue thoroughly");
        answerArray8.add("to arrive at agreement on an issue");
        answerPoints = new double[3];
        answerPoints[0] = 0.75;
        answerPoints[1] = 0.25;
        ql.add(new jpQuestion(questionS, answerPoints, answerArray8, 2));

        ArrayList<String> answerArray9 = new ArrayList<String>();
        questionS = "Are you more interested in:";
        answerArray9.add("production and distribution");
        answerArray9.add("design and research");
        answerPoints = new double[3];
        answerPoints[0] = 0.75;
        answerPoints[1] = 0.25;

        ql.add(new jpQuestion(questionS, answerPoints, answerArray9, 1));
        return ql;
    }

    public void resetAll() {
        SharedPreferences preferences = getSharedPreferences("settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("Game3C", 0);
        editor.putBoolean("Game3Completed", false);
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