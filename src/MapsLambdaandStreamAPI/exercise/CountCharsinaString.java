package MapsLambdaandStreamAPI.exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsinaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        Map<Character, Integer> characterCounterMap = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == ' '){
                continue;
            }
            if (!characterCounterMap.containsKey(currentChar)){
                characterCounterMap.put(currentChar, 1);
            }else {
                characterCounterMap.put(currentChar, characterCounterMap.get(currentChar) + 1);
            }

        }

        characterCounterMap.entrySet().forEach(entry -> System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue()));
    }
}
