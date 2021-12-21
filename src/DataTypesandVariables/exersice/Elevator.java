package DataTypesandVariables.exersice;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());
        int counter = 0;


        while (numberOfPeople > 0){
            numberOfPeople = numberOfPeople - capacity;
            counter++;
        }
        System.out.println(counter);
    }
}
