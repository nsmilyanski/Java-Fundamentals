package Arrays.lab;

import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] valuesArray = input.split(" ");

        int[] numArr = new int[valuesArray.length];
        int sum = 0;

        for (int i = 0; i < numArr.length ; i++) {
            numArr[i] = Integer.parseInt(valuesArray[i]);
            if (numArr[i] % 2 == 0){
                sum += numArr[i];

            }

        }
        System.out.println(sum);

    }
}
