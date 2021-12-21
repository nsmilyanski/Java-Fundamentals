package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> cardPlayer1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> cardPlayer2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (!cardPlayer1.isEmpty() && !cardPlayer2.isEmpty()) {
            int card1 = cardPlayer1.get(0);
            int card2 = cardPlayer2.get(0);

            if (card1 > card2){
                cardPlayer1.add(card1);
                cardPlayer1.add(card2);
                cardPlayer1.remove(0);
                cardPlayer2.remove(0);

            }else if (card1 < card2){
                cardPlayer2.add(card2);
                cardPlayer2.add(card1);
                cardPlayer2.remove(0);
                cardPlayer1.remove(0);

            }else {
                cardPlayer1.remove(0);
                cardPlayer2.remove(0);

            }

        }
        if (cardPlayer2.isEmpty()){
            printSum1(cardPlayer1);
        }else {
            printSum2(cardPlayer2);
        }


    }

    private static void printSum2(List<Integer> cardPlayer2) {
        int sum1 = 0;
        for (int i = 0; i < cardPlayer2.size(); i++) {
            sum1 += cardPlayer2.get(i);
        }
        System.out.printf("Second player wins! Sum: %d", sum1);

    }

    private static void printSum1(List<Integer> cardPlayer1) {
        int sum1 = 0;
        for (int i = 0; i < cardPlayer1.size(); i++) {
            sum1 += cardPlayer1.get(i);
        }
        System.out.printf("First player wins! Sum: %d", sum1);
    }
}
