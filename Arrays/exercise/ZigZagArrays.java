package Arrays.exercise;

import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] firstArr = new String[n];
        String[] secondArr = new String[n];

        for (int i = 0; i < n ; i++) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            if (i % 2 == 0){
                firstArr[i] = inputArr[0];
                secondArr[i] = inputArr[1];
            }else {
                firstArr[i] = inputArr[1];
                secondArr[i] = inputArr[0];
            }

        }
        for (int k = 0; k < n  ; k++) {
            System.out.print(firstArr[k] + " ");
        }
        System.out.println();
        for (int j= 0; j < n ; j++) {
            System.out.print(secondArr[j] + " ");

        }
    }
}
