package lesson02.quest.scene3;

import lesson02.quest.MainScene;

public class Scene3D implements MainScene {
    @Override
    public MainScene run() {
        printMenu();
        return null;
    }

    @Override
    public void printMenu() {
        System.out.println("********Scene3D********");

        System.out.println("""
            Поиски
            
            Ты блуждаешь в тумане и выходишь к маяку. Там — старая рация. Связь удаётся установить.
            
            На следующий день — эвакуация.
            
            Концовка: Победа
            Результат: Спасение, эвакуация
            """);
    }
}
