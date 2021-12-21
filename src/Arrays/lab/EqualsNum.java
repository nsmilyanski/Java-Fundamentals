package Arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class EqualsNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isEqual = false;

        for (int index = 0; index < numbers.length; index++) {

            int leftSum = 0;
            int rightSum = 0;

            for (int leftindex = 0; leftindex < index ; leftindex++) {
                leftSum += numbers[leftindex];

            }

            for (int rightIndex = index + 1; rightIndex <= numbers.length - 1 ; rightIndex++) {
                rightSum += numbers[rightIndex];

            }
            if (leftSum == rightSum){
                isEqual = true;
                System.out.println(index);
                break;
            }

        }
        if (!isEqual){
            System.out.println("no");
        }
    }
}
