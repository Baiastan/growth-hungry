package java_intensive.school;

import java_intensive.school.management.CourseManager;
import java_intensive.school.management.Student;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Baiastan", 28);
        Student student2 = new Student("Shaislam", 26);
        Student student3 = new Student("Jon Doe", 3);
        Student student4 = new Student("Mary",24);


        CourseManager courseManager = new CourseManager();

        courseManager.addStudent(student1);
        courseManager.addStudent(student2);
        courseManager.addStudent(student3);
        courseManager.addStudent(student4);

        courseManager.addStudent(student1);

        student1.enrollCourses("React Course");

        student2.enrollCourses("Web Development Fundamentals");

        student3.enrollCourses(new String[] {"React Course", "Leetcode"});

        student1.setTuition(100.00);

        String[] requiredCourses = {"Java Intensive", "Computer Systems", "Mentorship", "Discrete Math", "Data Structures and Algorithms" };

        courseManager.enrollAllStudentsToCourse(requiredCourses);

        courseManager.displayAllStudents();

        //remove student

        int studentId = student3.getStudentId();

        student3.unenrollCourse("Java Intensive");

        courseManager.unenrollStudentFromCourse(studentId, "Computer Systems");





        System.out.println("--------------Students after changes in courses------------------");


        courseManager.displayAllStudents();


        courseManager.removeStudentById(studentId);



    }
}
