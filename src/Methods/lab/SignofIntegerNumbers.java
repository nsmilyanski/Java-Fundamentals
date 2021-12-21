package Methods.lab;

import java.util.Scanner;

public class SignofIntegerNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

          Num( num);

    }
    public static int Num (int num ){
        if (num < 0){
            System.out.printf("The number %d is negative.", num);

        }else if (num == 0){
            System.out.printf("The number %d is zero.", num);

        }else {
            System.out.printf("The number %d is positive.", num);

        }
        return num;
    }
}
