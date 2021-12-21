package testing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PlantDisc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantMap = new LinkedHashMap<>();
        Map<String, Double> ratingMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokenArr = scanner.nextLine().split("<->");
            String plant = tokenArr[0];
            int rarity = Integer.parseInt(tokenArr[1]);

            plantMap.putIfAbsent(plant, 0);
            ratingMap.putIfAbsent(plant, 0.0);

            plantMap.put(plant, plantMap.get(plant) + rarity);

        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition")){
            String[] inputArr = input.split("[: -]+");
            String command = inputArr[0];
            String flour = inputArr[1];

            if (!plantMap.containsKey(flour) && !ratingMap.containsKey(flour)){
                System.out.println("error");
            }else {

                switch (command) {
                    case "Rate":
                        double rating = Double.parseDouble(inputArr[2]);

                        if (ratingMap.get(flour) == 0.0){
                            ratingMap.put(flour, rating);
                        }else {
                            ratingMap.put(flour, (ratingMap.get(flour) + rating)/2);
                        }

                        break;
                    case "Update":
                        int currentRarity = Integer.parseInt(inputArr[2]);
                        plantMap.put(flour, currentRarity);
                        break;
                    case "Reset":
                        ratingMap.put(flour, 0.0);
                        break;
                }

            }


            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");

        plantMap.entrySet().stream().sorted((e1, e2) -> {
            int result = e2.getValue().compareTo(e1.getValue());

            if (result == 0){
                result = (int)(ratingMap.get(e2.getKey()) - ratingMap.get(e1.getKey()));
            }
            return result;
        }).forEach(element -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                element.getKey(), element.getValue(), ratingMap.get(element.getKey())));
    }
}
