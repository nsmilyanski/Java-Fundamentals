package ExamPreparation;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<Integer>> piratesMap = new TreeMap<>();

        while (!input.equals("Sail")){
            String[] sailArr = input.split("\\|+");
            String town = sailArr[0];
            int population = Integer.parseInt(sailArr[1]);
            int gold = Integer.parseInt(sailArr[2]);
            if (!piratesMap.containsKey(town)){
                piratesMap.put(town, new ArrayList<>());
            piratesMap.get(town).add(population);
            piratesMap.get(town).add(gold);
            }else {
                piratesMap.get(town).set(0, piratesMap.get(town).get(0) + population);
                piratesMap.get(town).set(1, piratesMap.get(town).get(1) + gold);
            }

            input = scanner.nextLine();
        }
        String command = scanner.nextLine();

        while (!command.equals("End")){
            String[] commArr = command.split("=>");
            String comm = commArr[0];
            String city = commArr[1];
            switch (comm){
                case "Plunder":
                    if (piratesMap.containsKey(city)){
                        int people = Integer.parseInt(commArr[2]);
                        int gold = Integer.parseInt(commArr[3]);
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",
                                city, gold, people);
                        int killedPeople = piratesMap.get(city).get(0) - people;
                        int stolenGold = piratesMap.get(city).get(1) - gold;
                        piratesMap.get(city).set(0, killedPeople);
                        piratesMap.get(city).set(1, stolenGold);
                        if (killedPeople <= 0 || stolenGold <= 0){
                            piratesMap.remove(city);
                            System.out.printf("%s has been wiped off the map!%n", city);
                        }
                    }
                    break;
                case "Prosper":
                    int goldAdded = Integer.parseInt(commArr[2]);
                    if (goldAdded < 0){
                        System.out.printf("Gold added cannot be a negative number!%n");
                    }else {
                        int amountGold = goldAdded + piratesMap.get(city).get(1);
                        piratesMap.get(city).set(1, amountGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                                goldAdded, city, amountGold);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        if (!piratesMap.isEmpty()) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",
                    piratesMap.size());
        }
        piratesMap.entrySet().stream()
                .sorted((e1,e2) -> e2.getValue().get(1).compareTo(e1.getValue().get(1)))
                .forEach(capitan -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                        capitan.getKey(), capitan.getValue().get(0), capitan.getValue().get(1)));


    }
}
