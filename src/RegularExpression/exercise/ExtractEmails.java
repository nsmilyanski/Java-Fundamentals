package RegularExpression.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([\\s])(?<email>(?<user>[a-z0-9]+[\\\\.\\\\_-]?[a-z0-9]+)@(?<host>[a-z]+[\\.-]?[a-z]+[\\.-]?[a-z]+[\\.][a-z]+)\\b)";
        Pattern pattern = Pattern.compile(regex);

        String text = scanner.nextLine();

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            String email = matcher.group("email");
            System.out.println(email);
        }
    }
}
