package lesson02.quest.scene2;

import lesson02.quest.MainScene;
import lesson02.quest.scene3.Scene3C;
import lesson02.quest.scene3.Scene3D;

import java.util.Scanner;

public class Scene2B implements MainScene {
    private static final Scanner in = new Scanner(System.in);

    @Override
    public MainScene run() {
        while (true) {
            printMenu();
            int option = in.nextInt();

            return switch (option) {
                case 1 -> new Scene3C();
                case 2 -> new Scene3D();
                default -> {
                    System.out.println("Введите правильную опцию");
                    yield this;
                }
            };
        }
    }

    @Override
    public void printMenu() {
        System.out.println("********Scene2B********");

        System.out.print("""
            Северный путь
            
            Ты следуешь на север и находишь заброшенную деревню. Дома пусты, но в одном — следы костра и дневник.
                "Озеро просыпается в полнолуние. Не верь голосам. Прячься до рассвета."
            
            Выбор:
            
                1. 🔥 Остаться в доме до рассвета.
                2. 🚪 Выйти и идти дальше в туман.
            
            Введите в какое направление пойти: """);
    }
}
