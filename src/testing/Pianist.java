package testing;

import java.util.*;

public class Pianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> piecesMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokenArr = scanner.nextLine().split("\\|");

            String piece = tokenArr[0];
            String composer = tokenArr[1];
            String key = tokenArr[2];

            piecesMap.put(piece, new ArrayList<>());
            piecesMap.get(piece).add(composer);
            piecesMap.get(piece).add(key);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")){
            String[] inputArr = input.split("\\|");
            String command = inputArr[0];

            switch (command){
                case "Add":
                    String pieces = inputArr[1];
                    String composers = inputArr[2];
                    String keys = inputArr[3];

                    if (!piecesMap.containsKey(pieces)) {
                        piecesMap.put(pieces, new ArrayList<>());
                        piecesMap.get(pieces).add(composers);
                        piecesMap.get(pieces).add(keys);
                        System.out.printf("%s by %s in %s added to the collection!%n", pieces, composers, keys);
                    }else {
                        System.out.printf("%s is already in the collection!%n", pieces);
                    }

                    break;
                case "Remove":
                    String removePiece = inputArr[1];
                    if (piecesMap.containsKey(removePiece)){
                        piecesMap.remove(removePiece);
                        System.out.printf("Successfully removed %s!%n", removePiece);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", removePiece);
                    }
                    break;
                case "ChangeKey":
                    String changePiece = inputArr[1];
                    String changeKey = inputArr[2];

                    if (piecesMap.containsKey(changePiece)) {
                        piecesMap.get(changePiece).set(1, changeKey);
                        System.out.printf("Changed the key of %s to %s!%n", changePiece, changeKey);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", changePiece);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        piecesMap.entrySet().stream().sorted((e1, e2) ->{
            int result = e1.getKey().compareTo(e2.getKey());
            if (result == 0){
                result = e1.getValue().get(0).compareTo(e2.getValue().get(0));
            }
            return result;
        }).forEach(element -> System.out.printf("%s -> Composer: %s, Key: %s%n", element.getKey(),
                element.getValue().get(0), element.getValue().get(1)));
    }
}
