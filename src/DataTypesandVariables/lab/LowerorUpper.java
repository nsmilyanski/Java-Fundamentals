package DataTypesandVariables.lab;

import java.util.Scanner;

public class LowerorUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char symbol = scanner.nextLine().charAt(0);

        if (symbol >= 'A' && symbol <= 'Z'){
            System.out.println("upper-case");
        }else {
            System.out.println("lower-case");
        }
    }
}
