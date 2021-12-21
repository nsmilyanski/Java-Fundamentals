package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")){
            List<String> secondCommand = Arrays.stream(command.split(" ")).collect(Collectors.toList());

            switch (secondCommand.get(0)){
                case "Delete":
                    int element = Integer.parseInt(secondCommand.get(1));
                    for (int i = 0; i < numList.size() ; i++) {
                        if (element == numList.get(i)){
                            numList.remove(i);
                        }
                    }

                    break;
                case "Insert":
                    int elementOne = Integer.parseInt(secondCommand.get(1));
                    int index = Integer.parseInt(secondCommand.get(2));
                    numList.add(index, elementOne);
                    break;

            }


            command=scanner.nextLine();
        }

        for (int i: numList) {
            System.out.print(i + " ");
        }
    }
}
