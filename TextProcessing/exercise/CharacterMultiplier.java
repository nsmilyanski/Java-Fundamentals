package TextProcessing.exercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");

        String firstText = inputArr[0];
        String secondText = inputArr[1];

        int minLength = Math.min(firstText.length(), secondText.length());

        int sum = 0;
        for (int i = 0; i < minLength; i++) {
            int a = firstText.charAt(i);
            int b = secondText.charAt(i);
            sum += (a * b);
        }
        if (firstText.length() > secondText.length()) {
            for (int i = minLength; i < firstText.length(); i++) {
                int a = firstText.charAt(i);
                sum += a;
            }

        } else if (secondText.length() > firstText.length()) {
            for (int i = minLength; i < secondText.length(); i++) {
                int a = secondText.charAt(i);
                sum += a;

            }
        }
        System.out.println(sum);
    }
}