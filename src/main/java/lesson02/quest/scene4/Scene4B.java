package lesson02.quest.scene4;

import lesson02.quest.MainScene;

public class Scene4B implements MainScene {
    @Override
    public MainScene run() {
        printMenu();
        return null;
    }

    @Override
    public void printMenu() {
        System.out.println("********Scene4B********");

        System.out.println("""
            Присоединение
            
            Ты входишь в проект. Тебе дают новое имя.
            Ты становишься частью того, что раньше преследовало тебя.
            
            Концовка: Тайный участник
            Результат: Стал частью эксперимента
            """);
    }
}
