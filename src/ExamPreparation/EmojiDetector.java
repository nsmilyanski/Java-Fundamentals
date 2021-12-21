package ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([\\:]{2}|[\\*]{2})(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);

        String text = scanner.nextLine();

        Matcher matcher = pattern.matcher(text);

        String regexDigit = "[0-9]";
        Pattern pattern1 = Pattern.compile(regexDigit);
        Matcher matcherDigit = pattern1.matcher(text);

        int coolThreshold = 1;

        while (matcherDigit.find()){
            int digit = Integer.parseInt(matcherDigit.group());
            coolThreshold *= digit;
        }
        int counter = 0;
        List<String> emojiList = new ArrayList<>();

        while (matcher.find()){
            String emoji = matcher.group("emoji");
            int sum = 0;
            counter++;

            for (int i = 0; i < emoji.length(); i++) {
                int symbolValue = emoji.charAt(i);
                sum += symbolValue;
            }
            if (sum >= coolThreshold){
                emojiList.add(matcher.group());
            }
        }
        System.out.printf("Cool threshold: %d%n", coolThreshold);

        System.out.printf("%d emojis found in the text. The cool ones are:%n",counter );
        emojiList.forEach(emoji -> System.out.println(emoji));


    }
}
