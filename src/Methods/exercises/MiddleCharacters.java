package Methods.exercises;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printMiddleCharacter(input);

    }
    private static void printMiddleCharacter (String input){
        int currentIndex = 0;
        if (input.length() % 2 == 0){
            System.out.print(input.charAt(input.length()/2 - 1));
            System.out.print(input.charAt(input.length()/2));

        }else {
            System.out.print(input.charAt(input.length()/2));
        }
    }
}
