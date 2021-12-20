package Methods.lab;

import java.util.Scanner;

public class GreaterofTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("int")){
            int a = Integer.parseInt(scanner.nextLine());
            int b = Integer.parseInt(scanner.nextLine());
            getMaxInt(a, b);
        } else if (input.equals("char")) {
            char a = scanner.nextLine().charAt(0);
            char b = scanner.nextLine().charAt(0);
            getMacChar(a, b);
        }else if (input.equals("string")){
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            getMaxString(a, b);
        }



    }
    public static int getMaxInt (int a, int b){
        int bigerInt = 0;
        if (a > b){
            bigerInt = a;
            System.out.println(bigerInt);
        }else {
            bigerInt = b;
            System.out.println(bigerInt);
        }
        return bigerInt;

    }
    public static char getMacChar(char a, char b){
        char bigger = Character.MIN_VALUE;
        if (a > b){
            bigger = a;
            System.out.println(bigger);
        }else {
            bigger = b;
            System.out.println(bigger);
        }
        return bigger;
    }
    public static String getMaxString(String a, String b){
        String bigger = "";
        if (a.compareTo(b) >= 0){
            bigger = a;
            System.out.println(a);
        }else {
            bigger = b;
            System.out.println(b);
        }
        return bigger;
    }
}
