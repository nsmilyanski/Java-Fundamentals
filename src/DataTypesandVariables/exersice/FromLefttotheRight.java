package DataTypesandVariables.exersice;

import java.util.Scanner;

public class FromLefttotheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        long left = 0;
        long right = 0;
        long sum = 0;


        for (int i = 0; i < input; i++) {
            left = scanner.nextLong();
            right = scanner.nextLong();

            if (left < right) {
                sum = 0;
                while (right != 0) {
                    sum += right % 10;
                    right /= 10;

                }
                System.out.println(Math.abs(sum));
            } else {
                sum = 0;
                while (left != 0) {
                    sum += left % 10;
                    left /= 10;

                }
                System.out.println(Math.abs(sum));
            }


        }

    }
}
