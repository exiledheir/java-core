package lesson05.quiz.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class TrueFalseQuestion extends Question {
    public final boolean correctAnswer;

    public TrueFalseQuestion(String question, boolean correctAnswer, int points) {
        super(question, points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean isCorrect(String answer) {
        return correctAnswer == Boolean.parseBoolean(answer);
    }

    @Override
    public void displayQuestion() {
        System.out.println("\nQuestion:");
        System.out.println("\t" + getQuestion());
        System.out.print("You can answer true or false: ");
    }
}
