package DataTypesandVariables.exersice;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int spice = Integer.parseInt(scanner.nextLine());
        int counterDays = 0;
        int mineSpice =0;

        while (spice >= 100){
        int extractSpice =0;
            counterDays++;
            extractSpice = spice - 26;
            mineSpice += extractSpice;
            spice -= 10;

        }
        System.out.println(counterDays);
        if (mineSpice >= 26){
            mineSpice -= 26;
        }
        System.out.println(mineSpice);
    }
}
