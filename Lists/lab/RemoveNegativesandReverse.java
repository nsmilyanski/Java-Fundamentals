package Lists.lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesandReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int size = numList.size();
        boolean isEmpty =false;

        for (int i = 0; i < size; i++) {
            if (numList.get(i) < 0){
                numList.remove(i);
                i= -1;
                size = size - 1;

            }

        }
        Collections.reverse(numList);

        if (numList.isEmpty()){
            System.out.println("empty");

        }else {
            for (int i = 0; i < numList.size() ; i++) {
                System.out.print(numList.get(i) + " ");

            }
        }
    }
}
