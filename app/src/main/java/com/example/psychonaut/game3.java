package com.example.psychonaut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    TextView questionTV,judgStats,percStats,questionCountTV;
    statsGenerator sg;
    List<jpQuestion> listQ = new ArrayList<jpQuestion>();
    statsGenerator sq;
    ListView listViewAnswers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //listQ.add()

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);
        questionTV = findViewById(R.id.textViewQuestion);
        judgStats=findViewById(R.id.textViewJudgingStats);
        percStats=findViewById(R.id.textViewPercievingStats);
        listViewAnswers=findViewById(R.id.listView);
        judgStats.setText("0%");
        percStats.setText("0%");
        sq = new statsGenerator();
        questionCountTV=findViewById(R.id.textViewKRP);
        questionCountTV.setText(Integer.toString(sq.numberOfQuestionsJP+1)+"/10");
        listQ=getQuestions();
        ArrayList<String> answerAr=new ArrayList<>();
        String questionS = listQ.get(0).question;
        answerAr=listQ.get(0).answers;
        double answerPoints[]=listQ.get(0).points;
        ArrayAdapter<String> answerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,answerAr);
        questionTV.setText(questionS);
        listViewAnswers.setAdapter(answerAdapter);

        jpQuestion questionObject = new jpQuestion(questionS,answerPoints,answerAr);



        listViewAnswers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(sq.numberOfQuestionsJP==9){
                    answerAdapter.clear();
                    questionTV.setText("");
                }
                else {
                    sq.evaluateJP(listQ.get(sq.numberOfQuestionsJP), position);
                    judgStats.setText(Double.toString(Math.round(sq.judgingStats * 100)) + "%");
                    percStats.setText(Double.toString(Math.round(sq.perceivingStats * 100)) + "%");
                    int questionCounter = sq.getNumberOfQuestionsJP();
                    ArrayList<String> answerList = new ArrayList<String>();
                    answerList = listQ.get(questionCounter).answers;
                    answerAdapter.clear();
                    answerAdapter.addAll(answerList);
                    questionTV.setText(listQ.get(questionCounter).question);
                    listViewAnswers.setAdapter(answerAdapter);
                    questionCountTV.setText(Integer.toString(sq.numberOfQuestionsJP + 1) + "/10");
                }
            }
        });

    }

    public void goToMainAct(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
    public List<jpQuestion> getQuestions(){
        List<jpQuestion> ql = new ArrayList<jpQuestion>();
        ArrayList<String> answerArray= new ArrayList<String>();
        String questionS = "??yi bir planc?? m??s??n?";
        answerArray.add("Evet, ??nceden plan yapabilirim ve takip etmekte sorun ya??amam.");
        answerArray.add("Hay??r, genelde planlar??m?? de??i??tiririm.");
        double answerPoints[]={1,0};
        ql.add(new jpQuestion(questionS,answerPoints,answerArray));

        questionS=" 12-16 ya??lar??nda okulda ge??irdi??in zamana dair ne hat??rl??yorsun?";
        ArrayList<String> answerArray1 = new ArrayList<String>();
        answerArray1.add("??al????kan bir ??ocuktum, her zaman i??imi zaman??nda yapard??m.");
        answerArray1.add(" Biraz tembeldim.");
        answerArray1.add(" Okul umurumda de??ildi");
        answerPoints=new double[3];
        answerPoints[0]=1;
        answerPoints[1]=0.25;
        answerPoints[0]=0;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray1));


        questionS=" Araban??z/eviniz/masan??z genellikle ??ok d??zensiz mi yoksa her ??eyi d??zenli tutmak biraz irade mi gerektiriyor? ";
        ArrayList<String> answerArray2 = new ArrayList<String>();
        answerArray2.add("Do??al olarak d??zenliyim");
        answerArray2.add("Do??al olarak d??zensizim");
        answerPoints=new double[2];
        answerPoints[0]=1;
        answerPoints[1]=0;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray2));

        questionS="Ki??ili??inize en uygun tan??m hangisi?";
        ArrayList<String> answerArray3 = new ArrayList<String>();
        answerArray3.add("Rahat ve ??ok resmi de??il");
        answerArray3.add(" Tam zaman??nda ve kitab??na g??re resmi");
        answerPoints=new double[2];
        answerPoints[0]=0;
        answerPoints[1]=1;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray3));

        questionS="H??zl?? karar vermeyi mi yoksa farkl?? y??nlerden bakmak i??in zaman ay??rmay?? m?? seversiniz?";
        ArrayList<String> answerArray4 = new ArrayList<String>();
        answerArray4.add(" H??zl??, bazen d??rt??sel kararlar veririm. Ald??????m her karardan eminim.");
        answerArray4.add(" ??ok zaman alabilecek mant??kl??, d??????n??lm???? kararlar veririm (ama her zaman do??ru olan??).");
        answerPoints=new double[2];
        answerPoints[0]=0;
        answerPoints[1]=1;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray4));

        questionS=" Genelde toplant??lara ve randevulara ge?? kal??r??m.";
        ArrayList<String> answerArray5 = new ArrayList<String>();
        answerArray5.add(" Do??ru");
        answerArray5.add(" Yanl????.");
        answerPoints=new double[2];
        answerPoints[0]=0;
        answerPoints[1]=1;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray5));

        questionS=" Men??n??n ne olaca????n??n fark??nda olmay?? ve d????ar?? ????kacaksak sipari??imi ??nceden kararla??t??rmay?? seviyorum.";
        ArrayList<String> answerArray6 = new ArrayList<String>();
        answerArray6.add(" Do??ru");
        answerArray6.add(" Yanl????.");
        answerPoints=new double[2];
        answerPoints[0]=1;
        answerPoints[1]=0;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray6));

        questionS="Bir se??enek verilirse ??unu tercih ederim:";
        ArrayList<String> answerArray7 = new ArrayList<String>();
        answerArray7.add("??al????kan bir ??ocuktum, her zaman i??imi zaman??nda yapard??m.");
        answerArray7.add(" Planlar?? yap??n ama e??lenmek i??in fazla zaman??m yok");
        answerPoints=new double[2];
        answerPoints[0]=1;
        answerPoints[1]=0;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray7));

        questionS="Genelde a??a????dakilere dayanarak kararlar veririm:";
        ArrayList<String> answerArray8 = new ArrayList<String>();
        answerArray8.add("i??imdeki his");
        answerArray8.add("Somut kan??t");
        answerPoints=new double[2];
        answerPoints[0]=0;
        answerPoints[1]=1;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray8));

        questionS="Genelde ??unlar?? yapmay?? severim:";
        ArrayList<String> answerArray9 = new ArrayList<String>();
        answerArray9.add("Ak??????na b??rak");
        answerArray9.add("Plana sad??k kal");
        answerPoints=new double[2];
        answerPoints[0]=0;
        answerPoints[1]=1;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray9));

        return ql;
    }
}