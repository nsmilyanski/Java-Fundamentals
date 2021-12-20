package Methods.lab;

import java.util.Arrays;
import java.util.Scanner;

public class MultiplyEvensbyOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Math.abs(Integer.parseInt(scanner.nextLine()));

        int[] firstArr = new int[input];

        for (int i = firstArr.length - 1; i >= 0; i--) {
            firstArr[i] = input % 10;
            input = input / 10;

        }
        getMultipleOfEvensAndOdds(firstArr);

    }
    public static int  getMultipleOfEvensAndOdds(int [] Arr){
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < Arr.length; i++) {
            if (Arr[i] % 2 == 0){
                evenSum += Arr[i];
            }else {
                oddSum += Arr[i];
            }
        }
        System.out.println(evenSum * oddSum);
            return oddSum * evenSum;
    }
}
