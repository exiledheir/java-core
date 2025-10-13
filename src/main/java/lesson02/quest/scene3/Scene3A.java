package lesson02.quest.scene3;

import lesson02.quest.MainScene;

public class Scene3A implements MainScene {
    @Override
    public MainScene run() {
        printMenu();
        return null;
    }

    @Override
    public void printMenu() {
        System.out.println("********Scene3A********");

        System.out.println("""
            Попытка общения
            
            Ты кричишь, но свет слепит тебя. Из темноты появляется фигура в противогазе.
            Вас усыпляют. Очнулся ты уже в лаборатории. Ты стал частью эксперимента.
            
            Концовка: Неудача
            Результат: Исчезновение, смерть
            """);
    }
}
