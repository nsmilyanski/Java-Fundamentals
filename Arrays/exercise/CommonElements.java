package Arrays.exercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine();
        String secondInput = scanner.nextLine();

        String[] firstArr = firstInput.split(" ");
        String[] secondArr = secondInput.split(" ");

        for (String firstElements:secondArr) {

            for (String secondElements: firstArr) {
                if (firstElements.equals(secondElements)){
                    System.out.print(firstElements + " ");
                }
            }

        }
    }
}
