 package Methods.exercises;

import java.util.Scanner;

public class SmallestofThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        getTheSmallestNum(a, b, c);


    }
    private static void getTheSmallestNum(int a, int b, int c){
        if (a < b && a < c){
            System.out.println(a);
        }else if (b < a && b < c){
            System.out.println(b);
        }else {
            System.out.println(c);
        }

    }
}
