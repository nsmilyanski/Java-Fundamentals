package MapsLambdaandStreamAPI.lab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
            LinkedHashMap<String, ArrayList<String>> words = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String fitst = scanner.nextLine();
            String second = scanner.nextLine();

            if (!words.containsKey(fitst)){
            words.put(fitst, new ArrayList<>());
            words.get(fitst).add(second);
            }else {
                words.get(fitst).add(second);
            }
        }
        for (Map.Entry<String, ArrayList<String>> entry : words.entrySet()){
            System.out.printf("%s - %s%n", entry.getKey(),
                    String.join(", ", entry.getValue()));
        }
    }
}
