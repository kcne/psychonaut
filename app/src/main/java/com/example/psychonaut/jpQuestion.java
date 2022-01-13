package com.example.psychonaut;

import java.util.ArrayList;

public class jpQuestion {
    String question;

    public jpQuestion(String question, double[] points, ArrayList<String> answers) {
        this.question = question;
        this.points = points;
        this.answers = answers;
    }

    public double[] getPoints() {
        return points;
    }

    public void setPoints(double[] points) {
        this.points = points;
    }

    double points[];




    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    ArrayList<String> answers = new ArrayList<String>();



    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


}
