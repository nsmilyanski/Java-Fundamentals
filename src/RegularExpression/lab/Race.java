package RegularExpression.lab;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regexLetters = "(?<letters>[A-Za-z])";
        String regexDigits = "\\d";
        Pattern lettersPattern = Pattern.compile(regexLetters);
        Pattern digitPattern = Pattern.compile(regexDigits);

        List<String> inputList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> racersMap = new LinkedHashMap<>();

        for (int i = 0; i < inputList.size(); i++) {
            racersMap.put(inputList.get(i), 0);

        }

        String input = scanner.nextLine();

        while (!input.equals("end of race")) {
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            Matcher lettersMatcher = lettersPattern.matcher(input);
            Matcher digitMatcher = digitPattern.matcher(input);

            while (lettersMatcher.find()) {
                sb.append(lettersMatcher.group());
            }
            while (digitMatcher.find()) {
                sum += Integer.parseInt(digitMatcher.group());
            }
            String nameRacer = sb.toString();
            if (racersMap.containsKey(nameRacer)) {
                racersMap.put(nameRacer, racersMap.get(nameRacer) + sum);
            }

            input = scanner.nextLine();
        }

        List<String> firstThreeNames = racersMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3) //получавам мап с 3 записа
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.printf("1st place: %s%n", firstThreeNames.get(0));
        System.out.printf("2nd place: %s%n", firstThreeNames.get(1));
        System.out.printf("3rd place: %s", firstThreeNames.get(2));
    }
}
