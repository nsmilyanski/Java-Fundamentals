package MapsLambdaandStreamAPI.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> parkingMap = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String [] inputArr = scanner.nextLine().split("\\s+");
            String command = inputArr[0];
            String key = inputArr[1];

            if (command.equals("register")){
            String keyValue = inputArr[2];
                if (!parkingMap.containsKey(key)){
                    parkingMap.put(key, keyValue);
                    System.out.printf("%s registered %s successfully%n", key, keyValue);
                }else {
                    System.out.printf("ERROR: already registered with plate number %s%n", keyValue);
                }

            }else if (command.equals("unregister")){
                if (!parkingMap.containsKey(key)){
                    System.out.printf("ERROR: user %s not found%n", key);
                }else {
                    System.out.printf("%s unregistered successfully%n", key);
                    parkingMap.remove(key);
                }

            }
        }

        parkingMap.entrySet().forEach(entry -> System.out.printf("%s => %s%n", entry.getKey(), entry.getValue()));
    }
}
