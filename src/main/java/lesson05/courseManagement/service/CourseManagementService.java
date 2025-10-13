package lesson05.courseManagement.service;

import lesson05.courseManagement.model.Course;
import lesson05.courseManagement.model.Student;

public interface CourseManagementService {
    Course createCourse(String name);

    void addStudent(Course course, Student student);

    void markAttendance(Course course, Student student, boolean isPresent);

    void checkAttendance(Course course);

    void getAttendanceList(Course course);

    void setGrade(Course course, Student student, int grade);
}