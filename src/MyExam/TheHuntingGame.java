package MyExam;

import java.util.Scanner;

public class TheHuntingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int numPlayers = Integer.parseInt(scanner.nextLine());
        double groupEnergy = Double.parseDouble(scanner.nextLine());
        double waterPerDay = Double.parseDouble(scanner.nextLine());
        double foodPerDay = Double.parseDouble(scanner.nextLine());

        double totalWater = days * numPlayers * waterPerDay;
        double totalFood = days * numPlayers * foodPerDay;

        for (int i = 1; i <= days ; i++) {
            double enemyEnergy = Double.parseDouble(scanner.nextLine());
            groupEnergy -= enemyEnergy;
            if (groupEnergy <= 0){
                break;
            }

            if (i % 2 == 0){
                groupEnergy += groupEnergy * 0.05;
                totalWater *= 0.70;
            }
            if (i % 3 == 0){
                groupEnergy += groupEnergy * 0.10;
                totalFood -= (totalFood / numPlayers);
            }
            if (groupEnergy <= 0){
                break;
            }

        }

        if (groupEnergy > 0){
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupEnergy);
        }else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.",
                    totalFood, totalWater);
        }
    }
}
