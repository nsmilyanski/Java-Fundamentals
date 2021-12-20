package testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regexEmoji = "([\\:]{2}|[\\*]{2})(?<emoji>[A-Z][a-z]{2,})\\1";

        Pattern patternEmoji = Pattern.compile(regexEmoji);

        String regexDigit = "[0-9]";

        Pattern patternDigit = Pattern.compile(regexDigit);

        Matcher matcherDigit = patternDigit.matcher(text);
        int threshold = 1;

        while (matcherDigit.find()){
            int digit = Integer.parseInt(matcherDigit.group());

            threshold *= digit;
        }

        Matcher matcher = patternEmoji.matcher(text);

        int counter = 0;

        List<String> emojiList = new ArrayList<>();

        while (matcher.find()){
            counter++;
            int asciiSum = 0;
            String emoji = matcher.group("emoji");

            for (int i = 0; i < emoji.length(); i++) {
                char symbol = emoji.charAt(i);

                asciiSum += symbol;
            }

            if (asciiSum >= threshold){
                emojiList.add(matcher.group());
            }
        }

        System.out.printf("Cool threshold: %d%n", threshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", counter);
        emojiList.forEach(entry -> System.out.printf("%s%n", entry));
    }
}
