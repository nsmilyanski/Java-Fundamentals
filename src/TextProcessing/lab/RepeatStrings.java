package TextProcessing.lab;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] inputArr = scanner.nextLine().split(" ");

        for (int i = 0; i < inputArr.length; i++) {
            String currentSymbol = inputArr[i];
            for (int j = 0; j < currentSymbol.length(); j++) {
                System.out.print(currentSymbol);
            }

        }


    }
}
