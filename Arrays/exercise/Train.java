package Arrays.exercise;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] wagons = new int[n];
            int counter = 0;
            int sum = 0;


        for (int numbers:wagons) {
            int people = Integer.parseInt(scanner.nextLine());
            wagons[counter] = people;
            counter++;
            sum += people;

        }
        for (int i = 0; i < wagons.length; i++) {
            System.out.print(wagons[i] +" ");

        }
        System.out.println();
        System.out.println(sum);
    }
}
