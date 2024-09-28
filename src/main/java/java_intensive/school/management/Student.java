package java_intensive.school.management;

import java_intensive.school.Person;

import java.util.ArrayList;
import java.util.Collections;

public class Student extends Person {

    private static int idCounter = 0;
    private int studentId;
    ;
    private ArrayList<String> enrolledCourses = new ArrayList<>();



    private double tuition = 500.00; //default tuition

    public Student(String name, int age) {
        super(name, age);
        this.studentId = generateId();
    }

    public int getStudentId() {
        return studentId;
    }

    public void enrollCourses(String[] courses) {
        if(courses != null) {
            Collections.addAll(enrolledCourses, courses);
        }
    }

    public void unenrollCourse(String courseName) {

        if(enrolledCourses.contains(courseName)) {
            enrolledCourses.remove(courseName);
            System.out.println("Course " + courseName + " has been unenrolled.");
        }else{
            System.out.println("Course " + courseName + " is not found in the enrolled list.");
        }

    }

    private static int generateId() {
        return ++idCounter;
    }

    public void enrollCourses(String course) {
        enrolledCourses.add(course);
    }

    public void displayEnrolledCourses() {
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled yet.");
        } else {
            System.out.println("Courses enrolled: " + enrolledCourses);
        }
    }


    public double getTuition() {
        return tuition * enrolledCourses.size();
    }


    public void setTuition(double tuition) {
        this.tuition = tuition;
    }
}
