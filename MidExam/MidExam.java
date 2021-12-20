package MidExam;

import java.util.Scanner;

public class MidExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;


        String command = scanner.nextLine();
        while (!command.equals("special") && !command.equals("regular")){
        double price = Double.parseDouble(command);
        if (price < 0){
            System.out.println("Invalid price!");
            command = scanner.nextLine();
            continue;
        }
        sum += price;

            command = scanner.nextLine();
        }

        if (command.equals("special") && sum != 0){
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", sum);
            System.out.printf("Taxes: %.2f$%n", sum * 0.20);
            sum = sum + sum * 0.20;
            sum *= 0.90;
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", sum);
        }else if (command.equals("regular")&& sum != 0){
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", sum);
            System.out.printf("Taxes: %.2f$%n", sum * 0.20);
            sum = sum + sum * 0.20;
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", sum);
        }else {
            System.out.println("Invalid order!");
        }
    }
}
