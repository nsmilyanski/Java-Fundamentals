package Methods.lab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantityNum = Integer.parseInt(scanner.nextLine());

        Orders(product, quantityNum);



    }
    public static void Orders(String product, double quantity){
        switch (product){
            case "coffee":
                quantity *= 1.50;
                System.out.printf("%.2f", quantity);
                break;
            case "water":
                quantity *= 1.00;
                System.out.printf("%.2f", quantity);
                break;
            case "coke":
                quantity *= 1.40;
                System.out.printf("%.2f", quantity);
                break;
            case "snacks":
                quantity *= 2.00;
                System.out.printf("%.2f", quantity);
                break;
        }
    }
        }
