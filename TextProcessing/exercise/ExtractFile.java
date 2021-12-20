package TextProcessing.exercise;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] inputArr = scanner.nextLine().split("\\\\");

        String [] resultArr = inputArr[inputArr.length - 1].split("\\.");

        System.out.println("File name: " + resultArr[0]);
        System.out.println("File extension: " + resultArr[1]);
    }
}
