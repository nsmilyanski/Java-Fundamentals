package testing;

import java.util.Scanner;

public class DigitsLettersOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder symbols = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (Character.isDigit(symbol)) {
                digits.append(symbol);
            }else if (Character.isLetter(symbol)){
                letters.append(symbol);
            }else {
                symbols.append(symbol);
            }


        }

        System.out.println(digits);
        System.out.println(letters);
        System.out.println(symbols);
    }
}
