package lesson02.quest.scene3;

import lesson02.quest.MainScene;

public class Scene3C implements MainScene {
    @Override
    public MainScene run() {
        printMenu();
        return null;
    }

    @Override
    public void printMenu() {
        System.out.println("********Scene3C********");

        System.out.println("""
            Ожидание
            
            Ты сидишь у костра. Проходят часы. На рассвете из тумана выходит группа людей — выжившие.
            
            Они помогают тебе выбраться.
            
            Концовка: Победа
            Результат: Спасение, эвакуация
            """);
    }
}
