package lesson03.firstHalf.entities;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Enter valid name");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Enter valid age");
        }
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("Hey my name is " + name + ", and I am " + age + " years old.");
    }
}
