package DataTypesandVariables.exersice;

import java.util.Scanner;

public class DecryptingMessages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int numLines = Integer.parseInt(scanner.nextLine());

        int sumOfDigits = 0;
        char output = Character.MIN_VALUE;

        for (int i = 1; i <= numLines ; i++) {
        char symbol = scanner.nextLine().charAt(0);
        int symbolInt = (int)symbol;
        sumOfDigits = key + symbolInt;
        output = (char)sumOfDigits;

            System.out.print(output);

        }

    }
}
