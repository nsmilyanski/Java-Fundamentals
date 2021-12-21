package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int magicNum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numArr.length ; i++) {
            int currentNum = numArr[i];
            if (i == numArr.length - 1){
                break;
            }


            for (int j = i + 1; j <numArr.length; j++) {
                if (currentNum + numArr[j] == magicNum){
                    System.out.print(currentNum + " ");
                    System.out.print(numArr[j]);
                    System.out.println();
                }

            }

        }
    }
}
