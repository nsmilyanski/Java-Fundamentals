package ExamPreparation;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder sb = new StringBuilder(text);
        String command = scanner.nextLine();

        while (!command.equals("Done")){
            String[] inputArr = command.split("\\s+");
            String commands = inputArr[0];
            switch (commands){
                case "TakeOdd":
                    StringBuilder bufer = new StringBuilder();
                        for (int i = 0; i < sb.length(); i++) {
                            if (i % 2 == 1) {
                                bufer.append(sb.charAt(i));
                            }
                        }
                        sb = bufer;
                    System.out.println(sb);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(inputArr[1]);
                    int lastIndex =  startIndex + Integer.parseInt(inputArr[2]);

                    sb.delete(startIndex, lastIndex);
                    System.out.println(sb);
                    break;
                case "Substitute":

                    String forReplace = inputArr[1];
                    String replacer = inputArr[2];
                    int length = forReplace.length();
                    boolean inLoop = false;

                    if (sb.toString().contains(forReplace)){
                      inLoop = true;
                      sb = new StringBuilder(sb.toString().replaceAll(forReplace, replacer));
                    }
                    if (inLoop){
                    System.out.println(sb);
                    }else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }


            command = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", sb);
    }
}
