package BasicSyntax.exercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
       String passWord = "";

        for (int i = name.length() - 1 ; i >= 0; i--) {
            char currentNum = name.charAt(i);
            passWord += currentNum;

        }
        String newPassword = passWord;
        String input = scanner.nextLine();
        int counter = 0;
        while (!input.equals(newPassword)){
            counter++;
            if (counter == 4){
                System.out.printf("User %s blocked!", name);
                break;
            }
            System.out.println("Incorrect password. Try again.");

            input = scanner.nextLine();

        }
        if (input.equals(newPassword)){
            System.out.printf("User %s logged in.", name);

        }
    }
}
