package lesson02.quest.scene2;

import lesson02.quest.MainScene;
import lesson02.quest.scene3.Scene3E;
import lesson02.quest.scene3.Scene3F;

import java.util.Scanner;

public class Scene2C implements MainScene {
    private static final Scanner in = new Scanner(System.in);

    @Override
    public MainScene run() {
        while (true) {
            printMenu();
            int option = in.nextInt();

            return switch (option) {
                case 1 -> new Scene3E();
                case 2 -> new Scene3F();
                default -> {
                    System.out.println("Введите правильную опцию");
                    yield this;
                }
            };
        }
    }

    @Override
    public void printMenu() {
        System.out.println("********Scene2C********");

        System.out.print("""
            Ожидание у озера
            
            Ты остаёшься на месте. Из тумана слышишь детский голос:
                    «Помоги мне… пожалуйста…»
            
            Тебя охватывает страх.
            
            Выбор:
            
                1. 👧 Пойти на голос.
                2. 😨 Убежать прочь в лес.
            
            Введите в какое направление пойти: """);
    }
}
