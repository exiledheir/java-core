package lesson02.quest;

import lesson02.quest.scene2.Scene2A;
import lesson02.quest.scene2.Scene2B;
import lesson02.quest.scene2.Scene2C;

import java.util.Scanner;

public class Main implements MainScene {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        MainScene currentScene = new Main();

        while (currentScene != null) {
            currentScene = currentScene.run();
        }

        System.out.println("Игра окончена.");
    }

    @Override
    public MainScene run() {
        while (true) {
            printMenu();
            int option = in.nextInt();

            return switch (option) {
                case 1 -> new Scene2A();
                case 2 -> new Scene2B();
                case 3 -> new Scene2C();
                default -> {
                    System.out.println("Введите правильную опцию");
                    yield this;
                }
            };
        }
    }

    public void printMenu() {
        System.out.print("""
            Пробуждение
            
            Ты приходишь в себя на холодном песке у берега озера.
            Вокруг — туман, ночь, ни души. Телефон в кармане почти разряжен (1%).
            
            В другом кармане — спичка и клочок бумаги с надписью:
                "Не доверяй голосам. Иди к северу."
            
            Выбор:
            
                1. 🔦 Пойти на восток, туда, где в тумане мерцает свет.
                2. 🧭 Пойти на север, как советует записка.
                3. 🪵 Остаться у озера, может, кто-то придёт.
            
            Введите в какое направление пойти: """);
    }
}
