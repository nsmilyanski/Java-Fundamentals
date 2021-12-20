package ObjectandClasses.lab;

import java.util.Random;
import java.util.Scanner;

public class  RandomizeWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");

        Random random = new Random();

        for (int i = 0; i < inputArr.length; i++) {
            int indexX = random.nextInt(inputArr.length);
            int indexY = random.nextInt(inputArr.length);

            String oldWord = inputArr[indexX];
            inputArr[indexX] = inputArr[indexY];
            inputArr[indexY] = oldWord;

        }
        System.out.println(String.join(System.lineSeparator(), inputArr));


    }
}
