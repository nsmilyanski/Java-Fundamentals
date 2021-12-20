package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSeuence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxValue = Integer.MIN_VALUE;
        int startLine = 0;
        int lastLine = 0;
        int counter = 1;
        int counterInteration = 0;
        //2 1 1 2 3 3 2 2 2 1
        //0 1 1 5 2 2 6 3 3

        for (int i = 0; i < firstArr.length; i++) {
            counterInteration++;
            int currentNum = firstArr[i];
            if (i == firstArr.length - 1){
                break;
            }

            if (currentNum == firstArr[i + 1]){
                counter++;
                if (counter > maxValue){
                    maxValue = counter;
                    if (counter == 2){
                    startLine = counterInteration - 1;
                    }else if (counter == 3){
                    startLine = counterInteration - 2;
                    }else if (counter == 4){
                    startLine = counterInteration - 3;

                    }
                }
            }else {
                counter = 1;

            }

        }
        for (int j = startLine; j < startLine + maxValue ; j++) {
            System.out.print(firstArr[j] + " ");

        }

    }
}
