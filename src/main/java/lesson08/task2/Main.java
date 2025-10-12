package lesson08.task2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите набор цифр с пробелом между ними: ");
        String nums = scanner.nextLine();

        Set<Integer> collect = Arrays.stream(nums.split("\\s+"))
            .filter(s -> !s.isBlank())
            .map(Integer::parseInt)
            .collect(Collectors.toSet());

        System.out.println(collect);
    }
}
