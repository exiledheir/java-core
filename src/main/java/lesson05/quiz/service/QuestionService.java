package lesson05.quiz.service;

import lesson05.quiz.model.Question;

import java.util.Set;

public interface QuestionService {
    void addQuestion(Question question);

    boolean removeQuestion(Question question);

    Set<Question> getQuestions();
}
