package ExamPreparation;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String code = scanner.nextLine();
        StringBuilder sb = new StringBuilder(code);

        String input = scanner.nextLine();

        while (!input.equals("Decode")){
            String [] commandArr = input.split("\\|");
            String command = commandArr[0];

            switch (command){
                case "Move":
                    int numOfLetters = Integer.parseInt(commandArr[1]);
                    for (int i = 0; i < numOfLetters; i++) {
                    char symbol = sb.charAt(0);
                        sb.deleteCharAt(0);
                        sb.append(symbol);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandArr[1]);
                    String value = commandArr[2];
                    sb.insert(index, value);
                    break;
                case "ChangeAll":
                    char oldSymbol = commandArr[1].charAt(0);
                    char newSymbol = commandArr[2].charAt(0);

                    for (int i = 0; i < sb.length(); i++) {
                        if (oldSymbol == sb.charAt(i)) {
                        int indexOfSB = sb.indexOf(String.valueOf(oldSymbol));
                        sb.deleteCharAt(indexOfSB);
                        sb.insert(indexOfSB, newSymbol);
                        }
                    }

                    break;
            }


            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", sb);
    }
}
