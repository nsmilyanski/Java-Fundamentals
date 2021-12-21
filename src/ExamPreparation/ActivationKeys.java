package ExamPreparation;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder sb = new StringBuilder(text);

        String input = scanner.nextLine();

        while (!input.equals("Generate")){
            String[] inputArr = input.split(">+");

            String command = inputArr[0];

            switch (command){
                case "Contains":
                    String contain = inputArr[1];
                    int startIndex = sb.indexOf(contain);
                    int lastIndex = sb.lastIndexOf(contain);
                    if (startIndex != -1){
                        System.out.printf("%s contains %s%n", sb, contain);
                    }else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperOrLower = inputArr[1];
                    int start = Integer.parseInt(inputArr[2]);
                    int last = Integer.parseInt(inputArr[3]);
                    switch (upperOrLower){
                        case "Upper":
                            String toUpper = sb.substring(start, last).toUpperCase();
                            sb.replace(start, last, toUpper);
                        System.out.println(sb);
                            break;
                        case "Lower":
                          String toLower = sb.substring(start, last).toLowerCase();
                          sb.replace(start, last, toLower);
                            System.out.println(sb);
                            break;
                    }
                    break;
                case "Slice":
                    int startI = Integer.parseInt(inputArr[1]);
                    int lastI = Integer.parseInt(inputArr[2]);
                    sb.delete(startI, lastI);
                    System.out.println(sb);
                    break;
            }




            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", sb);
    }
}
