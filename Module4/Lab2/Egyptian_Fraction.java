package Module4.Lab2;

import java.util.Scanner;

public class Egyptian_Fraction {

    public static void egyptianFraction(int numerator, int denominator) {
        if (numerator <= 0 || denominator <= 0) {
            return;
        }

        System.out.println((denominator / numerator + 1));
        int remainderNumerator = numerator * (denominator / numerator + 1) - denominator;
        int remainderDenominator = denominator * (denominator / numerator + 1);

        while (remainderNumerator != 0) {
            int nextDenominator = (remainderDenominator + remainderNumerator - 1) / remainderNumerator;
            System.out.println(nextDenominator);

            remainderNumerator = remainderNumerator * nextDenominator - remainderDenominator;
            remainderDenominator = remainderDenominator * nextDenominator;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numerator = scanner.nextInt();
        int denominator = scanner.nextInt();

        egyptianFraction(numerator, denominator);
    }
}