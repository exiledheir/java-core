package lesson05.courseManagement.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class Student extends Person {
    private final List<Course> courses;
    private int score;

    public Student(String fio, String bio, int score) {
        super(fio, bio);
        this.courses = new ArrayList<>();
        this.score = score;
    }

    public void enrollInCourse(Course course) {
        if (course != null && !courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
        }
    }

    @Override
    public void introduce() {
        System.out.println("Student: " + getFio() + ", score: " + score);
    }
}