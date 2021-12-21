package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean isFound = false;

        for (int index = 0; index < numbers.length; index++) {
            int currentElement = numbers[index];
            int leftSum = 0; //сума на елементите в ляво
            int rightSum = 0; //сума на елементите в дясно

            //лявата сума -> 0 до моя индекс
            for (int leftIndex = 0; leftIndex < index; leftIndex++) {
                leftSum += numbers[leftIndex];
            }

            //дясна сума -> моя индекс + 1 до последния (numbers.length - 1)
            for (int rightIndex = index + 1; rightIndex <=  numbers.length - 1; rightIndex++) {
                rightSum += numbers[rightIndex];
            }

            //проверка дали лявата и дясната са равни
            if(leftSum == rightSum) {
                System.out.println(index);
                isFound = true;
                break;
            }

        }

        if(!isFound) {
            System.out.println("no");
        }



    }
}
