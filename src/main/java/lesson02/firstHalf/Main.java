package lesson02.firstHalf;

import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        printNumbers1to100();
        sumFrom1ToN();
        productFrom1ToN();
        sumOfEvenFrom1ToN();
        sumOfDigits();
        reverseNumber();
        factorialOfN();
        firstDivisorOf7GreaterThan1000();
        printPrimeNumbersToN();
    }

    //Метод для вывода чисел от 1 до 100
    public static void printNumbers1to100() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");

            if (i % 10 == 0) System.out.println();
        }
    }

    //Сумма чисел от 1 до N
    public static void sumFrom1ToN() {
        int sum = 0;
        int n = userInput();

        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Sum of numbers from 1 to N: " + sum);
    }

    //Произведение чисел от 1 до N.
    public static void productFrom1ToN() {
        int product = 1;
        int n = userInput();

        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        System.out.println("Multiplication of numbers from 1 to N: " + product);
    }

    //Сумма четных чисел от 1 до N.
    public static void sumOfEvenFrom1ToN() {
        int sum = 0;
        int n = userInput();

        for (int i = 2; i <= n; i += 2) {
            sum += i;
        }
        System.out.println("Sum of even numbers from 1 to N: " + sum);
    }

    //Сумма цифр числа
    public static void sumOfDigits() {
        int sum = 0;
        int n = userInput();

        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        System.out.println(sum);
    }

    //Разворот числа
    public static void reverseNumber() {
        int reverse = 0;
        int n = userInput();

        while (n != 0) {
            reverse = n % 10 + reverse * 10;
            n /= 10;
        }

        System.out.println(reverse);
    }

    //Найти факториал N
    public static void factorialOfN() {
        long factorial = 1;
        int n = userInput();

        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        System.out.println(factorial);
    }

    //Найти первое число, которое делится на 7 и больше 1000
    public static void firstDivisorOf7GreaterThan1000() {
        int n = 1001;

        while (n % 7 != 0) {
            n++;
        }
        System.out.println(n);
    }

    //Вывести все простые числа до N
    public static void printPrimeNumbersToN() {
        int n = userInput();

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) System.out.print(i + " ");
        }
    }

    private static boolean isPrime(int num) {
        if (num == 2) return true;
        if (num < 2) return false;

        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }


    private static int userInput() {
        System.out.print("Enter value for N: ");
        return in.nextInt();
    }
}
