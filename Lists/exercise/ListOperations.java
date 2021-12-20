package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")){
            List<String> commandList = Arrays.stream(command.split("\\s+")).collect(Collectors.toList());
            String secondCommand = commandList.get(0);

            switch (secondCommand){
                case "Add":
                    int addNum = Integer.parseInt(commandList.get(1));
                    numList.add(addNum);
                    break;
                case "Insert":
                    int insertNum = Integer.parseInt(commandList.get(1));
                    int insertIndex = Integer.parseInt(commandList.get(2));
                    if (insertIndex >= 0 && insertIndex <= numList.size() - 1){
                        numList.add(insertIndex, insertNum);
                    }else {
                        System.out.println("Invalid index");
                        break;
                    }
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(commandList.get(1));
                    if (removeIndex >= 0 && removeIndex <= numList.size() - 1){
                        numList.remove(removeIndex);
                    }else {
                        System.out.println("Invalid index");
                        break;
                    }

                    break;
                case "Shift":
                    int shift = Integer.parseInt(commandList.get(2));
                    if (commandList.get(1).equals("left")){
                        for (int i = 0; i < shift; i++) {
                            int firstNum = numList.get(0);
                            numList.add(firstNum);
                            numList.remove(0);

                        }


                    }else if (commandList.get(1).equals("right")){
                        for (int i = 0; i < shift; i++) {
                        int lastIndex = numList.get(numList.size() - 1);
                            numList.add(0, lastIndex);
                            numList.remove(numList.size() - 1);

                        }

                    }
                    break;
            }


            command = scanner.nextLine();
        }

        System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
    }
}
