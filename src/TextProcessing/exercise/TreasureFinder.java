package TextProcessing.exercise;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] keysArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        // 1 2 1 3
        // ikegfp'jpne)bv=41P83X@
        int index = 0;

        while (!input.equals("find")){

        StringBuilder sb = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                if ( index >= keysArr.length - 1){
                    index = 0;
                }else {
                    if (i == 0){
                        index = i;
                    }else {
                    index++;

                    }
                }

                char symbol = input.charAt(i);
                char currentSymbol = (char) (symbol - keysArr[index]);
                sb.append(currentSymbol);

            }
            int typeFirstI = sb.indexOf("&");
            int lastIndexType = sb.lastIndexOf("&");
            int coordinatesFirstI = sb.indexOf("<");
            int lastIndexCoordinate = sb.indexOf(">");
            String type = sb.substring(typeFirstI + 1 , lastIndexType);
            String cooridinate = sb.substring(coordinatesFirstI + 1, lastIndexCoordinate);
            System.out.printf("Found %s at %s%n", type, cooridinate);

            input = scanner.nextLine();
        }
    }
}
