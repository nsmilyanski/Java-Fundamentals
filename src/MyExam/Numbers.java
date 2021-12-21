package MyExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Finish")){
            List<String> commandList = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = commandList.get(0);

            switch (command){
                case "Add":
                    int addValue = Integer.parseInt(commandList.get(1));
                    numList.add(addValue);
                    break;
                case "Remove":
                    int removeValue = Integer.parseInt(commandList.get(1));
                    for (int i = 0; i < numList.size() ; i++) {
                        if (numList.get(i) == removeValue){
                            numList.remove(i);
                            break;
                        }
                    }
                    break;
                case "Replace":
                    int replaceValue1 = Integer.parseInt(commandList.get(1));
                    int replaceValue2 = Integer.parseInt(commandList.get(2));
                    for (int i = 0; i < numList.size(); i++) {
                        if (numList.get(i) == replaceValue1){
                            numList.set(i, replaceValue2);
                            break;
                        }
                    }

                    break;
                case "Collapse":
                    int collapseValue = Integer.parseInt(commandList.get(1));
                    int size = numList.size();
                    for (int i = 0; i < size; i++) {
                        if (numList.get(i) < collapseValue){
                            numList.remove(i);
                            i -= 1;
                            size -= 1;
                        }
                    }
                    break;
            }



            input = scanner.nextLine();
        }

        for (int i = 0; i < numList.size(); i++) {
            System.out.print(numList.get(i) + " ");
        }
    }
}
