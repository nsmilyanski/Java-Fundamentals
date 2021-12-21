package Methods.exercises;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        boolean hasEnoughtCharacters = characters(password);
        boolean hasEneoughtLettersAndDigit = onlyLettersAndDigit(password);
        boolean has2Digits = has2Digits(password);

        if (!hasEnoughtCharacters){
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!hasEneoughtLettersAndDigit){
            System.out.println("Password must consist only of letters and digits");
        }
        if (!has2Digits){
            System.out.println("Password must have at least 2 digits");
        }

        if(has2Digits && hasEneoughtLettersAndDigit && hasEnoughtCharacters){
            System.out.println("Password is valid");
        }

    }
    private static boolean characters(String characters){
        return  (characters.length() >= 6 && characters.length() <= 10);

    }
    private static boolean onlyLettersAndDigit(String password){
        boolean isValid = true;
        for (char symbol: password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)){
                isValid = false;
            }

        }
        return isValid;
    }
    private static boolean has2Digits (String password){
        int sum = 0;
        for (char symbol: password.toCharArray()) {
            if (Character.isDigit(symbol)){
                sum++;
            }

        }
        return sum >= 2;

    }

}
