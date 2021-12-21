package MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());

        int [] wagons = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isFull = false;

        for (int i = 0; i < wagons.length ; i++) {
            if (people == 0){
                isFull = true;
                break;
            }
            while (wagons[i] < 4){
                wagons[i] += 1;
                people -= 1;
                if (people == 0){
                    isFull = true;
                    break;
                }
            }
        }

        if (isFull && wagons[wagons.length -1] < 4){
            System.out.println("The lift has empty spots!");
            for (int i = 0; i < wagons.length ; i++) {
                if (i == wagons.length - 1){
                    System.out.print(wagons[i]);
                }else {
                    System.out.print(wagons[i] + " ");
                }
            }

        }else if (!isFull && wagons[wagons.length - 1] == 4){
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
            for (int i = 0; i < wagons.length ; i++) {
                if (i == wagons.length - 1){
                    System.out.print(wagons[i]);
                }else {
                    System.out.print(wagons[i] + " ");
                }
            }

        }else {
            for (int i = 0; i < wagons.length ; i++) {
                if (i == wagons.length - 1){
                    System.out.print(wagons[i]);
                }else {
                    System.out.print(wagons[i] + " ");
                }
            }

        }
    }
}
