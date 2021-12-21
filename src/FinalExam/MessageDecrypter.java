package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "^([\\$]|[\\%])(?<word>[A-Z][a-z]{2,})\\1: \\[(?<firstN>[0-9]{2,3})\\]\\|\\[(?<secondN>[0-9]{2,3})\\]\\|\\[(?<thirdN>[0-9]{2,3})\\]\\|$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = null;

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();

            matcher = pattern.matcher(text);

            String word = "";

            String asciiSymbols = "";

            if (matcher.find()){

                word = matcher.group("word");

                int a = Integer.parseInt(matcher.group("firstN"));
                int b = Integer.parseInt(matcher.group("secondN"));
                int c = Integer.parseInt(matcher.group("thirdN"));

                System.out.printf("%s: %c%c%c%n", word, a, b,c);



            }else {
                System.out.println("Valid message not found!");
            }

        }
    }
}
