package MidExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")){
            String [] commandArray = input.split(" ");
            String command = commandArray[0];

            switch (command){
                case "Shoot":
                    int shootingIndex = Integer.parseInt(commandArray[1]);
                    int shootingPower = Integer.parseInt(commandArray[2]);
                    if (ifTargetIsInRange(numList.size(), shootingIndex)) {
                        numList.set(shootingIndex, numList.get(shootingIndex) - shootingPower);
                        if (numList.get(shootingIndex) <= 0) {
                            numList.remove(shootingIndex);
                        }
                    }
                    break;
                case "Add":
                    int addIndex = Integer.parseInt(commandArray[1]);
                    int addValue = Integer.parseInt(commandArray[2]);
                    ifTargetIsInRange(numList.size(), addIndex);
                    if (ifTargetIsInRange(numList.size(), addIndex)){
                        numList.add(addIndex, addValue);
                    }else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int strikeIndex = Integer.parseInt(commandArray[1]);
                    int strikeRadius = Integer.parseInt(commandArray[2]);
                    ifItsStrike(strikeIndex, strikeRadius, numList);
                    if (ifItsStrike(strikeIndex, strikeRadius, numList)){
                        int start = strikeIndex - strikeRadius;
                        int end = strikeIndex + strikeRadius;
                    for (int i = start; i <= end ; i++) {
                        numList.remove(start);
                    }
                }else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }



            input = scanner.nextLine();
        }
        for (int i = 0; i < numList.size(); i++) {
            if (numList.size() - 1 == i){
                System.out.print(numList.get(i));
            }else {
                System.out.print(numList.get(i) + "|");
            }
        }

    }

    private static boolean ifItsStrike(int strikeIndex, int strikeRadius, List<Integer> numList) {
        if ((strikeIndex >= 0 && strikeIndex <= numList.size()) && (strikeIndex - strikeRadius >= 0 &&
        strikeIndex + strikeRadius <= numList.size() - 1)){
            return true;
        }else {
            return false;
        }
    }

    private static boolean ifTargetIsInRange(int size, int addIndex) {
        return addIndex >= 0 && addIndex <= size - 1;
    }
}
