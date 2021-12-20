package Arrays.lab;

import java.util.Scanner;

public class EvenandOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] valuesArray = input.split(" ");

        int[] numArr = new int[valuesArray.length];
        int evenNum = 0;
        int oddSum = 0;

        for (int i = 0; i < numArr.length ; i++) {
            numArr[i] = Integer.parseInt(valuesArray[i]);
            if (numArr[i] % 2 == 0){
                evenNum += numArr[i];
            }else {
                oddSum += numArr[i];

            }

        }
        System.out.println(evenNum - oddSum);
    }
}
