package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Memorygame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elementsList = Arrays.stream(scanner.nextLine()
                .split("\\s+")).collect(Collectors.toList());


        String command = scanner.nextLine();
        int counter = 0;
        boolean isEmpty = false;

        while (!command.equals("end")){
            counter++;
        int [] indexes = Arrays.stream(command.split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
        int firstIndex = indexes[0];
        int secondIndex = indexes[1];
        if (firstIndex == secondIndex || firstIndex > elementsList.size() - 1 || firstIndex < 0
        || secondIndex > elementsList.size() - 1 || secondIndex < 0){
            elementsList.add(elementsList.size()/2, "-" +counter + "a" );
            elementsList.add(elementsList.size()/2, "-" + counter + "a" );
            System.out.println("Invalid input! Adding additional elements to the board");
            command = scanner.nextLine();
            continue;
        }
        if (elementsList.get(firstIndex).equals(elementsList.get(secondIndex))){
            String curElement = elementsList.get(firstIndex);
            elementsList.remove(firstIndex);
            elementsList.remove(curElement);
            System.out.printf("Congrats! You have found matching elements - %s!%n", curElement);
        }else {
            System.out.println("Try again!");
        }
        if (elementsList.isEmpty()){
            isEmpty = true;
            break;
        }

            command = scanner.nextLine();
        }
        if (isEmpty){
            System.out.printf("You have won in %d turns!%n", counter);
        }else {
            System.out.println("Sorry you lose :(");
            System.out.println(elementsList.toString().replaceAll("[\\[\\],]", ""));
        }

    }
}
