package DataTypesandVariables.lab;

import java.util.Scanner;

public class PoundstoDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double paunds = Double.parseDouble(scanner.nextLine());

        double dolars = paunds * 1.36;

        System.out.printf("%.3f", dolars);
    }
}
