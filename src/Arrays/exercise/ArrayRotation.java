package Arrays.exercise;

import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] elements = input.split(" ");
        int rotation= Integer.parseInt(scanner.nextLine());
        String firstElement ="";

        for (int i = 0; i < rotation ; i++) {
            firstElement = elements[0];

            for (int j = 0; j < elements.length ; j++) {
                if (j == elements.length - 1){
                    break;
                }
                elements[j] = elements[j + 1];

            }
            elements[elements.length - 1] = firstElement;

        }

        for (String elementsArr:elements) {

            System.out.print(elementsArr + " ");
        }
    }
}
