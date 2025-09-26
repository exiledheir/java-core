package lesson02.quest.scene3;

import lesson02.quest.MainScene;
import lesson02.quest.scene4.Scene4A;
import lesson02.quest.scene4.Scene4B;

import java.util.Scanner;

public class Scene3F implements MainScene {
    private static final Scanner in = new Scanner(System.in);

    @Override
    public MainScene run() {
        while (true) {
            printMenu();
            int option = in.nextInt();

            return switch (option) {
                case 1 -> new Scene4A();
                case 2 -> new Scene4B();
                default -> {
                    System.out.println("Введите правильную опцию");
                    yield this;
                }
            };
        }
    }

    @Override
    public void printMenu() {
        System.out.println("********Scene3F********");

        System.out.print("""
            Побег в лес
            
            Ты бежишь прочь. Натыкаешься на подземный люк.
            Внутри — бункер. Там — доказательства эксперимента:
            
            мониторы, карты, журналы.
            
            Выбор:
            
                  1. 💣 Разрушить центр управления.
                  2. 🧠 Присоединиться к проекту.
            
            Введите в какое направление пойти: """);
    }
}
