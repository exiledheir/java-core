package lesson05.quiz.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of = "question")
@ToString
public abstract class Question {
    private final String question;
    private final int points;

    public Question(String question, int points) {
        this.question = question;
        this.points = points;
    }

    public abstract boolean isCorrect(String answer);

    public abstract void displayQuestion();
}
