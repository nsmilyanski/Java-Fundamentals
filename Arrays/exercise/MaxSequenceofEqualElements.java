package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceofEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondArr = new int[firstArr.length];

        int counter = 0;
        for (int i = 0; i < firstArr.length ; i++) {
            int currentNum = firstArr[i];
            if (i == firstArr.length - 1){
                secondArr[i] = firstArr[i];
                break;
            }
            if (currentNum == firstArr[i + 1]){
                ++counter;
                secondArr[i] = firstArr[i];

            }else if (counter > 0){
                if (currentNum == firstArr[i - 1]){
                secondArr[i] = currentNum;
                counter++;
                }
            }

        }
        for (int i = 0; i < secondArr.length; i++) {


        }
    }
}
