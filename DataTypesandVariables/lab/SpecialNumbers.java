package DataTypesandVariables.lab;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int constant = 0;

        for (int i = 1; i <= num ; i++) {
        int sum = 0;
            constant = i;
        while (constant > 0){
            int digit = 0;
            digit = constant % 10;
            sum += digit;
            constant = constant / 10;
        }
        if (sum == 5 || sum == 7 || sum == 11){
            System.out.printf("%d -> True%n", i);
        }else {
            System.out.printf("%d -> False%n", i);
        }
        }
    }
}
