package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;

        while (!numberList.isEmpty()){
            boolean doNotRemoved = false;
            int index = Integer.parseInt(scanner.nextLine());
            if (index < 0){
                int lastElement = numberList.get(numberList.size() - 1);
                numberList.set(0, lastElement);
                index = 0;
                doNotRemoved = true;

            }else if (index > numberList.size() - 1){
                int fitstElement = numberList.get(numberList.size() - 1);
                numberList.set(numberList.size() - 1, fitstElement);
                index = numberList.size() - 1;
                doNotRemoved = true;

            }
            int removedElement = numberList.get(index);
            sum += removedElement;

            for (int i = 0; i < numberList.size(); i++) {
                if (removedElement >= numberList.get(i)  ){
                    numberList.set(i, numberList.get(i) + removedElement);
                }else if (removedElement < numberList.get(i)){
                    numberList.set(i, numberList.get(i) - removedElement);
                }

            }
            if (!doNotRemoved){
            numberList.remove(index);
            }

        }
        System.out.println(sum);
    }
}
