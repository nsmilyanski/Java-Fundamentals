package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFact {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int lowValue = Integer.MAX_VALUE;

        int bestSum = 0;
        int [] currentArr = new int[n];

        int bestDnaInter = 0;
        int counter = 0;
        int count1 = 0;

        //5
        //1!0!1!1!0
        //0!1!1!0!0
        //Clone them!
            int currentValue = 0;

        while (!input.equals("Clone them!")){
            boolean isBest = false;
            counter++;
            int[] numArr = Arrays
                    .stream(input.split("!"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int sum = 0;

            for (int i = 0; i < numArr.length ; i++) {
                if (i == numArr.length - 1){
                    if (numArr[i] == 1){
                        sum++;
                    }
                    break;
                }
                if (numArr[i] == 1 && numArr[i + 1] == 1 ){
                    sum++;
                    int bestIndex = i;
                    if (lowValue >= bestIndex){
                        lowValue = bestIndex;
                        isBest = true;
                        count1++;
                    }
                }else {
                    if (numArr[i]== 1){
                    sum ++;
                    }

                }

            }

            if (isBest){
                if (currentValue < lowValue){
                    currentValue = lowValue;
                    bestSum = sum;
                    currentArr  = numArr;
                    bestDnaInter = counter;


                }else if (currentValue == lowValue && sum > bestSum){
                    bestSum = sum;
                    currentArr  = numArr;
                    bestDnaInter = counter;
                }else {
                    break;
                }
            }

            input = scanner.nextLine();

        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestDnaInter,bestSum);
        for (int i = 0; i < currentArr.length ; i++) {
            System.out.print(currentArr[i] + " ");


        }

    }
}
