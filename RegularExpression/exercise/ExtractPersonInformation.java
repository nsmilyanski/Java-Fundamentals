package RegularExpression.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regexName = "@(?<name>[\\w]+)\\|";
        Pattern pattern = Pattern.compile(regexName);

        String regexAge = "#(?<age>[0-9]+)\\*";
        Pattern patternAge = Pattern.compile(regexAge);

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();

            String name = "";
            String age = "";

            Matcher matcherName = pattern.matcher(text);
            if (matcherName.find()){
            name = matcherName.group("name");
            }

            Matcher matcherAge = patternAge.matcher(text);

            if (matcherAge.find()){
            age = matcherAge.group("age");

            }


            System.out.printf("%s is %s years old.%n", name, age);

        }


    }
}
