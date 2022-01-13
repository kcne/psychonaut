package com.example.psychonaut;

public class statsGenerator {
    int numberOfQuestions=0;
    double judgingC=0;
    double perceivingC=0;
    double judgingStats=0;
    double perceivingStats=0;

    public statsGenerator() {
    }

    public void evaluate(double answerArray[],int answer){
        numberOfQuestions++;
        judgingC=answerArray[answer];
        perceivingC+=perceivingC+(1-answerArray[answer]);

        judgingStats=judgingC*(100/numberOfQuestions);
        perceivingStats=perceivingC*(100/numberOfQuestions);
    }
    public void evaluate(jpQuestion question,int answer) {
        numberOfQuestions++;
        if(numberOfQuestions==1){
            judgingStats=question.points[answer];
            perceivingStats=1-question.points[answer];
        }
        else{
            judgingStats=(judgingStats+question.points[answer])/numberOfQuestions;
            perceivingStats=1-judgingStats;
        }
    }
    public int getNumberOfQuestions() {
        return numberOfQuestions;
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
