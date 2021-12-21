package testing;

import java.util.*;
import java.util.stream.Collectors;



public class PlantDiscovery_04 {

    public static void main(String[] args) {

        class Plant {

            private final String name;
            private final List<Double> ratings;
            private Integer rarity;

            public Plant(String name, Integer rarity){
                this.name = name;
                this.rarity = rarity;
                this.ratings = new ArrayList<>();
            }

            public List<Double> getRatings(){
                return ratings;
            }

            public void setRarity(Integer rarity){
                this.rarity = rarity;
            }

            private String getAvgRating(){
                return String.format( "%.2f", ratings.stream()
                        .collect(Collectors.averagingDouble(Double::doubleValue)));
            }

            @Override
            public String toString() {
                return "- " + name + "; Rarity: " + rarity + "; Rating: " + getAvgRating();
            }
        }

        Scanner scanner = new Scanner(System.in);
        Map<String, Plant> plants = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] information = scanner.nextLine().split("<->");
            plants.put(information[0], new Plant(information[0], Integer.parseInt(information[1])));
        }

        String[] inputs;
        while(!(inputs = scanner.nextLine().split("\\s+"))[0].equals("Exhibition")) {
            String command = inputs[0];
            String plantName = inputs[1];
            String value = command.equals("Reset:") ? null : inputs[3];

            Plant plant = plants.get(plantName);
            if (null == plant) {
                System.out.println("error");
                continue;
            }

            switch (command) {
                case "Rate:":
                    plant.getRatings().add(Double.parseDouble(value));
                    break;
                case "Update:":
                    plant.setRarity(Integer.parseInt(value));
                    break;
                case "Reset:":
                    plant.getRatings().clear();
                    break;
            }
        }
        scanner.close();

        System.out.println("Plants for the exhibition:");
        plants.values().forEach(System.out::println);
    }
}