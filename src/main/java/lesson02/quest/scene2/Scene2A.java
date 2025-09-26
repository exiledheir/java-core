package lesson02.quest.scene2;

import lesson02.quest.MainScene;
import lesson02.quest.scene3.Scene3A;
import lesson02.quest.scene3.Scene3B;

import java.util.Scanner;

public class Scene2A implements MainScene {
    private static final Scanner in = new Scanner(System.in);

    @Override
    public MainScene run() {
        while (true) {
            printMenu();
            int option = in.nextInt();

            return switch (option) {
                case 1 -> new Scene3A();
                case 2 -> new Scene3B();
                default -> {
                    System.out.println("Введите правильную опцию");
                    yield this;
                }
            };
        }
    }

    @Override
    public void printMenu() {
        System.out.println("********Scene2A********");

        System.out.print("""
            Восточный свет
            
            Ты идёшь на свет и находишь старую электростанцию. Внезапно загорается прожектор.
            
            Голос в громкоговорителе: «Стоять. Идентификация...»
            
            Ты ничего не понимаешь.
            
            Выбор:
            
                1. 🤖 Ответить: «Я человек, я потерялся!»
                2. 🏃 Убежать назад в лес.
            
            Введите в какое направление пойти: """);
    }
}
