package lesson08.task3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, Book> library = new HashMap<>();

    public static void main(String[] args) {
        addBook(new Book("978-5-17-118366-7", "Война и мир", "Лев Толстой"));
        addBook(new Book("978-5-389-07441-7", "Преступление и наказание", "Фёдор Достоевский"));
        addBook(new Book("978-5-699-97345-2", "Мастер и Маргарита", "Михаил Булгаков"));
        addBook(new Book("978-5-389-17948-8", "Анна Каренина", "Лев Толстой"));

        printAllBooks();
    }

    public static void addBook(Book book) {
        library.put(book.getIsbn(), book);
    }

    public static void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("Библиотека пуста.");
            return;
        }

        System.out.println("Список всех книг в библиотеке:");
        for (Map.Entry<String, Book> entry : library.entrySet()) {
            System.out.println("ISBN: " + entry.getKey() + " → " + entry.getValue());
        }
    }
}
