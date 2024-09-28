package java_intensive.school.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CourseManager {

    private HashMap<Integer, Student> students;



    public CourseManager() {
        students = new HashMap<>();

    }

    public void addStudent(Student student) {
        if(students.containsKey(student.getStudentId())) {
            System.out.println("Student: " + student.getName() + " with id: " + student.getStudentId() + " is already in the list");
        }else{

            students.put(student.getStudentId(), student);
        }

    }

    public void enrollAllStudentsToCourse(String[] courseName) {

     for(Student student: students.values()) {
         student.enrollCourses((courseName));
     }

    }

    public void removeStudentById(int studentId) {
        if(students.containsKey(studentId)) {
            students.remove(studentId);
            System.out.println("Student with ID " + studentId + " has been removed.");
        }else{
            System.out.println("Student with ID " + studentId + " not found");
        }
    }

    public void unenrollStudentFromCourse(int studentId, String courseName) {

        Student student = students.get(studentId);

        student.unenrollCourse(courseName);

    }

    public void enrollAllStudentsToCourse(String courseName) {
        for(Student student: students.values()) {
            student.enrollCourses((courseName));
        }
    }

    public void displayAllStudents() {

        for(Map.Entry<Integer, Student> studentEntry: students.entrySet()) {
            Student student = studentEntry.getValue();
            System.out.println("--------------------------------------------------");
            System.out.println("Student Id: " + student.getStudentId());
            student.displayDetails();
            System.out.println("Tuition: " + student.getTuition());
            student.displayEnrolledCourses();
        }


    }
}
