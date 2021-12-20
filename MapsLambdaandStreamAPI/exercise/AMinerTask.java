package MapsLambdaandStreamAPI.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> minerValueMap = new LinkedHashMap<>();

        while (!input.equals("stop")){
            String key = input;
            int keyValue = Integer.parseInt(scanner.nextLine());

            if (!minerValueMap.containsKey(key)){
                minerValueMap.put(key, keyValue);
            }else {
                minerValueMap.put(key, minerValueMap.get(key) + keyValue);
            }
            input = scanner.nextLine();
        }

        minerValueMap.entrySet().forEach(entry -> System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue()));
    }
}
