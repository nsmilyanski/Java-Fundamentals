package testing;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> populationList = new TreeMap<>();
        Map<String, Integer> goldList = new TreeMap<>();

        while (!input.equals("Sail")){
            String[] inputArr = input.split("\\|\\|");
            String key = inputArr[0];
            int people = Integer.parseInt(inputArr[1]);
            int gold = Integer.parseInt(inputArr[2]);

            populationList.putIfAbsent(key, 0);
            goldList.putIfAbsent(key, 0);

            populationList.put(key, populationList.get(key) + people);
            goldList.put(key, goldList.get(key) + gold);


            input = scanner.nextLine();
        }

        String token = scanner.nextLine();

        while (!token.equals("End")){
            String[] tokenArr = token.split("=>");

            String command = tokenArr[0];

            switch (command){
                case "Plunder":
                    String town = tokenArr[1];
                    int people = Integer.parseInt(tokenArr[2]);
                    int gold = Integer.parseInt(tokenArr[3]);

                    if (populationList.containsKey(town)) {
                    populationList.put(town, populationList.get(town) - people);
                    goldList.put(town, goldList.get(town) - gold);
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town,
                                gold, people);

                    }
                    if (populationList.get(town) <= 0 || goldList.get(town) <= 0){
                        System.out.printf("%s has been wiped off the map!%n", town);
                        goldList.remove(town);
                        populationList.remove(town);
                    }

                    break;
                case "Prosper":

                    String city = tokenArr[1];
                    int goldForIncrease = Integer.parseInt(tokenArr[2]);

                    if (goldForIncrease < 0){
                        System.out.printf("Gold added cannot be a negative number!%n");
                    }else {
                        goldList.put(city, goldList.get(city) + goldForIncrease);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                                goldForIncrease, city, goldList.get(city));
                    }
                    break;
            }


            token = scanner.nextLine();
        }

        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", goldList.size());
        goldList.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(element -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                        element.getKey(), populationList.get(element.getKey()), element.getValue()));
    }
}
