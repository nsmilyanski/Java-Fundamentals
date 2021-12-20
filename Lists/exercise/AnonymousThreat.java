package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputData = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("3:1")) {
            String[] commandArr = command.split("\\s+");

            switch (commandArr[0]) {
                case "merge":
                    String [] commandData = command.split("\\s+");
                    String commandName = commandData[0]; //merge or divide
                    if(commandName.equals("merge")) {
                        int startIndex = Integer.parseInt(commandData[1]);
                        int endIndex = Integer.parseInt(commandData[2]);
                        if(startIndex < 0) {
                            startIndex = 0;
                        }
                        if(endIndex > inputData.size() - 1) {
                            endIndex = inputData.size() - 1;
                        }
                        //проверка за индексите
                        boolean isStartIndexValid = isValidIndex(startIndex, inputData.size());
                        boolean isEndIndexValid = isValidIndex(endIndex, inputData.size());

                        //ако са валидни и двата
                        if(isStartIndexValid && isEndIndexValid) {
                            //{abc, def, ghi} -> merge 0 1 -> {abcdef, ghi}
                            StringBuilder resultMerge = new StringBuilder();
                            for (int index = startIndex; index <= endIndex; index++) {
                                resultMerge.append(inputData.get(index));
                            }
                            for (int index = startIndex; index <= endIndex; index++) {
                                inputData.remove(startIndex);
                            }
                            inputData.add(startIndex, resultMerge.toString());
                        }
                        break;
                    }
                case "divide":

                    int index = Integer.parseInt(commandArr[1]);
                    int partitions = Integer.parseInt(commandArr[2]);
                    String elementForDivide = inputData.get(index);

                    inputData.remove(index);

                    int partSize = elementForDivide.length() / partitions;
                    int begin = 0;

                    for (int part = 1; part < partitions; part++) {
                        inputData.add(index, elementForDivide.substring(begin, begin + partSize));
                        index++;
                        begin += partSize;
                    }

                    inputData.add(index, elementForDivide.substring(begin));

                    break;
            }
                    command = scanner.nextLine();

        }
        System.out.println(String.join(" ", inputData));
    }

    private static boolean isValidIndex(int index, int size) {
        return index >= 0 && index <= size - 1;
    }
}