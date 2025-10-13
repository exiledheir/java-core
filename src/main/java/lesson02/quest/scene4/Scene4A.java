package lesson02.quest.scene4;

import lesson02.quest.MainScene;

public class Scene4A implements MainScene {
    @Override
    public MainScene run() {
        printMenu();
        return null;
    }

    @Override
    public void printMenu() {
        System.out.println("********Scene4A********");

        System.out.println("""
            Разрушение
            
            Ты активируешь самоуничтожение. Озеро начинает светиться. Тьма уходит. Ты спас мир… но погиб.
            
            Концовка: Герой
            Результат: Спас мир, но погиб
            """);
    }
}
