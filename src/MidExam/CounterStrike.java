package MidExam;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        int counter =0;

        while (!input.equals("End of battle") && energy > 0){
            int enemyPower = Integer.parseInt(input);
            if (enemyPower > energy){
                break;
            }
            counter++;
            energy -= enemyPower;
            if (counter % 3 == 0){
                energy += counter;
            }
            input = scanner.nextLine();
        }

        if (energy <= 0){
            energy = 0;
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", counter, energy);
        }else {
            System.out.printf("Won battles: %d. Energy left: %d", counter, energy);
        }
    }
}
