package TextProcessing.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.nextLine();
        String secondWord = scanner.nextLine();

        int index = secondWord.indexOf(firstWord);

     while (index != -1){
         secondWord = secondWord.replace(firstWord, "");
         index = secondWord.indexOf(firstWord);
     }
        System.out.println(secondWord);
    }
}
