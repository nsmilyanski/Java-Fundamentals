package testing;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Decode")){
            String[] inputArr = input.split("\\|");
            String command = inputArr[0];

            switch (command){
                case "Move":
                    int interations = Integer.parseInt(inputArr[1]);

                    for (int i = 0; i < interations; i++) {
                        char symbol = message.charAt(0);
                        message = message.substring(1);
                        message = message + symbol;
                    }
                    break;
                case "Insert":
                   int index = Integer.parseInt(inputArr[1]);
                   String value = inputArr[2];

                   String firstHalf = message.substring(0, index);
                   String secondHalf = message.substring(index);
                   message = firstHalf + value + secondHalf;

                    break;
                case "ChangeAll":
                    char substring = inputArr[1].charAt(0);
                    char  replacemant = inputArr[2].charAt(0);
                    message = message.replace(substring, replacemant);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s%n", message);
    }
}
