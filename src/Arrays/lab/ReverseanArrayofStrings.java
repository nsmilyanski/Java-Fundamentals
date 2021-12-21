package Arrays.lab;

import java.util.Scanner;

public class ReverseanArrayofStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] Arr = input.split(" ");

        for (int i = Arr.length -1; i >=0 ; i--) {
            System.out.print(Arr[i] + " ");

        }
    }
}
