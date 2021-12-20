package TextProcessing.exercise;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder(input);
        int strength = 0;

        for (int i = 0; i < sb.length(); i++) {
            char symbol = sb.charAt(i);

            if (symbol == '>'){
                 strength += Integer.parseInt(String.valueOf(sb.charAt(i + 1)));
                 sb.deleteCharAt(i + 1);
                 strength--;
            }
            if (symbol != '>' && strength > 0){
                sb.deleteCharAt(i);
                strength--;
                i--;
            }


        }
        System.out.println(sb);
    }
}
