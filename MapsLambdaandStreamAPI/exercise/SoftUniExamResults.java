package MapsLambdaandStreamAPI.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> pointsMap = new TreeMap<>();
        Map<String, Integer> countTestMaps = new TreeMap<>();

        while (!input.equals("exam finished")){
            String [] inputArr = input.split("-");
            String name = inputArr[0];

            if (inputArr.length == 3){
            String language = inputArr[1];
            int points = Integer.parseInt(inputArr[2]);
                if (!pointsMap.containsKey(name)){
                    pointsMap.put(name, points);
                    if (!countTestMaps.containsKey(language)) {
                        countTestMaps.put(language, 1);
                    }else {
                        countTestMaps.put(language, countTestMaps.get(language) + 1);
                    }
                }else {
                    int currentPoint = pointsMap.get(name);
                    if (currentPoint < points){
                        pointsMap.put(name, points);
                    }
                    countTestMaps.put(language, countTestMaps.get(language) + 1);

                }

            }else {
                pointsMap.remove(name);

            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");

        pointsMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(element -> System.out.printf("%s | %d%n", element.getKey(), element.getValue()));
        System.out.println("Submissions:");
        countTestMaps.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(element-> System.out.printf("%s - %d%n", element.getKey(), element.getValue()));
    }
}
