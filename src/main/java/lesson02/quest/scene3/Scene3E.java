package lesson02.quest.scene3;

import lesson02.quest.MainScene;

public class Scene3E implements MainScene {
    @Override
    public MainScene run() {
        printMenu();
        return null;
    }

    @Override
    public void printMenu() {
        System.out.println("********Scene3E********");

        System.out.println("""
            Девочка
            
            Ты идёшь на голос и видишь девочку в белом. Она улыбается и исчезает в воде.
            
            Вокруг тебя — тени. Ты не можешь двигаться.
            
            Концовка: Проклятие озера
            Результат: Попал под влияние озера
            """);
    }
}
