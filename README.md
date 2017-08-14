# Classroom Objects Lab
For this lab, we're going to create a Classroom class.  But first, since a classroom without any possible students
sounds like it belongs in a spooky abandoned school, we need to create Students.

Also, be certain that you have well made unit tests.  That should go without saying, but I'm doing it anyway.

## Part 1: Student Creation
Let's think about what sort of fields a student should have with it.  I'm thinking for this lab, a student should have:

* first name
* last name
* test scores

We're also going to want some helpful fields of
* totalExams
* examsTaken

Considering these fields, we should have the following methods:

* A constructor that takes just a first name and a last name.
* A constructor that takes a first name, a last name, and the total amount of tests that the student will have to take.
* Getters and setters for everything but test scores.
* NOTE: there should NOT be a setter for examsTaken since this should only get incremented when a test is taken.


### printExamScores()
This should return a string that will tell the caller the test scores for that student.
So, if a student took no tests, then it should spit out `No Exams taken`.
Otherwise, it could look something like this:
```
Exam Scores:
Exam 1 -> 100
Exam 2 -> 89
Exam 3 -> 54
```

### takeExam(int score)
This function should just store the grade into the correct position in the `examScores` array.

### changeScoreForExam(int examNum, int newScore)
This function should take the test number that you want to change the grade for, and the grade to change it to.
NOTE: `takeTest` and `changeGradeForTest` should return booleans.  If the changes were valid, then return true.
But if the caller did something weird (like try and put in a negative grade, or try to take more tests than allowed
or tried to change the grade on a test that the student didn't take yet) then print out a message saying that
something went wrong and return false.

### getAverage()
This method should return the student's overall grade.  If they've taken no tests, return 100.0.  Otherwise, just return
the average of all of the tests they've taken.

## Part 2: Classroom
Now that we can create students, it only makes sense to put them in a classroom.
The classroom is merely a class with an array of students and some helpers.

For constructors, we're going to want:

* A no-arg constructor that sets a default `maxStudents`
* A constructor that takes `maxStudents`
* A constructor that takes a Student array

We're also going to need a getter for `studentsEnrolled` and a getter and setter for `maxStudents`

Some of the methods to help build the classroom will be:

### boolean addStudent(Student s)
This method will add a student to the student array, returning false if the array is full.

### Student removeStudent(String firstName, String lastName)
This method will remove the student from the array, re-order the array, and then return the student that was removed.
If the student with that firstName and lastName is not in the class, return null.

### double getClassAverage()
Return the average of all of the students' averages.  If no student's exist, return 100.0.

### String getClassScores()
Return `No students` if no students are in the class, or something like the following otherwise.
```
Students:
Bart Simpson -> 72.4
Homer Simpson -> 0.1
Lisa Simpson -> 100.0
Milhouse Van Houten -> 87.6
```

### void sortStudentsByScore()
This function should change Students such that they are sorted descending by score.  If two students have the same class
average, it doesn't matter what order they're in.

### String gradeClass()
This is the big "challenge" part of the assignment.  What you need to do is give students their final grades.
This should take the entire class, take their averages, and then put them into a bell curve where

* 10% get A
* 25% get B
* 30% get C
* 25% get D
* 10% get F

If there are no students in the class, it should return `No Students`.  Otherwise, it should look something like this.
```
Grades:
Lisa Simpson -> A
Milhouse Van Houten -> B
Bart Simpson -> C
Homer Simpson -> F
```
Remember, the purpose of this is to challenge yourself.  Don't get too caught up in super accurate distributions.
Focus more on how you could do this programmatically and think about a bunch of test cases.
