package lesson02.firstHalf.stars;

import java.util.Scanner;

public class Stars {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        leftAlignedTriangle();
        rightAlignedInvertedTriangle();
        leftAlignedInvertedTriangle();
        rightAlignedTriangle();
    }

    public static void leftAlignedTriangle() {
        int n = userInput();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void rightAlignedInvertedTriangle() {
        int n = userInput();

        for (int i = n; i > 0; i--) {
            for (int k = n; k > i; k--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void leftAlignedInvertedTriangle() {
        int n = userInput();

        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void rightAlignedTriangle() {
        int n = userInput();

        for (int i = n; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = n; k >= i; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static int userInput() {
        System.out.print("Enter value for N: ");
        return in.nextInt();
    }
}
