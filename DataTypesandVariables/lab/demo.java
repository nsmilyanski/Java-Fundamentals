package DataTypesandVariables.lab;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        char firstB = Character.MIN_VALUE;
       char secondB = Character.MIN_VALUE;
        int firstNumber = 0;
        int seconNumber = 0;

        for (int i = 1; i <= n ; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < input.length() ; j++) {
                char firstNum = input.charAt(j);
                firstB +=(char) firstNum;
                if (firstNum == 32){
                    break;
                }
            }
            for (int k = input.length() - 1; k <= 0 ; k++) {
                char secondNum = input.charAt(k);
                secondB += secondNum;
                if (secondNum == 32){
                    break;
                }

            }

        firstNumber = (int) firstB;
        seconNumber = (int) secondB;
        int lastDigit = 0;
        int sumForFirstNum = 0;
        int sumForSecondNum = 0;
        boolean isFirstNum = false;
        if (firstNumber > seconNumber){
            isFirstNum = true;
            while (firstNumber > 0){
                lastDigit = firstNumber % 10;
                sumForFirstNum += lastDigit;
                firstNumber = firstNumber / 10;

            }
        }else {
            while (seconNumber > 0){
                lastDigit = seconNumber % 10;
                sumForSecondNum += lastDigit;
                seconNumber = seconNumber / 10;
            }
        }
        if (isFirstNum){
            System.out.println(sumForFirstNum);
        }else {
            System.out.println(sumForSecondNum);
        }
        }


    }
}
