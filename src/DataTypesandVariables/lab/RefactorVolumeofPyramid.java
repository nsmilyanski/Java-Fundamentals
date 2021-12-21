package DataTypesandVariables.lab;

import java.util.Scanner;

public class RefactorVolumeofPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        double v = 0;
        v = (length * width * height) / 3;

        System.out.print("Length: ");
        System.out.print("Width: ");
        System.out.print("Height: ");


        System.out.printf("Pyramid Volume: %.2f", v);


    }
}
