package MidExam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble).collect(Collectors.toList());
        double sum = 0;

        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i);
        }
        double averageValue = sum / numList.size();
        Collections.sort(numList);
        Collections.reverse(numList);
        boolean haveNum = false;

        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) > averageValue && i < 5){
                haveNum = true;
                System.out.printf("%.0f ",numList.get(i));
            }
        }
        if (numList.size() == 1 || !haveNum){
            System.out.println("No");
        }

    }
}
