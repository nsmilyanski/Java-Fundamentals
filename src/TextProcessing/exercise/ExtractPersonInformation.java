package TextProcessing.exercise;

import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
        String name = "";
        String age = "";
            String [] textArr = scanner.nextLine().split(" ");

            for (String info: textArr) {
                if (info.charAt(0) == '@'){
                     name = info.substring(1, info.length()-1);
                }else if (info.charAt(0) == '#'){
                     age = info.substring(1, info.length() - 1);
                }
            }
            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
