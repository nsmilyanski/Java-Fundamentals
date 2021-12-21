package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean isTop = false;

        for (int i = 0; i < firstArr.length ; i++) {
            int currentNum = firstArr[i];
            if (i == firstArr.length - 1){
                System.out.print(firstArr[firstArr.length - 1] + " ");
                break;
            }

            for (int j = i + 1; j < firstArr.length ; j++) {
                int nextNum = firstArr[j];
                if (currentNum > nextNum){
                    isTop = true;

                }else {
                    isTop = false;
                    break;
                }

            }
            if (isTop){
                System.out.print(currentNum + " ");
            }

        }
    }
}
