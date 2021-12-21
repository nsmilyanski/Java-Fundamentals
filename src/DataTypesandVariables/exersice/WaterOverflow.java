package DataTypesandVariables.exersice;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        int tank = 0;

        for (int i = 1; i <= lines ; i++) {
        int liters = Integer.parseInt(scanner.nextLine());
            if (tank + liters <= 255){
            tank += liters;
            }else {
                System.out.println("Insufficient capacity!");
            }

        }
        System.out.println(tank);
    }
}
