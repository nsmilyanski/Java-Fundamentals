package Methods.lab;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        switch (command){
            case "add":
                add(a, b);
                break;
            case "multiply":
                multiply(a, b);
                break;
            case "subtract":
                subtract(a, b);
                break;
            case "divide":
                divide(a, b);
                break;
        }
    }
    public static void add(int a, int b){
        int result = a + b;
        System.out.println(result);

    }
    public static void multiply(int a, int b){
        int result = a * b;
        System.out.println(result);

    }
    public static void subtract(int a, int b){
        int result = a - b;
        System.out.println(result);

    }
    public static void divide (int a, int b){
        int result = a / b;
        System.out.println(result);

    }

}
