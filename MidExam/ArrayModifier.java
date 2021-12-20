package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();


        while (!input.equals("end")){
        List<String> commandList = Arrays.stream(input.split(" ")).collect(Collectors.toList());
        String command = commandList.get(0);

        switch (command){
            case "swap":
                int firstIndex = Integer.parseInt(commandList.get(1));
                int secondIndex = Integer.parseInt(commandList.get(2));
                int currentNum = numList.get(firstIndex);
                numList.set(firstIndex, numList.get(secondIndex));
                numList.set(secondIndex, currentNum);
                break;
            case "multiply":
                int a = Integer.parseInt(commandList.get(1));
                int b = Integer.parseInt(commandList.get(2));

                int multiply = numList.get(a) * numList.get(b);
                numList.set(a, multiply);
                break;
            case "decrease":
                for (int i = 0; i < numList.size(); i++) {
                    int currentElement = numList.get(i) - 1;
                    numList.set(i, currentElement);
                }
                break;
        }
            input = scanner.nextLine();
        }
        System.out.println(numList.toString().replaceAll("[\\[\\]]", " "));

    }
}
