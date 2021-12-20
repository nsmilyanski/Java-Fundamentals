package Arrays.lab;

import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        int counter = 0;
        String [] currentArr = new String[n];
        int newLeftMostIndex = 0;
        int newDnaLength = 0;
        int newSumOfOnes = 0;

        while (!input.equals("Clone them!")){

            String[] dnaArr = input.split("!+");
            int lengthDna = 1;
            int leftMostIndex = 0;
            int sumOfOnes = 0;

            for (int i = 0; i < dnaArr.length ; i++) {
                if (dnaArr[i].equals("1")){
                    sumOfOnes++;
                }
                if (dnaArr.length -1 == i){
                    break;
                }else {
                    if (dnaArr[i].equals("1") && dnaArr[i + 1].equals("1")){
                        lengthDna++;
                        leftMostIndex = i + 1;

                    }
                }


            }
                if ((lengthDna > newDnaLength )|| (lengthDna == newDnaLength && leftMostIndex < newLeftMostIndex)
                || (leftMostIndex == newLeftMostIndex && lengthDna == newDnaLength && sumOfOnes > newSumOfOnes )){
                    newLeftMostIndex = leftMostIndex;
                    newSumOfOnes = sumOfOnes;
                    newDnaLength = lengthDna;

                    for (int i = 0; i < currentArr.length ; i++) {
                        currentArr[i] = dnaArr[i];
                    }
                }

            input = scanner.nextLine();
            counter++;
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", newLeftMostIndex, newSumOfOnes);

        for (int i = 0; i < currentArr.length; i++) {
            System.out.print(currentArr[i] + " ");

        }

    }
}
