package lesson05.courseManagement.service.impl;

import lesson05.courseManagement.model.Course;
import lesson05.courseManagement.model.Student;
import lesson05.courseManagement.service.CourseManagementService;

import java.util.List;
import java.util.Scanner;

public class CourseManagementServiceImpl implements CourseManagementService {

    @Override
    public Course createCourse(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Course name cannt be empty");
        }
        return new Course(name);
    }

    @Override
    public void addStudent(Course course, Student student) {
        if (course == null || student == null) {
            System.out.println("Course or Student cannt be null");
            return;
        }
        course.addStudent(student);
        System.out.println(student.getFio() + " added to " + course.getName());
    }

    @Override
    public void markAttendance(Course course, Student student, boolean isPresent) {
        if (course == null || student == null) {
            System.out.println("Course or Student cannt be null");
            return;
        }

        if (!course.getStudents().contains(student)) {
            System.out.println("Student is not in this course");
            return;
        }

        course.markAttendance(student, isPresent);
    }

    @Override
    public void checkAttendance(Course course) {
        if (course == null || course.getStudents().isEmpty()) {
            System.out.println("No students found");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChecking attendance for: " + course.getName());

        for (Student student : course.getStudents()) {
            System.out.print(student.getFio() + " present? (true/false): ");
            boolean isPresent = scanner.nextBoolean();
            course.markAttendance(student, isPresent);
        }
    }

    @Override
    public void getAttendanceList(Course course) {
        if (course == null || course.getAttendance().isEmpty()) {
            System.out.println("No attendance found");
            return;
        }

        System.out.println("ATTENDANCE LIST FOR " + course.getName());
        System.out.printf("%-25s %s%n", "Student", "Attendance");
        System.out.println("-".repeat(50));

        for (Student student : course.getStudents()) {
            List<Boolean> records = course.getAttendance().get(student);
            System.out.printf("%-25s ", student.getFio());

            if (records.isEmpty()) {
                System.out.println("No records found");
            } else {
                for (boolean present : records) {
                    System.out.print(present ? "✓ " : "✗ ");
                }
                System.out.println();
            }
        }
    }

    @Override
    public void setGrade(Course course, Student student, int grade) {
        if (course == null || student == null) {
            System.out.println("Course and Student cannt be null");
            return;
        }

        if (grade < 0 || grade > 100) {
            System.out.println("Grade must be between 0 to 100");
            return;
        }

        if (!course.getStudents().contains(student)) {
            System.out.println("Student is not in this course");
            return;
        }

        course.setGrade(student, grade);
        System.out.println(student.getFio() + " received grade: " + grade);
    }
}