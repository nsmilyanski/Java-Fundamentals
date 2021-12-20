package DataTypesandVariables.exersice;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      int lines = Integer.parseInt(scanner.nextLine());
      int counter1 = 0;
      int counter2 = 0;
      boolean isBreak = false;

        for (int i = 1; i <= lines ; i++) {
            String input = scanner.nextLine();
           char symbol = input.charAt(0);
           if (symbol == '('){
               counter1++;
           }else if (symbol == ')'){
               counter2++;
               if (counter1 - counter2 != 0){
                   System.out.println("UNBALANCED");
                   isBreak = true;
                   break;
               }
           }
        }
        if (!isBreak){
        if (counter1 == counter2){
            System.out.println("BALANCED");
        }else {
            System.out.println("UNBALANCED");
        }
        }
    }
}
