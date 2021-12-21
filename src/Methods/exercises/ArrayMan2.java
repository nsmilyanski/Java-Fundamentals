package Methods.exercises;

import java.util.Scanner;
import  java.util.Arrays;

public class ArrayMan2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] firstArray =  Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")){
            String [] inputArray = input.split(" ");
            switch (inputArray[0]){
                case "exchange":
                    int currentIndex = Integer.parseInt(inputArray[1]);
                    if (currentIndex > firstArray.length - 1){
                        System.out.println("Invalid index");
                        input = scanner.nextLine();
                        continue;
                    }else {
                        printExchanged(inputArray[0], inputArray[1], firstArray);
                        int [] currentArr = printExchanged(inputArray[0], inputArray[1], firstArray);
                        firstArray = currentArr;
                    }
                    break;
                case  "max":
                    switch (inputArray[1]){
                        case "even":
                            printMaxEven(firstArray);
                            break;
                        case "odd":
                            printMaxOdd(firstArray);
                            break;
                    }
                    break;
                case "min":
                    switch (inputArray[1]){
                        case "even":
                            printMinEven(firstArray);
                            break;
                        case "odd":
                            printMinOdd(firstArray);
                            break;
                    }
                    break;
                case "first":
                    switch (inputArray[2]){
                        case "even":
                            printFirstEven(firstArray, inputArray[1]);
                            break;
                        case "odd":
                            printFirstOdd(firstArray, inputArray[1]);
                            break;
                    }
                    break;
                case "last":
                    switch (inputArray[2]){
                        case "even":
                            printLastEven(firstArray, inputArray[1]);
                            break;
                        case "odd":
                            printLastOdd(firstArray, inputArray[1]);
                            break;
                    }

                    break;

            }

            input = scanner.nextLine();
        }

        System.out.print("[");
        for (int i = 0; i < firstArray.length ; i++) {
            if (i == firstArray.length - 1){
                System.out.print(firstArray[i]);
            }else {
                System.out.print(firstArray[i] + ", ");
            }
        }
        System.out.print("]");
    }

    private static void printLastOdd(int[] firstArray, String s) {
        int index = Integer.parseInt(s);
        int [] currentArray = new int[index];

        int counter = 0;

        for (int i = firstArray.length - 1; i >= 0 ; i--) {
            if (firstArray[i] % 2 != 0 && counter != index){
                counter++;
                currentArray[counter- 1] = firstArray[i];
            }

        }

        if (index > firstArray.length){
            System.out.print("Invalid count");
        }else {
            System.out.print("[");
            for (int j = 0; j < currentArray.length; j++) {
                if (currentArray[j] != 0) {
                    System.out.print(currentArray[j]);
                }

            }
            System.out.print("]");

        }
        System.out.println();

    }

    private static void printLastEven(int[] firstArray, String s) {
        int index = Integer.parseInt(s);
        int [] currentArray = new int[index];

        int counter = 0;

        for (int i = firstArray.length - 1; i >= 0 ; i--) {
            if (firstArray[i] % 2 == 0 && counter != index){
                counter++;
                currentArray[counter- 1] = firstArray[i];
            }

        }

        if (index > firstArray.length){
            System.out.print("Invalid count");
        }else {
            System.out.print("[");
            for (int j = 0; j < currentArray.length; j++) {
                if (currentArray[j] != 0) {
                    System.out.print(currentArray[j]);
                }

            }
            System.out.print("]");

        }
        System.out.println();

    }

    private static void printFirstOdd(int[] firstArray, String s) {
        int index = Integer.parseInt(s);
        int [] currentArray = new int[index];

        int counter = 0;

        for (int i = 0; i < firstArray.length ; i++) {
            if (firstArray[i] % 2 != 0 && counter != index){
                counter++;
                currentArray[counter- 1] = firstArray[i];
            }

        }

        if (index > firstArray.length){
            System.out.print("Invalid count");
        }else {
            System.out.print("[");
            for (int j = 0; j < currentArray.length ; j++) {
                if (currentArray[j] != 0){
                    if (index - 1 == j){
                    System.out.print(currentArray[j]);
                    }else {
                        System.out.print(currentArray[j] + ", ");
                    }

                }
            }
            System.out.print("]");
        }
        System.out.println();
    }

    private static void printFirstEven(int[] firstArray, String s) {

        int index = Integer.parseInt(s);
        int [] currentArray = new int[index];

        int counter = 0;

        for (int i = 0; i < firstArray.length ; i++) {
            if (firstArray[i] % 2 == 0 && counter != index){
                counter++;
                currentArray[counter- 1] = firstArray[i];
            }

        }
        if (index > firstArray.length){
            System.out.print("Invalid count");
        }else {
            System.out.print("[");
            for (int j = 0; j < currentArray.length ; j++) {
                if (currentArray[j] != 0){
                    System.out.print(currentArray[j]);
                }

            }
            System.out.print("]");

        }
        System.out.println();
    }

    private static void printMinOdd(int[] firstArray) {
        int minOdd = Integer.MAX_VALUE;
        int currentIndex = 0;

        for (int i = 0; i < firstArray.length ; i++) {
            if (minOdd >= firstArray[i] && firstArray[i] % 2 != 0){
                minOdd = firstArray[i];
                currentIndex = i;
            }

        }
        if (minOdd == Integer.MAX_VALUE){
            System.out.println("No matches");
        }else {
            System.out.println(currentIndex);
        }


    }

    private static void printMinEven(int[] firstArray) {
        int minEven = Integer.MAX_VALUE;
        int currentIndex = 0;

        for (int i = 0; i < firstArray.length ; i++) {
            if (minEven >= firstArray[i] && firstArray[i] % 2 == 0){
                minEven = firstArray[i];
                currentIndex = i;
            }

        }
        if (minEven == Integer.MAX_VALUE){
            System.out.println("No matches");
        }else {
            System.out.println(currentIndex);
        }

    }

    private static void printMaxOdd(int[] firstArray) {

        int maxOdd = Integer.MIN_VALUE;
        int currentIndex = 0;

        for (int i = 0; i < firstArray.length ; i++) {
            if (maxOdd <= firstArray[i] && firstArray[i] % 2 != 0){
                maxOdd = firstArray[i];
                currentIndex = i;
            }

        }
        if (maxOdd == Integer.MIN_VALUE){
            System.out.println("No matches");
        }else {
            System.out.println(currentIndex);
        }
    }

    private static void printMaxEven(int[] firstArray) {

        int maxEven = Integer.MIN_VALUE;
        int currentIndex = 0;

        for (int i = 0; i < firstArray.length ; i++) {
            if (maxEven <= firstArray[i] && firstArray[i] % 2 == 0){
                maxEven = firstArray[i];
                currentIndex = i;
            }

        }
        if (maxEven == Integer.MIN_VALUE){
            System.out.println("No matches");
        }else {
            System.out.println(currentIndex);
        }
    }

    private static int [] printExchanged(String s, String s1, int [] array) {
        int exchangedIndex = Integer.parseInt(s1);
        int currentExchangeg = exchangedIndex;
        String ivalidIndex = "Invalid index";

        int [] firstArray = new int[exchangedIndex + 1];
        int [] secondArray = new int[array.length - exchangedIndex - 1];

        for (int index = 0; index < firstArray.length; index++) {
            firstArray[index] = array [index];
        }

        for (int index2 = 0 ; index2 < secondArray.length  ; index2++) {
            secondArray[index2] = array[index2 + exchangedIndex + 1];
        }

        int [] outputArray = new int[array.length];
        int counter = 0;

        for (int i = 0; i < outputArray.length ; i++) {
            if (i < secondArray.length){
                outputArray[i] = secondArray[i];
            }else {
                counter++;
                outputArray[i] = firstArray[counter - 1];
                currentExchangeg--;
            }

        }

        return outputArray;

    }
}
