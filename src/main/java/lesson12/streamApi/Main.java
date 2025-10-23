package lesson12.streamApi;

import lesson12.streamApi.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        System.out.println("\n\t\tСписок четных чисел возведенные в квадрат");
        evenSquaredList(numbers);

        List<String> words = List.of("apple", "banana", "pear", "pineapple");
        System.out.println("\n\t\tСписок слов длинна которых больше 5");
        countWordsGreaterThan5(words);

        List<Integer> nums = List.of(10, 2, 33, 4, 25);
        System.out.println("\n\t\tМакс и мин числа из списка");
        findMinMax(nums);

        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        System.out.println("\n\t\tСреднаяя длина строк в списке");
        avgOfWordInCollection(names);

        List<String> input = List.of("apple", "pear", "apple", "banana", "pear");
        System.out.println("\n\t\tСписок без дубликатов и отсортированные по длине");
        removeDuplicateSorted(input);

        List<String> fruits = List.of("apple", "banana", "kiwi");
        System.out.println("\n\t\tПреобразованный список строк в Map");
        listToMap(fruits);

        List<String> names2 = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");
        System.out.println("\n\t\tСгруппированные имена по первой букве");
        groupByInitial(names2);

        List<String> names3 = List.of("Tom", "Jerry", "Spike");
        System.out.println("\n\t\tCписок имён в одну строку через запятую");
        sequenceOfNames(names3);

        List<String> sentences = List.of("Java is cool", "Streams are powerful");
        System.out.println("\n\t\tCписок всех слов");
        getEachWordFromSequence(sentences);

        List<Product> products = List.of(
            new Product("Phone", "Electronics", 1200),
            new Product("TV", "Electronics", 1800),
            new Product("Apple", "Fruits", 2.5),
            new Product("Mango", "Fruits", 4.0));

        System.out.println("\n\t\tCамый дорогой продукт в каждой категории");
        getMostExpensiveFromCategory(products);

    }

    private static void printEnding(Collection collection) {
        System.out.println(collection);
        System.out.println("Метод через stream api");
    }

    private static void printBeginning(Collection collection) {
        System.out.println("Изначальный список");
        System.out.println(collection);
        System.out.println("\nМетод через for loop");
    }

    //1. Дан список чисел. Оставь только чётные и выведи их квадраты
    private static void evenSquaredList(List<Integer> numbers) {

        printBeginning(numbers);
        List<Integer> temp = new ArrayList<>();
        for (Integer num : numbers) {
            if (num % 2 == 0)
                temp.add(num * num);
        }
        printEnding(temp);
        numbers = numbers.stream().
            filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .toList();

        System.out.println(numbers);
    }

    //2. Подсчитай, сколько строк в списке длиннее 5 символов.
    private static void countWordsGreaterThan5(List<String> words) {
        printBeginning(words);
        int counter = 0;
        for (String word : words) {
            if (word.length() > 5)
                counter++;
        }
        System.out.println("Количество строк длина больше 5: " + counter);
        System.out.println("Метод через stream api");

        long count = words.stream()
            .filter(str -> str.length() > 5)
            .count();
        System.out.println("Количество строк длина больше 5: " + count);
    }

    //3. Найди максимальное и минимальное число в списке с помощью Stream API.
    private static void findMinMax(List<Integer> nums) {
        printBeginning(nums);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Integer num : nums) {
            if (max < num)
                max = num;
            if (min > num)
                min = num;
        }
        System.out.println("Минимум = " + min + ", Max = " + max);
        System.out.println("Метод через stream api");

        IntSummaryStatistics intSummaryStatistics = nums.stream()
            .mapToInt(Integer::intValue)
            .summaryStatistics();
        System.out.println("Минимум = " + intSummaryStatistics.getMin() + ", Max = " + intSummaryStatistics.getMax());
    }

    //4. Посчитай среднюю длину строк в списке.
    private static void avgOfWordInCollection(List<String> names) {
        printBeginning(names);
        double avg = 0;
        for (String name : names) {
            avg += name.length();
        }
        System.out.println("Средняя длина имен в списке: " + (avg / names.size()));
        System.out.println("Метод через stream api");

        OptionalDouble optionalDouble = names.stream()
            .mapToInt(String::length)
            .average();
        if (optionalDouble.isPresent()) {
            System.out.println("Средняя длина имен в списке: " + optionalDouble.getAsDouble());
        }
    }

    //5. Удали дубликаты и отсортируй строки по длине.
    private static void removeDuplicateSorted(List<String> input) {
        printBeginning(input);
        List<String> result = new ArrayList<>();
        for (String in : input) {
            if (!result.contains(in)) {
                result.add(in);
            }
        }
        result.sort((s1, s2) -> s2.length() - s1.length());
        printEnding(result);

        List<String> list = input.stream()
            .distinct()
            .sorted((s1, s2) -> s2.length() - s1.length())
            .toList();
        System.out.println(list);

    }

    //6. Преобразуй список строк в Map: ключ — строка, значение — длина.
    private static void listToMap(List<String> fruits) {
        printBeginning(fruits);
        Map<String, Integer> result = new HashMap<>();
        for (String fruit : fruits) {
            result.put(fruit, fruit.length());
        }

        System.out.println(result);

        System.out.println("Метод через stream api");
        HashMap<String, Integer> collect = fruits.stream()
            .collect(HashMap::new,
                (map, s) -> map.put(s, s.length()),
                HashMap::putAll);

        System.out.println(collect);
    }

    //7. Сгруппируй имена по первой букве.
    private static void groupByInitial(List<String> names) {
        printBeginning(names);
        Map<Character, String> result = new HashMap<>();
        for (String name : names) {
            Character ch = name.charAt(0);
            if (result.containsKey(ch)) {
                result.put(ch, result.get(ch) + ", " + name);
            } else {
                result.put(ch, name);
            }
        }

        System.out.println(result);

        System.out.println("Метод через stream api");
        Map<Character, String> collect = names.stream()
            .collect(Collectors.groupingBy(name -> name.charAt(0),
                Collectors.joining(", ")));

        System.out.println(collect);
    }

    //8. Собери список имён в одну строку через запятую.
    private static void sequenceOfNames(List<String> names) {
        printBeginning(names);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < names.size() - 1; i++) {

            result.append(names.get(i)).append(", ");
        }
        result.append(names.getLast());
        System.out.println(result);

        System.out.println("Метод через stream api");
        String collect = names.stream().collect(Collectors.joining(", "));

        System.out.println(collect);
    }

    //9. Из списка предложений получить список всех слов.
    private static void getEachWordFromSequence(List<String> sentences) {
        printBeginning(sentences);
        List<String> result = new ArrayList<>();
        for (String sentence : sentences) {
            String[] str = sentence.split("\\s+");
            result.addAll(Arrays.asList(str));
        }
        System.out.println(result);

        System.out.println("Метод через stream api");
        List<String> list = sentences.stream().map(str -> str.split("\\s+"))
            .flatMap(Arrays::stream)
            .toList();
        System.out.println(list);
    }

    //10. Найди самый дорогой продукт в каждой категории.
    private static void getMostExpensiveFromCategory(List<Product> products) {
        printBeginning(products);
        Map<String, Double> result = new HashMap<>();
        for (Product product : products) {
            if (result.containsKey(product.category())) {
                double max = result.get(product.category());
                if (max < product.price()) {
                    max = product.price();
                }
                result.put(product.category(), max);

            } else {
                result.put(product.category(), product.price());
            }
        }

        System.out.println(result);

        System.out.println("Метод через stream api");
        Map<String, Double> collect = products.stream()
            .collect(Collectors.toMap(
                Product::category,
                Product::price,
                Math::max
            ));

        System.out.println(collect);
    }
}
