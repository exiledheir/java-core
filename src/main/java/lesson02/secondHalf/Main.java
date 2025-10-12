package lesson02.secondHalf;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        switchNumbers();
        multiplicationTable();
        currencyConverter();
        checkOddOrEven();
        maxOfThree();
        calculator();
        averageOfNumbers();
        findNumberInArray();
        guessTheNumber();
    }

    //Обмен значений
    public static void switchNumbers() {
        System.out.print("Enter first value: ");
        int a = in.nextInt();
        System.out.print("Enter second value: ");
        int b = in.nextInt();
        System.out.println("Before switching: a = " + a + ", b = " + b);
        int temp = a;
        a = b;
        b = temp;

        System.out.println("Switched values: a = " + a + ", b = " + b);
    }

    //Таблица умножения
    public static void multiplicationTable() {
        System.out.print("Enter some number: ");
        int n = in.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " * " + i + " = " + (n * i));
        }
    }

    //Конвертер валют
    public static void currencyConverter() {
        int exchange = 12500;

        System.out.print("Enter value in usd: ");
        double value = in.nextDouble();

        double result = value * exchange;

        System.out.println("Converted to uzs: " + result);
    }

    //Чётное или нечётное
    public static void checkOddOrEven() {
        System.out.print("Enter value: ");
        int n = in.nextInt();

        if (n % 2 == 0) {
            System.out.println(n + " — even");
        } else {
            System.out.println(n + " — odd");
        }
    }

    public static void maxOfThree() {
        System.out.print("Enter first value: ");
        int a = in.nextInt();
        System.out.print("Enter second value: ");
        int b = in.nextInt();
        System.out.print("Enter third value: ");
        int c = in.nextInt();

        int max = a > b ? a > c ? a : c : b > c ? b : c;
        System.out.println("Max number is: " + max);
    }

    public static void calculator() {
        System.out.print("Enter first value: ");
        double a = in.nextDouble();
        System.out.print("Enter second value: ");
        double b = in.nextDouble();
        System.out.print("Enter operation (+, -, *, /): ");
        char op = in.next().charAt(0);

        double result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b != 0) result = a / b;
                else {
                    System.out.println("Cant divide by 0");
                    return;
                }
                break;
            default:
                System.out.println("Unknown");
                return;
        }
        System.out.println(a + " " + op + " " + b + " = " + result);
    }

    //Среднее арифметическое
    public static void averageOfNumbers() {
        System.out.print("Enter size of array: ");
        int n = in.nextInt();
        int[] array = new int[n];

        int sum = 0;
        System.out.println("Enter numbers: ");
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
            sum += array[i];
        }

        double avg = (double) sum / n;
        System.out.println("Average of numbers: " + avg);
    }

    //Поиск элемента
    public static void findNumberInArray() {
        System.out.print("Enter size of array: ");
        int n = in.nextInt();
        int[] array = new int[n];

        System.out.println("Enter numbers: ");
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        System.out.print("Enter number to search: ");
        int x = in.nextInt();

        boolean found = false;
        for (int num : array) {
            if (num == x) {
                found = true;
                break;
            }
        }

        if (found) System.out.println("Number is in array");
        else System.out.println("Number not found");
    }

    //Мини-игра "Угадай число"
    public static void guessTheNumber() {
        Random rand = new Random();
        int r = rand.nextInt(10) + 1;
        int attempts = 5;

        System.out.println("Guessed number from 1 to 10. You have " + attempts + " attempts");

        while (attempts > 0) {
            System.out.print("Enter value: ");
            int guess = in.nextInt();

            if (guess == r) {
                System.out.println("You won");
                return;
            } else if (guess > r) {
                System.out.println("Less");
            } else {
                System.out.println("More");
            }
            attempts--;
        }

        System.out.println("You lost. The guessed number: " + r);
    }
}
