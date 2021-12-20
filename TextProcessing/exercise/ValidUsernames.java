package TextProcessing.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] inputArr = scanner.nextLine().split(", ");
        List<String> resultList = new ArrayList<>();


        for (int i = 0; i < inputArr.length; i++) {
        boolean isValid = false;
            String currentUserName = inputArr[i];
            if (currentUserName.length() >=3 && currentUserName.length() <= 16){
                for (int j = 0; j < currentUserName.length(); j++) {
                    char symbol = currentUserName.charAt(j);
                    if (Character.isLetter(symbol) || Character.isDigit(symbol) || symbol == '-' || symbol == '_'){
                        isValid = true;
                    }else {
                        isValid = false;
                        break;
                    }
                }

            }
            if (isValid){
                resultList.add(inputArr[i]);

            }

        }
        resultList.forEach(e -> System.out.println(e));

    }
}
