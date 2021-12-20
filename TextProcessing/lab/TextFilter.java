package TextProcessing.lab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] inputArr = scanner.nextLine().split(", ");

        String text = scanner.nextLine();



        for (int i = 0; i < inputArr.length; i++) {
        int index = 0;
            StringBuilder currentText = new StringBuilder();

            for (int j = 0; j < inputArr[i].length(); j++) {
                currentText.append("*");
            }
            while (index != -1){
               text = text.replace(inputArr[i], currentText);
                index = text.indexOf(inputArr[i]);
            }
        }
        System.out.println(text);


    }
}
