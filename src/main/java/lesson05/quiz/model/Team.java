package lesson05.quiz.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "name")
public class Team {
    private final String name;
    private final String slogan;
    private int score = 0;

    public Team(String name, String slogan) {
        this.name = name;
        this.slogan = slogan;
    }

    public void addScore(int points) {
        this.score += points;
    }
}
