package BasicSyntax.exercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double sumCoins = 0;

        while (!input.equals("Start")){
            double coins = Double.parseDouble(input);
            if (coins != 0.1 && coins != 0.2 && coins != 0.5 && coins != 1 && coins != 2){
                System.out.printf("Cannot accept %.2f%n", coins);

            }else {
            sumCoins += coins;
            }

            input = scanner.nextLine();

        }
        double product = 0;
        boolean isBought = false;
        String input2 = scanner.nextLine();

        while (!input2.equals("End") ){
            switch (input2){
                case "Nuts":
                    product = 2.0;
                    if (product > sumCoins){
                        System.out.println("Sorry, not enough money");
                        input2 = scanner.nextLine();
                        continue;
                    }
                    isBought = true;
                    sumCoins = sumCoins - product;
                    break;
                case "Water":
                    product = 0.7;
                    if (product > sumCoins){
                        System.out.println("Sorry, not enough money");
                        input2 = scanner.nextLine();
                        continue;
                    }
                    isBought = true;
                    sumCoins = sumCoins - product;
                    break;
                case "Crisps":
                    product = 1.5;
                    if (product > sumCoins){
                        System.out.println("Sorry, not enough money");
                        input2 = scanner.nextLine();
                        continue;
                    }
                    isBought = true;
                    sumCoins = sumCoins - product;
                    break;
                case "Soda":
                    product = 0.8;
                    if (product > sumCoins){
                        System.out.println("Sorry, not enough money");
                        input2 = scanner.nextLine();
                        continue;
                    }
                    isBought = true;
                    sumCoins = sumCoins - product;
                    break;
                case "Coke":
                    product = 1.0;
                    if (product > sumCoins){
                        System.out.println("Sorry, not enough money");
                        input2 = scanner.nextLine();
                        continue;
                    }
                    isBought = true;
                    sumCoins = sumCoins - product;
                    break;
            }

            if (isBought ){
                System.out.printf("Purchased %s%n", input2);

            }else if (sumCoins < product){
                System.out.println("Sorry, not enough money");
                break;
            }else if (!isBought){
                System.out.println("Invalid product");
            }


            input2 = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", sumCoins);
    }
}
