package Lists.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input =scanner.nextLine();

        while (!input.equals("end")){
            List<String> inputList = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String commacd = inputList.get(0);
            switch (commacd){
                case "Add":
                    int numberAdd = Integer.parseInt(inputList.get(1));
                    firstList.add(numberAdd);
                    break;
                case "Remove":
                    int numberRemove = Integer.parseInt(inputList.get(1));
                    firstList.remove(Integer.valueOf(numberRemove));
                    break;
                case "RemoveAt":
                    int numberIndex = Integer.parseInt(inputList.get(1));
                    firstList.remove(numberIndex);
                    break;
                case "Insert":
                    int numberInsert = Integer.parseInt(inputList.get(1));
                    int numberAtIndex = Integer.parseInt(inputList.get(2));
                    firstList.add(numberAtIndex, numberInsert);
                    break;
            }


            input = scanner.nextLine();
        }
        System.out.println(firstList.toString().replaceAll("[\\[\\],]", ""));
    }
}
