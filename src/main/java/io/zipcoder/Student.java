package io.zipcoder;

public class Student {
    private String firstName;
    private String lastName;
    private int[] testScores;
    // These are helper methods to assist us with array operations.
    private int totalExams;
    private int examsTaken;

    /**
     * Constructor for a student with just their first and last name.
     * You must make a default amount of tests here.
     * @param firstName
     * @param lastName
     */
    public Student(String firstName, String lastName) {

    }

    /**
     * How we're going to construct our students when we know how many tests they're going to take
     * @param firstName
     * @param lastName
     * @param totalExams
     */
    public Student(String firstName, String lastName, int totalExams) {

    }

    public String getFirstName() {
        return null;
    }

    public void setFirstName(String firstName) {

    }

    public String getLastName() {
        return null;
    }

    public void setLastName(String lastName) {

    }

    public int getTotalExams() {
        return 0;
    }

    public void setTotalExams(int totalExams) {

    }

    public int getExamsTaken() {
        return 0;
    }


    /**
     * What we want here is a string that, if a student hasn't taken any tests, returns a `no tests taken` string.
     * Otherwise, we want to return something kind of like:
     * Test Scores:
     * Test 1 -> 100
     * Test 2 -> 89
     * Test 3 -> 54
     * @return The test scores in a nice string representation.
     */
    public String printExamScores() {
        return null;
    }

    /**
     * This function should add the grade in the correct position in the testScores array.
     * Make sure the score is between 0 and 100, and that the student isn't taking more tests than they're supposed to.
     * If there is a problem, print an error message and return false.
     * Otherwise, return true and put the score in the right spot.
     * @param score
     * @return A boolean based on if the operation worked or not.
     */
    public boolean takeExam(int score) {
        return false;
    }

    /**
     * Change the score for one of the students tests.
     * Be aware that the new score must be between 0 and 100, and that they have already taken that test
     * since it doesn't make sense to change the grade on an exam that they haven't taken it.
     * @param examNum Which test the we want to change.
     * @param newScore What we want to change it to.
     * @return A boolean based on if the operation worked or not.
     */
    public boolean changeScoreForExam(int examNum, int newScore){
        return false;
    }

    /**
     * Return the average for all of the exams that the student has taken.
     * If they haven't taken any, be nice and give them 100.0.
     * @return The average for all the exams a student has taken.
     */
    public double getAverage() {
        return 100.0;
    }
}
