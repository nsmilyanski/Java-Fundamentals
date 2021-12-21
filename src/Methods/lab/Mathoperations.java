package Methods.lab;

import java.util.Scanner;

public class Mathoperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        char symbol = scanner.nextLine().charAt(0);
        double b = Double.parseDouble(scanner.nextLine());

        calculate(a, symbol, b);

    }
    public static double calculate (double a, char symbol, double b){
        double result = 0.0;
        if (symbol == '/'){
            result = a / b;

        }else if (symbol == '*'){
            result = a * b;

        }else if (symbol == '+'){
            result = a + b;

        }else if (symbol == '-'){
            result = a - b;
        }
        System.out.printf("%.0f", result);
        return result;
    }

}
