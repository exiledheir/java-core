package lesson05.quiz.service;

import lesson05.quiz.model.Question;
import lesson05.quiz.model.Quiz;
import lesson05.quiz.model.Team;

import java.util.HashSet;
import java.util.Set;

public interface QuizService {

    Quiz createQuiz(String name);

    boolean removeQuiz(Quiz quiz);

    void addQuestionToQuiz(Quiz quiz, Question question);

    void addTeamToQuiz(Quiz quiz, Team team);

    void startQuiz(Quiz quiz);

    Set<Quiz> getQuizzes();
}
