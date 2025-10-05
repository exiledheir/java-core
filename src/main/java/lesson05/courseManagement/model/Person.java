package lesson05.courseManagement.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Person {
    private final String fio;
    private String bio;

    public Person(String fio, String bio) {
        this.fio = fio;
        this.bio = bio;
    }

    public abstract void introduce();
}