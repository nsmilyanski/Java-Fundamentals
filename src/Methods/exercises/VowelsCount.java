package Methods.exercises;

import java.util.Locale;
import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();

        String output = countSingleString(input);

        System.out.println(output.length());
    }
    private static String countSingleString(String input){
        String singleString = "";
        for (int i = 0; i < input.length() ; i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'o'
            || input.charAt(i) == 'u'|| input.charAt(i) == 'y' || input.charAt(i) == 'i' ){
                singleString += input.charAt(i);
            }

        }
        return singleString;
    }
}
