package lesson08.task1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ElectronicQueue {
    private static final Deque<Person> queue = new LinkedList<>();
    private static int counter = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    ====== ЭЛЕКТРОННАЯ ОЧЕРЕДЬ ======
                    1. Зарегистрировать пользователя
                    2. Обработать следующего в очереди
                    3. Показать всех в очереди
                    0. Выход
                    """);

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите имя пользователя: ");
                    String name = scanner.nextLine();
                    registerPerson(new Person(++counter, name));
                }
                case 2 -> processPerson();
                case 3 -> showQueue();
                case 0 -> {
                    System.out.println("Программа завершена.");
                    return;
                }
                default -> System.out.println("Некорректный выбор!");
            }
        }
    }

    public static void registerPerson(Person person) {
        queue.addLast(person);
        System.out.println("Пользователь " + person.getName() +
            " зарегистрирован. Его номер в очереди: " + person.getNumber());
    }

    public static void processPerson() {
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста, никто не ожидает обслуживания.");
            return;
        }
        Person served = queue.pollFirst(); // извлекаем первого (FIFO)
        System.out.println("Обслужен пользователь: " + served.getName() +
            " (номер " + served.getNumber() + ")");
    }

    public static void showQueue() {
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста.");
            return;
        }
        System.out.println("Текущая очередь:");
        for (Person person : queue) {
            System.out.println(person.getNumber() + ". " + person.getName());
        }
    }
}
