package lesson05.quiz.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "name")
@ToString
public class Quiz {
    private final String name;
    private final Set<Question> questions = new HashSet<>();
    private final Set<Team> teams = new HashSet<>();

    public Quiz(String name) {
        this.name = name;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void startQuiz() {
        System.out.println("Starting quiz: " + name);
        System.out.println("Number of teams: " + teams.size());
        System.out.println("Number of questions: " + questions.size());
    }

}
