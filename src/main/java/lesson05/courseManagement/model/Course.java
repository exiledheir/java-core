package lesson05.courseManagement.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class Course {
    private final String name;
    private Tutor tutor;
    private final List<Student> students;
    private final Map<Student, List<Boolean>> attendance;
    private final Map<Student, Integer> grades;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.attendance = new HashMap<>();
        this.grades = new HashMap<>();
    }

    public void addStudent(Student student) {
        if (student != null && !students.contains(student)) {
            students.add(student);
            attendance.put(student, new ArrayList<>());
            grades.put(student, 0);
        }
    }

    public void markAttendance(Student student, boolean isPresent) {
        if (attendance.containsKey(student)) {
            attendance.get(student).add(isPresent);
        }
    }

    public void setGrade(Student student, int grade) {
        grades.put(student, grade);
    }
}
