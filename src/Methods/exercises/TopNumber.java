package Methods.exercises;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        printTopNumbers(n);

    }
    private static void printTopNumbers(int n){

        for (int i = 1; i <= n ; i++) {
        boolean isOddNum = false;
            int currentIndex = i;
            int currentnum = i;
            int currentnum2 = i;
            int sum = 0;

            while (currentnum2 > 0){
               sum += currentnum2 % 10;
               currentnum2 = currentnum2 / 10;
            }
            int isOdd = 0;
           while (currentnum > 0){
               isOdd = currentnum % 10;
               if (isOdd % 2 != 0){
                   isOddNum = true;
                   break;
               }
               currentnum /= 10;

           }
           if (sum % 8 == 0 && isOddNum){
               System.out.println(currentIndex);
           }

        }
    }
}
