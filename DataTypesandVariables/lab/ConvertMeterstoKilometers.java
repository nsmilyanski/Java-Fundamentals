package DataTypesandVariables.lab;

import java.util.Scanner;

public class ConvertMeterstoKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        double convert = num / 1000.0;

        System.out.printf("%.2f", convert);
    }
}
