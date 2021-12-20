package TextProcessing.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Character> characterList = new ArrayList<>();
        String text = "";

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (i == 0){
                characterList.add(symbol);
            } else if (symbol != input.charAt(i - 1)){
                characterList.add(symbol);
            }
        }
        characterList.forEach(e -> System.out.print(e));
    }
}
