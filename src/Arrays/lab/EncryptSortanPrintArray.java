package Arrays.lab;

import java.util.Scanner;

public class EncryptSortanPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int [] array = new int[n];

        for (int i = 0; i < n ; i++) {
        int sum = 0;
            String input = scanner.nextLine();
            for (int j = 0; j < input.length() ; j++) {
                char symbol = input.charAt(j);
                if (symbol == 'a' || symbol == 'e' || symbol == 'o' ||  symbol == 'y' ||
                symbol == 'u'|| symbol == 'i'){
                    sum += symbol * input.length();
                }else {
                    sum += symbol/input.length();
                }


            }
            array [i] = sum;
        }
        int [] currentArr = new int[array.length];


        int temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array [j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
