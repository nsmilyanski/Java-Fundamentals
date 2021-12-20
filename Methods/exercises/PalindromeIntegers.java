package Methods.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    String palindromeNum = scanner.nextLine();


    while (!palindromeNum.equals("END")){
    boolean isPalindrome = getPalindrome(palindromeNum);
        if (isPalindrome){
            System.out.println(isPalindrome);
        }else {
            System.out.println("false");
        }

        palindromeNum = scanner.nextLine();
    }

    }
    private static boolean getPalindrome (String palindrome){
       String reversedString = "";

        for (int i = palindrome.length() - 1; i >= 0 ; i--) {
            reversedString +=palindrome.charAt(i);

        }
        return palindrome.equals(reversedString);
    }
}
