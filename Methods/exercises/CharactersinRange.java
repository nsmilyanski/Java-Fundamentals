package Methods.exercises;

import java.util.Scanner;

public class CharactersinRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char a = scanner.nextLine().charAt(0);
        char b = scanner.nextLine().charAt(0);

        characterInRange(a, b);


    }
    private static void   characterInRange (char a, char b){
        if (a < b){
            for (int i =(char)(a + 1); i < b ; i++) {
                System.out.print((char)i + " ");

            }

        }else {
            for (int i =(char) (b + 1); i < a ; i++) {
                System.out.print((char)i + " ");

            }

        }

    }
}
