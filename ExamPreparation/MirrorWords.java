package ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([@|#])(?<word>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        List<String> wordPairsList = new ArrayList<>();

        int counterPairs = 0;

        while (matcher.find()){
            counterPairs++;
            String firstWord = matcher.group("word");
            String secondWord = matcher.group("secondWord");

            String reverseStr = new StringBuilder(secondWord).reverse().toString();
            if (firstWord.equals(reverseStr)) {
                wordPairsList.add(firstWord);
                wordPairsList.add(secondWord);
            }

        }
        if (counterPairs == 0){
            System.out.println("No word pairs found!");
        }else {
            System.out.printf("%d word pairs found!%n", counterPairs);
        }

        if (wordPairsList.size() == 0){
            System.out.println("No mirror words!");
        }else {
            System.out.println("The mirror words are:");

            for (int i = 0; i < wordPairsList.size() ; i+=2) {
                if (wordPairsList.size() - 1 == i){
                    break;
                }

                if (i == wordPairsList.size() - 2){
                System.out.printf("%s <=> %s", wordPairsList.get(i), wordPairsList.get(i + 1));
                }else {
                    System.out.printf("%s <=> %s, ", wordPairsList.get(i), wordPairsList.get(i + 1));
                }
            }
        }
    }
}
