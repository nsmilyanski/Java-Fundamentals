package TextProcessing.exercise;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] inputArr = scanner.nextLine().split("\\s+");

        double sum = 0;

        for (String password : inputArr) {
            double modifityNum = getTheModifatyNum(password);
                    sum += modifityNum;

        }
        System.out.printf("%.2f", sum);
    }

    private static double getTheModifatyNum(String password) {
        char firstChar = password.charAt(0);
        char lastChar = password.charAt(password.length() - 1);
        StringBuilder sb = new StringBuilder(password);
        double number = Double.parseDouble(sb.substring(1, sb.length() - 1));

        if (Character.isUpperCase(firstChar)){
            number = number / Integer.parseInt("" + (firstChar - 64));

        }else {
            number *= Integer.parseInt("" + (firstChar - 96));

        }

        if (Character.isUpperCase(lastChar)){
            number -= Integer.parseInt("" + (lastChar - 64));
        }else {
            number += Integer.parseInt("" + (lastChar - 96));
        }

return number;
    }
}
