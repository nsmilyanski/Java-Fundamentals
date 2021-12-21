package Methods.lab;

import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());

        double result = RectangleArea(a, b);
        System.out.printf("%.0f", result);

    }
    public static double RectangleArea ( double a, double b){
        return a * b;
    }
}
