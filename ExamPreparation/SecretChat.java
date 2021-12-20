package ExamPreparation;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String input = scanner.nextLine();
        String secretText = text;

        while (!input.equals("Reveal")){
            String[] tokensArr = input.split(":\\|:");
            String command = tokensArr[0];

            switch (command){
                case "InsertSpace":
                    int index = Integer.parseInt(tokensArr[1]);
                    secretText = new StringBuilder(secretText).insert(index, ' ').toString();
                    System.out.println(secretText);
                    break;
                case "Reverse":
                    String substring = tokensArr[1];
                    if (secretText.contains(substring)){
                        int startIndex = new StringBuilder(secretText).indexOf(substring);
                        secretText =  new StringBuilder(secretText).delete(startIndex, startIndex+substring.length()).toString();
                        substring = new StringBuilder(substring).reverse().toString();
                        secretText = secretText.concat(substring);
                    System.out.println(secretText);
                    }else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String subS = tokensArr[1];
                    String replacement = tokensArr[2];
                    secretText = secretText.replaceAll(subS, replacement);
                    System.out.println(secretText);
                    break;

            }



            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s%n", secretText);


    }
}
