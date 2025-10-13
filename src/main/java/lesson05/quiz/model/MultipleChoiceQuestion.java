package lesson05.quiz.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
public class MultipleChoiceQuestion extends Question {

    private final List<String> options;
    private final Set<Integer> correctAnswers;

    public MultipleChoiceQuestion(String question, List<String> options, Set<Integer> correctAnswers, int points) {
        super(question, points);
        this.options = options;
        this.correctAnswers = correctAnswers;
    }

    @Override
    public boolean isCorrect(String answer) {
        String[] userAnswers = answer.split(",");
        Set<Integer> parsedAnswers = new HashSet<>();
        for (String userAnswer : userAnswers) {
            parsedAnswers.add(Integer.parseInt(userAnswer));
        }

        return parsedAnswers.containsAll(correctAnswers) && correctAnswers.containsAll(parsedAnswers);
    }

    @Override
    public void displayQuestion() {
        System.out.println("\nQuestion:");
        System.out.println("\t" + getQuestion());
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.print("P.S: There can be multiple correct answers (separated by comma): ");
    }
}
