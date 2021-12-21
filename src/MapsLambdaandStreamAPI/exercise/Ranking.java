package MapsLambdaandStreamAPI.exercise;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        Map<String, String> modulsMap = new HashMap<>();
        Map<String, Integer> studentsPoint = new HashMap<>();
        Map<String, List<String>> languagePoints = new HashMap<>();

        while (!input1.equals("end of contests")){
            String [] inputArr = input1.split(":");
            modulsMap.put(inputArr[0], inputArr[1]);
            input1 = scanner.nextLine();
        }
        String input2 = scanner.nextLine();

        while (!input2.equals("end of submissions")){
            String[] inputArray = input2.split("=>");
            String kay = inputArray[0];
            String password = inputArray[1];
            String name = inputArray[2];
            int points = Integer.parseInt(inputArray[3]);
            String pointsStr = inputArray[3];
            if (modulsMap.containsKey(kay)&& password.equals(modulsMap.get(kay))){
                if (!studentsPoint.containsKey(kay)){
                    studentsPoint.put(kay, points);
                }else {
                    studentsPoint.put(kay, studentsPoint.get(kay) + points);
                }
                if (!languagePoints.containsKey(name)){
                    languagePoints.put(name, new ArrayList<>());
                    languagePoints.get(name).add(kay);
                    languagePoints.get(name).add(pointsStr);
                }else {
                    if (languagePoints.get(name).contains(kay)){
                        if (Integer.parseInt(languagePoints.get(name).get(1)) < points){
                            languagePoints.get(name).set(1, pointsStr);

                        }
                    }else {
                        languagePoints.get(name).add(kay);
                        languagePoints.get(name).add(pointsStr);
                    }

                }
            }

            input2 = scanner.nextLine();
        }

        String bestStudent = "";
        int bestPoints = 0;

        for (Map.Entry<String, Integer> entry : studentsPoint.entrySet()) {
            if (entry.getValue() > bestPoints){
                bestPoints = entry.getValue();
                bestStudent = entry.getKey();
            }

        }
        for (Map.Entry<String, List<String>> entry : languagePoints.entrySet()) {

        }
        System.out.printf("Best candidate is %s with total %d points.%n", bestStudent, bestPoints);
        System.out.println("Ranking:");

        languagePoints.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().get(1).compareTo(e1.getValue().get(1)))
                .forEach(entry -> {
            System.out.println("#" + entry.getKey());
            entry.getValue().forEach(element -> System.out.printf(""));
        });
    }
}
