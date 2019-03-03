package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ClassroomTest {


    @Test
    public void getAverageExamScoreTest(){
        // : Given
        Double expected = 125.0;
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = new Student[]{s1, s2};

        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScore();

        // Then
//        System.out.println(output);
        Assert.assertEquals(output,expected,0);
    }

    @Test
    public void addStudentTest(){
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }

    @Test
    public void removeStudentTest() {
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };
        Double[] s3Scores = { 115.0, 25.0 };

        Student s1 = new Student("Francisco", "Castro",s2Scores);
        Student s2 = new Student("Leon", "Hunter",s1Scores);
        Student s3 = new Student("Emiliano", "Zapata",s3Scores);
        Student s4 = new Student("Ponciano", "Ven",s1Scores);
        Student s5 = new Student("Robert", "Cazares",s1Scores);


        Student[] students = new Student[]{s1,s2,s3,s4,s5};
//
        Classroom classroom = new Classroom(students);
        classroom.removeStudent("Emiliano","Zapata");

//        classroom.removeStudent("Leon","Hunter");

        Student[] retrievedStudents = classroom.getStudents();

        String output = Arrays.asList(retrievedStudents).toString();
//
//        System.out.println(Arrays.asList( retrievedStudents ) );

        String expected = "[\t\tStudent Name: Francisco Castro\n" +
                "\t\t> Average Score: 125\n" +
                "\t Exam Scores:\n" +
                "\tExam 1 -> 225\n" +
                "\tExam 2 -> 25, \t\tStudent Name: Leon Hunter\n" +
                "\t\t> Average Score: 125\n" +
                "\t Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 150, \t\tStudent Name: Ponciano Ven\n" +
                "\t\t> Average Score: 125\n" +
                "\t Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 150, \t\tStudent Name: Robert Cazares\n" +
                "\t\t> Average Score: 125\n" +
                "\t Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 150, null]";
        Assert.assertEquals(expected,output);
    }

    @Test
    public void getStudentByScore(){
        Double[] s1Scores = { 200.0, 200.0 };
        Double[] s2Scores = { 100.0, 100.0 };
        Double[] s3Scores = { 300.0, 300.0 };
        Double[] s4Scores = { 300.0, 300.0 };

        Student s1 = new Student("Francisco", "Castro",s1Scores);
        Student s2 = new Student("Leon", "Hunter",s2Scores);
        Student s3 = new Student("Emiliano", "Zapata",s3Scores);
        Student s4 = new Student("Albert", "Deal",s4Scores);

        Student[] students = new Student[]{s1,s2,s3,s4};

        Classroom classroom = new Classroom(students);

        classroom.getStudentsByScore();

    }

    @Test
    public void getGradeBookTest(){
        // 400(1), 600(3), 700(2), 750(1), 900(2), 1000(1)
        // A(10), B(11-29), C(30-50), D(51-89), F(11)
        // A(10), B(18), C(20), D(38), F(11)
        Double[]  s1Scores = { 1000.0, 1000.0 };
        Double[]  s2Scores = {  900.0,  900.0 };
        Double[]  s3Scores = {  700.0,  700.0 };
        Double[]  s4Scores = {  600.0,  600.0 };
        Double[]  s5Scores = {  700.0,  700.0 };
        Double[]  s6Scores = {  200.0,  200.0 };
        Double[]  s7Scores = {  900.0,  900.0 };
        Double[]  s8Scores = {  750.0,  750.0 };
        Double[]  s9Scores = {  600.0,  600.0 };
        Double[] s10Scores = {  600.0,  600.0 };

        Student  s1 = new Student("Name1", "LastName1",   s1Scores);
        Student  s2 = new Student("Name2", "LastName2",   s2Scores);
        Student  s3 = new Student("Name3", "LastName3",   s3Scores);
        Student  s4 = new Student("Name4", "LastName4",   s4Scores);
        Student  s5 = new Student("Name5", "LastName5",   s5Scores);
        Student  s6 = new Student("Name6", "LastName6",   s6Scores);
        Student  s7 = new Student("Name7", "LastName7",   s7Scores);
        Student  s8 = new Student("Name8", "LastName8",   s8Scores);
        Student  s9 = new Student("Name9", "LastName9",   s9Scores);
        Student s10 = new Student("Name10", "LastName10",s10Scores);

        Student[] students = new Student[]{s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};

        Classroom classroom = new Classroom(students);

        classroom.getGradeBook();
    }

}
