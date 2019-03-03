package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void getExamScoresTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = student.getExamScores();

        // Then
//        System.out.println(output);
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 95\n" +
                "\tExam 3 -> 123\n" +
                "\tExam 4 -> 96";
        Assert.assertEquals(expected,output);
    }

    @Test
    public void addExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { };
        Student student = new Student(firstName, lastName, examScores);

// When
        student.addExamScore(100.0);
        String output = student.getExamScores();

// Then
        System.out.println(output);
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 100";
        Assert.assertEquals(expected,output);
    }
//
    @Test
    public void setExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
        Student student = new Student(firstName, lastName, examScores);

// When
        student.setExamScore(1, 150.0);
        String output = student.getExamScores();

// Then
        System.out.println(output);
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 150";
        Assert.assertEquals(expected,output);
    }

    @Test
    public void getAverageExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, Double.valueOf(0)};
        Student student = new Student(firstName, lastName, examScores);

        // When
        double output = student.getAverageExamScore();

        // Then
        Double expected = 125.0;

        Assert.assertEquals(output,expected,0.0);
    }

    @Test
    public void toStringTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = student.toString();

        // Then
        System.out.println(output);

        String expected = "\t\tStudent Name: Leon Hunter\n" +
                "\t\t> Average Score: 125\n" +
                "\t Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 150\n" +
                "\tExam 3 -> 250\n" +
                "\tExam 4 ->  0";
        Assert.assertEquals(output,expected);
    }

}