package DataTypesandVariables.exersice;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        double volume = 0;
        double maxValue = Double.MIN_VALUE;
        String biggestKeg = "";

        for (int i = 1; i <= num ; i++) {
            String modelKegs = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            double height = Double.parseDouble(scanner.nextLine());
            volume = Math.PI * Math.pow(radius, 2) * height;
            if (volume > maxValue){
                maxValue = volume;
                biggestKeg = modelKegs;
            }


        }
        System.out.println(biggestKeg);
    }
}
