package TextProcessing.lab;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        while (!input.equals("end")){
        StringBuilder sb = new StringBuilder();
            sb = sb.append(input);
            sb = sb.reverse();
            System.out.printf("%s = %s%n", input, sb);
            input = scanner.nextLine();
        }
    }
}
