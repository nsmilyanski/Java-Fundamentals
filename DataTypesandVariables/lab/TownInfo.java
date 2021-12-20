package DataTypesandVariables.lab;

import java.util.Scanner;

public class TownInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        int population = Integer.parseInt(scanner.nextLine());
        String area = scanner.nextLine();

        System.out.printf("Town %s has population of %d and area %s square km.", town, population, area);
    }
}
