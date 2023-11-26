package Module1.Lab1;

import java.util.Scanner;

public class String_Analysis {

    public static void analyzeEmailComposition(String email) {

        int totalCharacters = email.length();
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        int digitCount = 0;
        int symbolCount = 0;

        for (char c : email.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercaseCount++;
            } else if (Character.isLowerCase(c)) {
                lowercaseCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            } else {
                symbolCount++;
            }
        }

        double uppercasePercentage = (uppercaseCount * 100.0) / totalCharacters;
        double lowercasePercentage = (lowercaseCount * 100.0) / totalCharacters;
        double digitPercentage = (digitCount * 100.0) / totalCharacters;
        double symbolPercentage = (symbolCount * 100.0) / totalCharacters;

        System.out.printf("%.3f%% %.3f%% %.3f%% %.3f%%", uppercasePercentage, lowercasePercentage, digitPercentage, symbolPercentage);
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String email = input.nextLine();
        analyzeEmailComposition(email);
    }
}