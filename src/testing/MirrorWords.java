package testing;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([@|#])(?<pears>[A-Za-z]{3,})\\1\\1(?<secondPear>[A-Za-z]{3,})\\1";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        int counter = 0;

        List<String> peirsList = new ArrayList<>();

        while (matcher.find()){
            counter++;

            String firstWord = matcher.group("pears");
            String secondWord = new StringBuilder(matcher.group("secondPear")).reverse().toString();

            if (firstWord.equals(secondWord)){
                peirsList.add(firstWord);
                peirsList.add(matcher.group("secondPear"));
            }

        }
        if (counter == 0){
            System.out.println("No word pairs found!");
        }else {
            System.out.printf("%d word pairs found!%n", counter);
        }
        if (peirsList.isEmpty()){
            System.out.println("No mirror words!");
        }else {

            System.out.println("The mirror words are:");

            for (int i = 0; i < peirsList.size(); i += 2) {
                if (i == peirsList.size() - 1) {
                    break;
                } else if (i == peirsList.size() - 2) {
                    System.out.printf("%s <=> %s%n", peirsList.get(i), peirsList.get(i + 1));
                } else {
                    System.out.printf("%s <=> %s, ", peirsList.get(i), peirsList.get(i + 1));
                }
            }
        }


    }
}
