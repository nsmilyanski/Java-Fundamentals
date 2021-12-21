package Methods.exercises;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int[] tribonacciArr = new int[num];

        printTribonacciSequence(tribonacciArr, num);



    }

    private static void printTribonacciSequence(int[] tribonacciArr, int num) {

        for (int i = 0; i < tribonacciArr.length; i++) {
           if (i == 0){
               tribonacciArr[i] = i + 1;
           }else if (i < 3 ){
               tribonacciArr[i] = i;
           }else {
               tribonacciArr[i] = tribonacciArr[i - 1] + tribonacciArr[i - 2] + tribonacciArr[i - 3];
           }

        }

        for (int i = 0; i < tribonacciArr.length ; i++) {
            System.out.print(tribonacciArr[i] + " ");
        }
    }
}
