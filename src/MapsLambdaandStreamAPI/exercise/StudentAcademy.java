package MapsLambdaandStreamAPI.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Double> studentsGradeMap = new LinkedHashMap<>();
        Map<String, Double> resultMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String nameStudent = scanner.nextLine();
            double grade =Double.parseDouble(scanner.nextLine());

            if (!studentsGradeMap.containsKey(nameStudent)){
                studentsGradeMap.put(nameStudent, grade);
            }else {
                studentsGradeMap.put(nameStudent, (grade + studentsGradeMap.get(nameStudent))/2);
            }

        }
        for (Map.Entry<String, Double> entry : studentsGradeMap.entrySet()) {
            if (entry.getValue() >= 4.50){
                resultMap.put(entry.getKey(), entry.getValue());
            }

        }
        resultMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()) );
    }
}
