package MapsLambdaandStreamAPI.lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] wordsArr = scanner.nextLine().split(" ");

        LinkedHashMap<String, Integer> countLengthMap = new LinkedHashMap<>();

        for (int i = 0; i < wordsArr.length ; i++) {
            String key = wordsArr[i];
            int value = key.length();
            countLengthMap.put(key, value);
        }

        for (Map.Entry<String, Integer> integerEntry: countLengthMap.entrySet()) {
            if (integerEntry.getValue() % 2 == 0){
                System.out.println(integerEntry.getKey());
            }

        }
    }
}
