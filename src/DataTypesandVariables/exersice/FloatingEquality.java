package DataTypesandVariables.exersice;

import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double first = Double.parseDouble(scanner.nextLine());
        double second = Double.parseDouble(scanner.nextLine());

        if (first > second){
            if (first - second <= 0.000001){
                System.out.println("True");
            }else {
                System.out.println("False");
            }
        }  if (first < second){
            if (second - first <= 0.000001){
                System.out.println("True");
            }else {
                System.out.println("False");
            }
        }
    }
}
