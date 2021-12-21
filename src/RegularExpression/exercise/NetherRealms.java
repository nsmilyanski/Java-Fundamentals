package RegularExpression.exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] textArr = scanner.nextLine().split(",\\s+");

        String regexLetter = "([^0-9\\/\\*\\,\\+\\.-])";
        Pattern patternLetter = Pattern.compile(regexLetter);

        String regexDigit = "[\\-\\+]?([0-9]+)[.]?[0-9]*";
        Pattern patternDigit = Pattern.compile(regexDigit);

        String regexMultiply = "[*]";
        Pattern patternMultiply = Pattern.compile(regexMultiply);

        String regexDividing = "[\\/]";
        Pattern patternDividing = Pattern.compile(regexDividing);

        Map<String, List<Double>> demonsMap = new TreeMap<>();

        for (int i = 0; i < textArr.length; i++) {
            int healt = 0;
            double damage = 0.00;
            int multiplyCount = 0;
            int dividingCount = 0;
            boolean isMultiply = false;
            boolean isDividing = false;

            String currentDemon = textArr[i].replaceAll(" ", "");
            Matcher matcherLetter = patternLetter.matcher(currentDemon);

            while (matcherLetter.find()){
                char symbol = matcherLetter.group().charAt(0);
                healt += symbol;
            }
            Matcher matcherDigit = patternDigit.matcher(currentDemon);

            while (matcherDigit.find()){
                double currentDigit = Double.parseDouble(matcherDigit.group());
                damage += currentDigit;
            }

            Matcher matcherMultiply = patternMultiply.matcher(currentDemon);
                while (matcherMultiply.find()){
                    multiplyCount++;
                isMultiply = true;
                }

            Matcher matcherDividing = patternDividing.matcher(currentDemon);
                while (matcherDividing.find()){
                    dividingCount++;
                    isDividing = true;
                }


            if (isMultiply){
                multiplyCount *= 2;
                damage *= multiplyCount;
            }
            if (isDividing){
                dividingCount *= 2;
                damage /= dividingCount;
            }
            demonsMap.put(currentDemon, new ArrayList<>());
            demonsMap.get(currentDemon).add(healt * 1.00);
            demonsMap.get(currentDemon).add(damage);
        }

        demonsMap.entrySet()
                .forEach(demons -> System.out.printf("%s - %.0f health, %.2f damage%n",
                        demons.getKey(), demons.getValue().get(0), demons.getValue().get(1)));
    }
}
