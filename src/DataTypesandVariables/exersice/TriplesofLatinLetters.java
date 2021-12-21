package DataTypesandVariables.exersice;

import java.util.Scanner;

public class TriplesofLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                for (int k = 0; k < n; k++) {
                    char firstSymbol = (char) ('a' + i);
                    char secondSymbol = (char) ('a' + j);
                    char thirdSymbol = (char) ('a' + k);
                    System.out.printf("%c%c%c%n", firstSymbol, secondSymbol, thirdSymbol);

                }

            }

        }
    }
}
