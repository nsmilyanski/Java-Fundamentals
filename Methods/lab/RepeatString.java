package Methods.lab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         String input = scanner.nextLine();
         int interation = Integer.parseInt(scanner.nextLine());

         RepeatingString(input, interation);

    }
    public static String RepeatingString( String input, int num){
        for (int i = 0; i < num ; i++) {
            System.out.print(input);
        }
        return input;
    }
}
