package io.zipcoder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class Student {

    private String firstName;
    private String lastName;

    private ArrayList<Double> examScores = new ArrayList<>();

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        examScores = new ArrayList<Double>(Arrays.asList(testScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExamScores() {
        String box = "Exam Scores:";
        for (int i = 0; i < this.examScores.size(); i++) {
            box += String.format("\n\tExam %d -> %2.0f",i + 1,examScores.get(i));
        }
        return box;
    }

    public void addExamScore(double v) {
        examScores.add(v);
    }

    public void setExamScore(int i, double v) {
        examScores.set(i-1,v);
    }


    public double getAverageExamScore() {
        return examScores
                .stream()
                .mapToDouble( (x) -> x)
                .summaryStatistics()
                .getAverage();
    }

    @Override
    public String toString() {
        return    "\t\tStudent Name: " + firstName + " " + lastName
                + String.format("\n\t\t> Average Score: %-1.0f",getAverageExamScore())
                + "\n\t " + getExamScores();
    }



}
