package Methods.exercises;

import java.util.Scanner;

public class AddandSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int result = Sum(firstNum, secondNum) - thirdNum;

        System.out.println(result);

    }
    public static int Sum (int a, int b){
        return a + b;
    }
}
