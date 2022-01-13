package com.example.psychonaut;

public class statsGenerator {
    public int getNumberOfQuestionsJP() {
        return numberOfQuestionsJP;
    }

    int numberOfQuestionsJP=0;
    int numberOfQuestionsIE=0;
    int numberOfQuestionsIS=0;
    int numberOfQuestionsTF=0;
    int numberOfQuestionsGlobal=0;
    double judgingC=0;
    double perceivingC=0;
    double judgingStats=0;
    double perceivingStats=0;
    double introvertStats=0;
    double intuitiveStats=0;
    double thinkerStats=0;

    public statsGenerator() {
    }

    public int getNumberOfQuestionsGlobal() {
        return numberOfQuestionsGlobal;
    }

    public void evaluate(double answerArray[], int answer){
        numberOfQuestionsJP++;
        judgingC=answerArray[answer];
        perceivingC+=perceivingC+(1-answerArray[answer]);

        judgingStats=judgingC*(100/numberOfQuestionsJP);
        perceivingStats=perceivingC*(100/numberOfQuestionsJP);
        numberOfQuestionsGlobal++;
    }
    public void evaluateJP(jpQuestion question,int answer) {
        numberOfQuestionsJP++;
        if(numberOfQuestionsJP==1){
            judgingStats=question.points[answer];
            perceivingStats=1-question.points[answer];
        }
        else{
            judgingStats=(judgingStats+question.points[answer])/numberOfQuestionsJP;
            perceivingStats=1-judgingStats;
        }
        numberOfQuestionsGlobal++;
    }
    public void evaluateIE(double pointsArr[],int answer){
        numberOfQuestionsIE++;
        if(numberOfQuestionsIE==1){
            introvertStats=pointsArr[answer];
        }
        else{
            introvertStats=(introvertStats+pointsArr[answer])/numberOfQuestionsIE;
        }
        numberOfQuestionsGlobal++;
    }
    public void evaluateIE(jpQuestion question,int answer) {
        numberOfQuestionsIE++;
        if(numberOfQuestionsIE==1){
            introvertStats=question.points[answer];
        }
        else{
            introvertStats=(introvertStats+question.points[answer])/numberOfQuestionsIE;
        }
        numberOfQuestionsGlobal++;
    }
    public void evaluateIS(double pointsArr[],int answer){
        numberOfQuestionsIS++;
        if(numberOfQuestionsIS==1){
            intuitiveStats=pointsArr[answer];
        }
        else{
            intuitiveStats=(intuitiveStats+pointsArr[answer])/numberOfQuestionsIS;
        }
        numberOfQuestionsGlobal++;
    }
    public void evaluateIS(jpQuestion question,int answer) {
        numberOfQuestionsIS++;
        if(numberOfQuestionsIS==1){
            intuitiveStats=question.points[answer];
        }
        else{
            intuitiveStats=(intuitiveStats+question.points[answer])/numberOfQuestionsIS;
        }
        numberOfQuestionsGlobal++;
    }
    public void evaluateTF(double pointsArr[],int answer){
        numberOfQuestionsTF++;
        if(numberOfQuestionsTF==1){
            thinkerStats=pointsArr[answer];
        }
        else{
            thinkerStats=(thinkerStats+pointsArr[answer])/numberOfQuestionsTF;
        }
        numberOfQuestionsGlobal++;
    }
    public void evaluateTF(jpQuestion question,int answer) {
        numberOfQuestionsTF++;
        if(numberOfQuestionsTF==1){
            thinkerStats=question.points[answer];
        }
        else{
            thinkerStats=(intuitiveStats+question.points[answer])/numberOfQuestionsTF;
        }
        numberOfQuestionsGlobal++;
    }


    public double getJudgingC() {
        return judgingC;
    }

    public double getPerceivingC() {
        return perceivingC;
    }

    public double getJudgingStats() {
        return judgingStats*100;
    }

    public double getPerceivingStats() {
        return perceivingStats*100;
    }
}
