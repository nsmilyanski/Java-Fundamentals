package ExamPreparation;

import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> pianoPiecesMap = new TreeMap<>();

        for (int i = 0; i < n ; i++) {
            String[] piecesArr = scanner.nextLine().split("\\|");
            String key = piecesArr[0];
            if (!pianoPiecesMap.containsKey(key)){
            pianoPiecesMap.put(key, new ArrayList<>());
            pianoPiecesMap.get(key).add(piecesArr[1]);
            pianoPiecesMap.get(key).add(piecesArr[2]);
            }else {
                pianoPiecesMap.get(key).add(piecesArr[1]);
                pianoPiecesMap.get(key).add(piecesArr[2]);
            }

        }
        String input = scanner.nextLine();
        while (!input.equals("Stop")){
            String [] inputArr = input.split("\\|");

            String command = inputArr[0];
            String key = inputArr[1];

            switch (command){
                case "Add":
                    if (!pianoPiecesMap.containsKey(key)){
                        pianoPiecesMap.put(key, new ArrayList<>());
                        pianoPiecesMap.get(key).add(inputArr[2]);
                        pianoPiecesMap.get(key).add(inputArr[3]);
                        System.out.printf("%s by %s in %s added to the collection!%n"
                                , key, inputArr[2], inputArr[3]);
                    }else {
                        System.out.printf("%s is already in the collection!%n", key);
                    }
                    break;
                case "Remove":
                    if (pianoPiecesMap.containsKey(key)){
                        System.out.printf("Successfully removed %s!%n", key);
                        pianoPiecesMap.remove(key);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", key);
                    }
                    break;
                case "ChangeKey":
                    if (pianoPiecesMap.containsKey(key)){
                        pianoPiecesMap.get(key).set(1, inputArr[2]);
                        System.out.printf("Changed the key of %s to %s!%n", key, inputArr[2]);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", key);
                    }
                    break;
            }



            input = scanner.nextLine();
        }
        pianoPiecesMap.entrySet()
                .forEach(element -> System.out.printf("%s -> Composer: %s, Key: %s%n", element.getKey(),
                        element.getValue().get(0), element.getValue().get(1)));

    }
}
