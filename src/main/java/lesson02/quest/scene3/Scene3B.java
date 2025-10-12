package lesson02.quest.scene3;

import lesson02.quest.MainScene;

public class Scene3B implements MainScene {
    @Override
    public MainScene run() {
        printMenu();
        return null;
    }

    @Override
    public void printMenu() {
        System.out.println("********Scene3B********");

        System.out.println("""
            Побег
            
            Ты бежишь, но спотыкаешься. Прожектор гаснет. Что-то двигается в кустах.
            
            Ты исчез без следа.
            
            Концовка: Неудача
            Результат: Исчезновение, смерть
            """);
    }
}
