package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> stringList = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")){
            List<String> commandList = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = commandList.get(0);

            switch (command){
                case "Urgent":
                    if (!stringList.contains(commandList.get(1))){
                        stringList.add(0, commandList.get(1));
                    }
                    break;
                case "Unnecessary":
                    if (stringList.contains(commandList.get(1))){
                        stringList.remove(commandList.get(1));
                    }
                    break;
                case "Correct":
                    String oldItem = commandList.get(1);
                    String newItem = commandList.get(2);
                    if (stringList.contains(oldItem)){
                        int indexOfNewItem = stringList.indexOf(oldItem);
                        stringList.set(indexOfNewItem, newItem);
                    }
                    break;
                case "Rearrange":
                    if (stringList.contains(commandList.get(1))){
                        String rearrangeItem = commandList.get(1);
                        stringList.remove(rearrangeItem);
                        stringList.add(rearrangeItem);
                    }
                    break;

            }

            input = scanner.nextLine();
        }
        System.out.println(stringList.toString().replaceAll("[\\[\\]]", " "));

    }
}
