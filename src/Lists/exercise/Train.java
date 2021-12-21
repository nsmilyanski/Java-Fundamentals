package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("end")){
            List<String> secondaComand = Arrays.stream(command.split(" ")).collect(Collectors.toList());
            if (secondaComand.get(0).equals("Add")){
                int addWagon = Integer.parseInt(secondaComand.get(1));
                if (addWagon <= maxCapacity){
                    numList.add(addWagon);
                }

            }else {
                int addPassangers = Integer.parseInt(secondaComand.get(0));
                for (int i = 0; i < numList.size() ; i++) {
                    if (addPassangers + numList.get(i) <= maxCapacity){
                        numList.set(i, addPassangers + numList.get(i));
                        break;
                    }

                }

            }


            command = scanner.nextLine();
        }

        for (int i: numList) {
            System.out.print(i + " ");
        }
    }
}
