package testing;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] tokenArr = scanner.nextLine().split("\\s+");

        double sum = 0;
        for (String token: tokenArr) {

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < token.length(); j++) {
                if (Character.isDigit(token.charAt(j))){
                    sb.append(token.charAt(j));
                }
            }
            double number = Double.parseDouble(sb.toString());
            int firstNum = 0;
            int lastNum = 0;
            for (int i = 0; i < token.length(); i++) {
                char symbol = token.charAt(i);

                if (Character.isUpperCase(symbol) && i == 0){
                    firstNum = symbol - 64;
                    number /= firstNum;
                }else if (Character.isLowerCase(symbol) && i == 0){
                    firstNum = symbol - 96;
                    number *= firstNum;
                }else if (Character.isUpperCase(symbol) && i == token.length() - 1){
                    lastNum = symbol -64;
                    number -= lastNum;
                }else if (Character.isLowerCase(symbol) && i == token.length() - 1){
                    lastNum = symbol - 96;
                    number += lastNum;
                }
            }
            sum += number;
        }
        System.out.printf("%.2f%n", sum);
    }
}
