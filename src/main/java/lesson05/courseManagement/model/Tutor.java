package lesson05.courseManagement.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class Tutor extends Person {
    private final List<Course> courses;
    private double rating;

    public Tutor(String fio, String bio, double rating) {
        super(fio, bio);
        this.courses = new ArrayList<>();
        this.rating = rating;
    }

    public void assignCourse(Course course) {
        if (course != null && !courses.contains(course)) {
            courses.add(course);
            course.setTutor(this);
        }
    }

    @Override
    public void introduce() {
        System.out.println("Tutor: " + getFio() + ", rating: " + rating);
    }
}