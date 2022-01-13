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
    int questionCounter = 0;
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
        questionCountTV.setText(Integer.toString(sq.numberOfQuestions+1)+"/10");
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
                if(sq.numberOfQuestions==9){
                    answerAdapter.clear();
                    questionTV.setText("");
                }
                else {
                    sq.evaluate(listQ.get(sq.numberOfQuestions), position);
                    judgStats.setText(Double.toString(Math.round(sq.judgingStats * 100)) + "%");
                    percStats.setText(Double.toString(Math.round(sq.perceivingStats * 100)) + "%");
                    int questionCounter = sq.getNumberOfQuestions();
                    ArrayList<String> answerList = new ArrayList<String>();
                    answerList = listQ.get(questionCounter).answers;
                    answerAdapter.clear();
                    answerAdapter.addAll(answerList);
                    questionTV.setText(listQ.get(questionCounter).question);
                    listViewAnswers.setAdapter(answerAdapter);
                    questionCountTV.setText(Integer.toString(sq.numberOfQuestions + 1) + "/10");
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
        String questionS = "İyi bir plancı mısın?";
        answerArray.add("Evet, önceden plan yapabilirim ve takip etmekte sorun yaşamam.");
        answerArray.add("Hayır, genelde planlarımı değiştiririm.");
        double answerPoints[]={1,0};
        ql.add(new jpQuestion(questionS,answerPoints,answerArray));

        questionS=" 12-16 yaşlarında okulda geçirdiğin zamana dair ne hatırlıyorsun?";
        ArrayList<String> answerArray1 = new ArrayList<String>();
        answerArray1.add("Çalışkan bir çocuktum, her zaman işimi zamanında yapardım.");
        answerArray1.add(" Biraz tembeldim.");
        answerArray1.add(" Okul umurumda değildi");
        answerPoints=new double[3];
        answerPoints[0]=1;
        answerPoints[1]=0.25;
        answerPoints[0]=0;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray1));


        questionS=" Arabanız/eviniz/masanız genellikle çok düzensiz mi yoksa her şeyi düzenli tutmak biraz irade mi gerektiriyor? ";
        ArrayList<String> answerArray2 = new ArrayList<String>();
        answerArray2.add("Doğal olarak düzenliyim");
        answerArray2.add("Doğal olarak düzensizim");
        answerPoints=new double[2];
        answerPoints[0]=1;
        answerPoints[1]=0;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray2));

        questionS="Kişiliğinize en uygun tanım hangisi?";
        ArrayList<String> answerArray3 = new ArrayList<String>();
        answerArray3.add("Rahat ve çok resmi değil");
        answerArray3.add(" Tam zamanında ve kitabına göre resmi");
        answerPoints=new double[2];
        answerPoints[0]=0;
        answerPoints[1]=1;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray3));

        questionS="Hızlı karar vermeyi mi yoksa farklı yönlerden bakmak için zaman ayırmayı mı seversiniz?";
        ArrayList<String> answerArray4 = new ArrayList<String>();
        answerArray4.add(" Hızlı, bazen dürtüsel kararlar veririm. Aldığım her karardan eminim.");
        answerArray4.add(" Çok zaman alabilecek mantıklı, düşünülmüş kararlar veririm (ama her zaman doğru olanı).");
        answerPoints=new double[2];
        answerPoints[0]=0;
        answerPoints[1]=1;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray4));

        questionS=" Genelde toplantılara ve randevulara geç kalırım.";
        ArrayList<String> answerArray5 = new ArrayList<String>();
        answerArray5.add(" Doğru");
        answerArray5.add(" Yanlış.");
        answerPoints=new double[2];
        answerPoints[0]=0;
        answerPoints[1]=1;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray5));

        questionS=" Menünün ne olacağının farkında olmayı ve dışarı çıkacaksak siparişimi önceden kararlaştırmayı seviyorum.";
        ArrayList<String> answerArray6 = new ArrayList<String>();
        answerArray6.add(" Doğru");
        answerArray6.add(" Yanlış.");
        answerPoints=new double[2];
        answerPoints[0]=1;
        answerPoints[1]=0;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray6));

        questionS="Bir seçenek verilirse şunu tercih ederim:";
        ArrayList<String> answerArray7 = new ArrayList<String>();
        answerArray7.add("Çalışkan bir çocuktum, her zaman işimi zamanında yapardım.");
        answerArray7.add(" Planları yapın ama eğlenmek için fazla zamanım yok");
        answerPoints=new double[2];
        answerPoints[0]=1;
        answerPoints[1]=0;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray7));

        questionS="Genelde aşağıdakilere dayanarak kararlar veririm:";
        ArrayList<String> answerArray8 = new ArrayList<String>();
        answerArray8.add("içimdeki his");
        answerArray8.add("Somut kanıt");
        answerPoints=new double[2];
        answerPoints[0]=0;
        answerPoints[1]=1;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray8));

        questionS="Genelde şunları yapmayı severim:";
        ArrayList<String> answerArray9 = new ArrayList<String>();
        answerArray9.add("Akışına bırak");
        answerArray9.add("Plana sadık kal");
        answerPoints=new double[2];
        answerPoints[0]=0;
        answerPoints[1]=1;
        ql.add(new jpQuestion(questionS,answerPoints,answerArray9));

        return ql;
    }
}