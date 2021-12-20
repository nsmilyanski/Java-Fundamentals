package Methods.exercises;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        double result = (facForFirst(firstNum) * 1.0) / facForSecond(secondNum);
        System.out.printf("%.2f", result);

    }
    private static long facForFirst (long firstNum){

         long sum = 1;
        for (int i = 1; i <= firstNum ; i++) {
            sum *= i;
        }
        return sum;
    }
    private static long facForSecond (long secondNum){
        long sum = 1;
        for (int i = 1; i <= secondNum ; i++) {
            sum *= i;
        }
        return sum;
    }
}
