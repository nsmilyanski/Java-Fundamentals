package DataTypesandVariables.exersice;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int lastDigit = 0;
        int sum =0;

        while (num > 0){
            lastDigit = num % 10;
            sum += lastDigit;
            num = num /10;

        }
        System.out.println(sum);
    }
}
