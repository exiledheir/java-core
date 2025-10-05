package lesson05.quiz;

import lesson05.quiz.model.MultipleChoiceQuestion;
import lesson05.quiz.model.Question;
import lesson05.quiz.model.Quiz;
import lesson05.quiz.model.Team;
import lesson05.quiz.model.TrueFalseQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class QuizApp {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter quiz name: ");
        String quizName = scanner.nextLine();
        Quiz quiz = new Quiz(quizName);

        System.out.println("\n=== Add Teams ===");
        while (true) {
            System.out.print("Enter team name (or 'done'): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) break;
            System.out.print("Enter team slogan: ");
            String slogan = scanner.nextLine();
            quiz.addTeam(new Team(name, slogan));
        }

        System.out.println("\n=== Add Questions ===");
        while (true) {
            System.out.print("Add (1) Multiple-choice, (2) True/False, or 'done': ");
            String type = scanner.nextLine();
            if (type.equalsIgnoreCase("done")) break;

            System.out.print("Enter question text: ");
            String text = scanner.nextLine();

            System.out.print("Enter points: ");
            int points = Integer.parseInt(scanner.nextLine());

            if (type.equals("1")) {
                List<String> options = new ArrayList<>();
                while (true) {
                    System.out.print("Enter option (or 'end'): ");
                    String option = scanner.nextLine();
                    if (option.equalsIgnoreCase("end")) break;
                    options.add(option);
                }
                System.out.print("Enter correct answers (comma separated indices): ");
                String[] correct = scanner.nextLine().split(",");
                Set<Integer> correctAnswers = Arrays.stream(correct)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
                ;

                quiz.addQuestion(new MultipleChoiceQuestion(text, options, correctAnswers, points));
            } else if (type.equals("2")) {
                System.out.print("Enter correct answer (true/false): ");
                boolean correct = Boolean.parseBoolean(scanner.nextLine());
                quiz.addQuestion(new TrueFalseQuestion(text, correct, points));
            }
        }

        System.out.println("\n=== Starting Quiz: " + quiz.getName() + " ===");
        for (Team team : quiz.getTeams()) {
            System.out.println("\nTeam: " + team.getName());
            for (Question q : quiz.getQuestions()) {
                q.displayQuestion();
                System.out.print("Your answer: ");
                String answer = scanner.nextLine();
                if (q.isCorrect(answer)) {
                    System.out.println("✅ Correct! +" + q.getPoints());
                    team.addScore(q.getPoints());
                } else {
                    System.out.println("❌ Wrong answer!");
                }
            }
        }

        System.out.println("\n=== Final Results ===");
        quiz.getTeams().forEach(System.out::println);
        Team winner = quiz.getTeams().stream().max(Comparator.comparingInt(Team::getScore)).orElse(null);
        if (winner != null)
            System.out.println("\n🏆 Winner: " + winner.getName() + " with " + winner.getScore() + " points!");
    }
}
