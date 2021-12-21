package testing;

import java.util.Scanner;

public class ActivationKey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Generate")){
            String[] tokenArr = input.split(">>>");

            String command = tokenArr[0];

            switch (command){
                case "Contains":
                    String substring = tokenArr[1];
                    if (activationKey.contains(substring)){
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    }else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String cases = tokenArr[1];
                    int startIndex = Integer.parseInt(tokenArr[2]);
                    int endIndex = Integer.parseInt(tokenArr[3]);

                            String firstHalf = activationKey.substring(0, startIndex);
                            String secondHalf = activationKey.substring(startIndex, endIndex);
                            String thirdHalf = activationKey.substring(endIndex);
                    switch (cases){
                        case "Upper":
                            secondHalf = secondHalf.toUpperCase();
                            activationKey = firstHalf + secondHalf + thirdHalf;
                            System.out.println(activationKey);
                            break;
                        case "Lower":
                            secondHalf = secondHalf.toLowerCase();
                            activationKey = firstHalf + secondHalf + thirdHalf;
                            System.out.println(activationKey);
                            break;
                    }
                    break;
                case "Slice":
                    int startDelete = Integer.parseInt(tokenArr[1]);
                    int endDelete = Integer.parseInt(tokenArr[2]);
                    activationKey = new StringBuilder(activationKey).delete(startDelete, endDelete).toString();
                    System.out.println(activationKey);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s%n", activationKey);
    }
}
