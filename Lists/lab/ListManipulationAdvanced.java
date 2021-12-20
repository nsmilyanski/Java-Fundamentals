package Lists.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")){
            List<String> inputList = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = inputList.get(0);

                switch (command){
                    case "Contains":
                        ifContainsNumbers(firstList, inputList.get(1));
                        break;
                    case "Print":
                        String secondComand = inputList.get(1);
                        if (secondComand.equals("even")){
                            printAllEvenNumbers(firstList);

                        }else if (secondComand.equals("odd")){
                            printAllOddNumbers(firstList);

                        }
                        break;
                    case "Get":
                        String comandForGet = inputList.get(1);
                        if (comandForGet.equals("sum")){
                            printSumOfAllElements(firstList);

                        }
                        break;
                    case "Filter":
                        String symbol = inputList.get(1);
                        int num = Integer.parseInt(inputList.get(2));
                        printAllFilterdNumbers(firstList, symbol, num);
                        break;
                }
            
            input = scanner.nextLine();
        }
    }

    private static void printAllFilterdNumbers(List<Integer> firstList, String symbol, int num) {

        for (int i = 0; i < firstList.size(); i++) {
            switch (symbol){
                case "<":
                    if (firstList.get(i) < num){
                        System.out.print(firstList.get(i) + " ");
                    }
                    break;
                case ">":
                    if (firstList.get(i) > num){
                        System.out.print(firstList.get(i) + " ");
                    }
                    break;
                case ">=":
                    if (firstList.get(i) >= num){
                        System.out.print(firstList.get(i) + " ");
                    }
                    break;
                case "<=":
                    if (firstList.get(i) <= num){
                        System.out.print(firstList.get(i) + " ");
                    }
                    break;
            }

        }
        System.out.println();
    }

    private static void printSumOfAllElements(List<Integer> firstList) {
        int sum = 0;

        for (int i = 0; i < firstList.size() ; i++) {
            sum += firstList.get(i);
        }
        System.out.println(sum);
    }

    private static void printAllOddNumbers(List<Integer> firstList) {

        for (int i = 0; i < firstList.size() ; i++) {
            if (firstList.get(i) % 2 != 0){
                System.out.print(firstList.get(i) + " ");
            }

        }
        System.out.println();

    }

    private static void printAllEvenNumbers(List<Integer> firstList) {

        for (int i = 0; i < firstList.size() ; i++) {
            if (firstList.get(i) % 2 == 0){
                System.out.print(firstList.get(i) + " ");
            }

        }
        System.out.println();
    }

    private static void ifContainsNumbers(List<Integer> firstList, String s) {

        int number = Integer.parseInt(s);
        boolean isHave = false;

        for (int i = 0; i < firstList.size() ; i++) {
            if (number == firstList.get(i)){
                isHave = true;
                break;

            }

        }
        if (isHave){
            System.out.println("Yes");
        }else {
            System.out.println("No such number");
        }
    }
}
