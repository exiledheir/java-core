package lesson05.quiz.service.impl;

import lesson05.quiz.model.Question;
import lesson05.quiz.service.QuestionService;

import java.util.HashSet;
import java.util.Set;

public class QuestionServiceImpl implements QuestionService {
    private final Set<Question> questions = new HashSet<>();

    @Override
    public void addQuestion(Question question) {
        if (question == null) throw new IllegalArgumentException("Question cannt be null");

        questions.add(question);
    }

    @Override
    public boolean removeQuestion(Question question) {
        if (question == null) throw new IllegalArgumentException("Question cannt be null");

        return questions.remove(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(questions);
    }
}
