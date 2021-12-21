package testing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String text = scanner.nextLine();

        String regex = "(?<word>[^0-9]+)(?<num>[0-9]+)";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);
            StringBuilder sb = new StringBuilder();
        while (matcher.find()){
            String gamingWord = matcher.group("word").toUpperCase();
            int num = Integer.parseInt(matcher.group("num"));

            for (int i = 0; i < num; i++) {
                sb.append(gamingWord);
            }


        }

        StringBuilder current = new StringBuilder();
        for (int j = 0; j < sb.length(); j++) {
            char symbol = sb.charAt(j);
            if (!current.toString().contains(symbol + "")){
                current.append(symbol);
            }

        }
        System.out.println("Unique symbols used: " + current.length());
        System.out.println(sb);
    }
}
