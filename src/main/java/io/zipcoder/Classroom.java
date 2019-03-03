package io.zipcoder;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import com.sun.tools.javac.util.ArrayUtils;

import java.security.Key;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Classroom {

    Student[] students;

    public Classroom() {
        this.students = new Student[30];
    }


    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom(int maxNumberOfStudents) {
        students = new Student[maxNumberOfStudents];
    }

    public Student[] getStudents() {
        return students;
    }

    public double getAverageExamScore() {
        return Arrays.stream(students)
                .mapToDouble( (x) -> x.getAverageExamScore() )
                .summaryStatistics()
                .getAverage();
    }
    public void addStudent(Student student){
        students = new Student[]{student};
    }

    public void removeStudent(String firstName, String lastName){
        Student[] result = new Student[students.length];

        for (int i = 0; i < students.length; i++) {
            if (students[i].getFirstName() == firstName && students[i].getLastName() == lastName) {
                System.arraycopy(students,0,result,0,i);
                System.arraycopy(students,i+1,result,i,students.length-i-1);
                break;
            }
        }
        System.arraycopy(result,0,students,0,result.length);
    }

    public Student[] getStudentsByScore(){
        Comparator<Student> comparator = Comparator
                .comparing(student -> student.getAverageExamScore());
        comparator = comparator
                .thenComparing(Comparator.comparing(student -> student.getFirstName()));

        Stream<Student> finalList = Arrays.asList(students)
                .stream()
                .sorted(comparator);

        finalList.forEach(System.out::println);

        return null;
    }

    public String getGradeBook() {
        // A(10), B(11-29), C(30-50), D(51-89), F(11)
        // A(10), B(18), C(20), D(38), F(11)
        // 750
        Double average = getAverageExamScore();
        Double max = Arrays.asList(students)
                .stream()
                .mapToDouble(x -> x.getAverageExamScore())
                .summaryStatistics()
                .getMax();
        Double min = Arrays.asList(students)
                .stream()
                .mapToDouble(x -> x.getAverageExamScore())
                .summaryStatistics()
                .getMin();
        Double sum = Arrays.asList(students)
                .stream()
                .mapToDouble(x -> x.getAverageExamScore())
                .summaryStatistics()
                .getSum();
        Double sd = Arrays.asList(students)
                .stream()
                .mapToDouble(x -> Math.pow(x.getAverageExamScore() - getAverageExamScore(),2) )
                .summaryStatistics()
                .getSum();
        System.out.println("---" + sd );
        sd = Math.sqrt(sd / students.length);


        System.out.println( "Average " + average);
        System.out.println( "Max: " + max);
        System.out.println( "Min: " + min);

        System.out.println( "Sum: " + sum );
        System.out.println("SD: " + sd );
        System.out.println("-----");
        Double rF = 200 + ( 12 * (max-min)) / 100 ;
        Double rD = rF + ( 38 * (max-min)) / 100;
        Double rC = rD + ( 20 * (max-min)) / 100;
        Double rB = rC + ( 18 * (max-min)) / 100;
        Double rA = rB + ( 10 * (max-min)) / 100;

        System.out.println(rF + " " + rD + " "  + rC + " "  + rB + " "  + rA);
        Map<String,String> map = new HashMap<>();

        Arrays.asList(students)
                .stream()
                .forEach(e -> map.put(e.getFirstName(),
                        String.format( (e.getAverageExamScore() >= rA) && (e.getAverageExamScore() <= 1000.0) ? "A" : "" )
                                + String.format( (e.getAverageExamScore() >= rB) && (e.getAverageExamScore() < rA) ? "B" : "" )
                                + String.format( (e.getAverageExamScore() >= rC) && (e.getAverageExamScore() < rB) ? "C" : "" )
                                + String.format( (e.getAverageExamScore() >= rD) && (e.getAverageExamScore() < rC) ? "D" : "" )
                                + String.format( (e.getAverageExamScore() >= 0) && (e.getAverageExamScore() < rD) ? "F" : "" )));


        System.out.println(map.entrySet());

        return "";
    }


}
