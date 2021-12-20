package Arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int lowLength = Math.min(firstArr.length, secondArr.length);
        int sum = 0;
        boolean isNotEqual = false;

        for (int i = 0; i < lowLength ; i++) {
            sum += firstArr[i];

            if (firstArr[i] != secondArr[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                isNotEqual = true;
                break;
            }

        }
        if (!isNotEqual){
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }

    }
}
