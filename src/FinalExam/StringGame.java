package FinalExam;

import java.util.Scanner;

public class StringGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Done")){
            String[] tokenArr = input.split("\\s+");
            String command = tokenArr[0];

            switch (command){
                case "Change":
                    char symbol = tokenArr[1].charAt(0);
                    char replacementChar = tokenArr[2].charAt(0);

                    text = text.replace(symbol , replacementChar);

                    System.out.println(text);
                    break;
                case "Includes":
                    String includesSubstring = tokenArr[1];

                    if (text.contains(includesSubstring)) {
                        System.out.println("True");
                    }else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String endSubstring = tokenArr[1];

                    if (text.endsWith(endSubstring)){
                        System.out.println("True");
                    }else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    text = text.toUpperCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    String findChar = tokenArr[1];
                    int indexFind = new StringBuilder(text).indexOf(findChar);
                    System.out.println(indexFind);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokenArr[1]);
                    int count = Integer.parseInt(tokenArr[2]);

                    text = text.substring(startIndex, (startIndex + count));
                    System.out.println(text);
                    break;
            }



            input = scanner.nextLine();
        }
    }
}
