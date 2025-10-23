package lesson12.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {

        //1. Predicate<String>, который проверяет, что строка не пуста и длиннее 3 символов.
        Predicate<String> predicate = (str) -> !str.isBlank() && str.length() > 3;
        System.out.println(predicate.test("Test"));

        //2. Function<String, Integer>, возвращающую длину строки.
        Function<String, Integer> lengthOfString = (str) -> str.length();
        System.out.println(lengthOfString.apply("Test"));

        //3. Supplier<UUID>, который возвращает новый UUID при каждом вызове
        Supplier<UUID> newUUID = () -> UUID.randomUUID();
        System.out.println(newUUID.get());

        //4. Consumer<String>, который выводит строку в upper case.
        Consumer<String> convertToUpperCase = (str) -> System.out.println(str.toUpperCase());
        convertToUpperCase.accept("test");

        //5. BiFunction<Integer, Integer, Integer>, которая возвращает сумму двух чисел
        BiFunction<Integer, Integer, Integer> sumOfTwoIntegers = (i1, i2) -> i1 + i2;
        System.out.println(sumOfTwoIntegers.apply(5, 3));


        //6. Function<String, String> trim и Function<String, String> toUpperCase.
        // Объедини их в одну, которая сначала обрезает пробелы, потом делает верхний регистр.
        Function<String, String> trim = (str) -> str.trim();
        Function<String, String> toUpperCase = (str) -> str.toUpperCase();

        Function<String, String> trimAndUpperCase = trim.andThen(toUpperCase);
        System.out.println(trimAndUpperCase.apply("  test  "));

        //7. Один Consumer печатает строку в консоль, второй — печатает длину строки. Объедини их через andThen().
        Consumer<String> printFunction = (str) -> System.out.println(str);
        Consumer<String> printLength = (str) -> System.out.println(str.length());

        Consumer<String> stringConsumer = printFunction.andThen(printLength);
        stringConsumer.accept("Test");

        //8. Predicate<Integer> isEven и isPositive.
        // Получи Predicate, который проверяет "нечётное или отрицательное".
        Predicate<Integer> isEven = (num) -> num % 2 == 0;
        Predicate<Integer> isNegative = (num) -> num < 0;

        Predicate<Integer> isEvenOrIsNegative = isEven.or(isNegative);

        System.out.println(List.of(1, 2, 4, 5 - 2, 4, 8).stream().filter(isEvenOrIsNegative).toList());

        //9. BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        // Function<Integer, String> toStr = x -> "Result: " + x;
        // Используй andThen(), чтобы объединить в одну цепочку.
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        Function<Integer, String> toStr = x -> "Result: " + x;

        BiFunction<Integer, Integer, String> integerIntegerStringBiFunction = multiply.andThen(toStr);
        System.out.println(integerIntegerStringBiFunction.apply(4, 6));

        //10. UnaryOperator<String>, который добавляет "!!!" к строке.
        UnaryOperator<String> unaryOperator = (str) -> str + "!!!";

        // Тест методов:
        List<String> words = List.of("one", "two", "thre", "four");
        List<String> filtered = filter(words, predicate);
        forEach(filtered, (s) -> System.out.println(s));

        List<Integer> lengths = map(words, lengthOfString);
        forEach(lengths, (s) -> System.out.println(s));

        List<Integer> generated = generate(() -> Integer.valueOf(1), 4);
        forEach(generated, (s) -> System.out.println(s));

    }

    //11. Метод filter(List<T> list, Predicate<T> predicate), который вручную фильтрует коллекцию аналогично Stream API.
    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }


    //12. Метод map(List<T> list, Function<T, R> mapper) и преобразуй List<String> в List<Integer> (длины строк).
    private static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }

    //13. Создай метод forEach(List<T> list, Consumer<T> consumer) и напечатай каждый элемент списка.
    private static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    //14. Напиши метод generate(Supplier<T> supplier, int n), который создаёт список из n элементов, полученных от supplier.
    private static <T> List<T> generate(Supplier<T> supplier, int n) {
        List<T> generated = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            generated.add(supplier.get());
        }
        return generated;
    }

}
