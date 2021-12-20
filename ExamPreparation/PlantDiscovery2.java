package ExamPreparation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PlantDiscovery2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> rarityMap = new LinkedHashMap<>();
        Map<String, Double> ratingMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split("<->");
            String plant = inputArr[0];
            double rarity = Double.parseDouble(inputArr[1]);

            rarityMap.putIfAbsent(plant, 0.0);
            ratingMap.putIfAbsent(plant, 0.0);

            rarityMap.put(plant, rarityMap.get(plant) + rarity);

        }
        String input = scanner.nextLine();

        while (!input.equals("Exhibition")){
            String[] commArray = input.split("[: -]+");
            String command = commArray[0];
            String plant = commArray[1];

            if (!rarityMap.containsKey(plant) && !ratingMap.containsKey(plant)){
                System.out.println("error");
            }else {
                switch (command){
                    case "Rate":
                        double rating = Double.parseDouble(commArray[2]);
                        if (ratingMap.get(plant) == 0.0){
                            ratingMap.put(plant, rating);
                        }else {
                        double averageRating = (rating + ratingMap.get(plant))/2;
                        ratingMap.put(plant, averageRating);
                        }
                        break;
                    case "Update":
                        double newRarity = Double.parseDouble(commArray[2]);
                        rarityMap.put(plant, newRarity);
                        break;
                    case "Reset":
                        ratingMap.put(plant, 0.0);
                        break;

                }
            }


            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");

        rarityMap.entrySet().stream()
                .sorted((e1, e2) -> {
                   double result = (e2.getValue() - e1.getValue());

                   if (result == 0){
                       result = (ratingMap.get(e2.getKey()) - ratingMap.get(e1.getKey()));
                   }
                   return (int) result;
                }).forEach(entry -> System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n",
                entry.getKey(), entry.getValue(), ratingMap.get(entry.getKey())));


    }
}
