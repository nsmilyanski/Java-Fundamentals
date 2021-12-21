package BasicSyntax.exercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headSetprice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

      int trashedHeadset = lostGames / 2;
      int trashedMaouse = lostGames / 3;
      int trashedKeyboard = lostGames / 6;
      int trashedDisplay = lostGames / 12;

      double sum = headSetprice * trashedHeadset + mousePrice * trashedMaouse + keyboardPrice * trashedKeyboard
              + displayPrice * trashedDisplay;
      System.out.printf("Rage expenses: %.2f lv.", sum);

    }
}
