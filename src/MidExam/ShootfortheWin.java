package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootfortheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        int counter = 0;

        while (!input.equals("End")){
            int index = Integer.parseInt(input);
            if (index > numList.size() - 1|| index < 0){
                input = scanner.nextLine();
                continue;
            }
                int currentNum = numList.get(index);
                numList.set(index, -1);
                counter++;

            for (int i = 0; i < numList.size() ; i++) {
                if (currentNum >= numList.get(i) && numList.get(i) != -1){
                    numList.set(i, numList.get(i) + currentNum);
                }else if (currentNum < numList.get(i) && numList.get(i) != -1){
                    numList.set(i, numList.get(i) - currentNum);
                }
            }

            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", counter);
        for (int i = 0; i <numList.size() ; i++) {
            System.out.print(numList.get(i) + " ");
        }
    }
}
