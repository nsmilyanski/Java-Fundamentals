package BasicSyntax.exercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
            int sumFact = 0;
            int startNumber = num;

        while ( num != 0){
            int lastDigit = num % 10;
            int fact = 1;
            for (int i = 1; i <= lastDigit ; i++) {
                fact *= i;
            }
            sumFact += fact;
            num = num / 10;
        }
        if (startNumber == sumFact){
            System.out.println("yes");
        }else {
            System.out.println("no");

        }

    }
}
