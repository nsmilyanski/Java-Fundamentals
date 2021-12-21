package BasicSyntax.exercise;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int counter = 0;
        int firstNum = 0;
        int secondNum = 0;
        int thirdNum = 0;

        for (int i = 1; i <=3 ; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            counter++;
            if (counter == 1){
                firstNum = num;
            }else if (counter == 2){
                secondNum = num;
            }else {
                thirdNum = num;
            }

            if (maxValue<num){
                maxValue = num;
            }
            if (minValue>num){
                minValue = num;
            }
        }
        System.out.println(maxValue);
        if (firstNum != maxValue && firstNum != minValue){
            System.out.println(firstNum);
        }else if (secondNum != maxValue && secondNum != minValue){
            System.out.println(secondNum);
        }else {
            System.out.println(thirdNum);
        }
        System.out.println(minValue);
    }
}
