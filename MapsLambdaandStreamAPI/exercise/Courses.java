package MapsLambdaandStreamAPI.exercise;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> programMap = new LinkedHashMap<>();
        int countCourses = 1;

        while (!input.equals("end")){
            String [] inputArr = input.split(" : ");
            String course = inputArr[0];
            String nameStudent = inputArr[1];
            if (!programMap.containsKey(course)){
                programMap.put(course, new ArrayList<>());
                programMap.get(course).add(nameStudent);
            }else {
                programMap.get(course).add(nameStudent);

            }

            input = scanner.nextLine();
        }
        programMap.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(pair -> {
                    System.out.printf("%s: %d%n", pair.getKey(), pair.getValue().size());
                    pair.getValue().stream().sorted().forEach(el -> System.out.printf("-- %s%n", el));
                });


    }
}
