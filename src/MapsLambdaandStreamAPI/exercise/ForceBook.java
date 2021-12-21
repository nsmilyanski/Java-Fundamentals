package MapsLambdaandStreamAPI.exercise;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> firstMap = new TreeMap<>();
        String removedSide = "";


        while (!input.equals("Lumpawaroo")){
            if (input.contains("|")){
                String[] firstArr = input.split(" \\| ");
                String forceSide = firstArr[0];
                String forceUser = firstArr[1];
                if (!firstMap.containsKey(forceSide)){
                    firstMap.put(forceSide, new ArrayList<>());
                }
                boolean isContain = false;
                for ( List<String> list: firstMap.values()) {
                    if (list.contains(forceUser)){
                        isContain = true;
                    }
                }
                if (!isContain){
                    firstMap.get(forceSide).add(forceUser);
                }

            }else if (input.contains("->")){
                String [] secondArr = input.split(" -> ");
                String forceUser = secondArr[0];
                String forceSide = secondArr[1];
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);

             firstMap.entrySet().forEach(entry -> entry.getValue().remove(forceUser));

             firstMap.putIfAbsent(forceSide, new ArrayList<>());
             firstMap.get(forceSide).add(forceUser);

            }
            input = scanner.nextLine();
        }
        firstMap.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                .forEach(entry ->{
                    if(!entry.getValue().isEmpty()) {
                        if (entry.getValue().size() > 0) {
                            System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                        }
                        entry.getValue().stream().sorted().forEach(name -> System.out.printf("! %s%n", name));
                    }
                });

    }
}
