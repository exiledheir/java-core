package lesson05.quiz.service.impl;

import lesson05.quiz.model.Question;
import lesson05.quiz.model.Quiz;
import lesson05.quiz.model.Team;
import lesson05.quiz.service.QuizService;

import java.util.HashSet;
import java.util.Set;

public class QuizServiceImpl implements QuizService {
    private final Set<Quiz> quizzes = new HashSet<>();

    @Override
    public Quiz createQuiz(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cant be null or empty");
        Quiz quiz = new Quiz(name);
        quizzes.add(quiz);
        return quiz;
    }

    @Override
    public boolean removeQuiz(Quiz quiz) {
        if (quiz == null) throw new IllegalArgumentException("Quiz cannt be null");

        return quizzes.remove(quiz);
    }

    @Override
    public void addQuestionToQuiz(Quiz quiz, Question question) {
        if (question == null || !quizzes.contains(quiz))
            throw new IllegalArgumentException("Question cant be null or it doesnt exist");

        quiz.addQuestion(question);
    }

    @Override
    public void addTeamToQuiz(Quiz quiz, Team team) {
        if (team == null || !quizzes.contains(quiz))
            throw new IllegalArgumentException("Team cant be null or it doesnt exist");

        quiz.addTeam(team);
    }

    @Override
    public void startQuiz(Quiz quiz) {
        if (quiz == null) throw new IllegalArgumentException("Quiz cant be null");
        quiz.startQuiz();
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(quizzes);
    }
}
