package ExamPreparation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NeedforSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> distanceMap = new TreeMap<>();
        Map<String, Integer> fuelMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String [] inputArr = scanner.nextLine().split("\\|");
            String car = inputArr[0];
            int distance = Integer.parseInt(inputArr[1]);
            int fuel = Integer.parseInt(inputArr[2]);

            distanceMap.put(car, distance);
            fuelMap.put(car, fuel);

        }

        String token = scanner.nextLine();

        while (!token.equals("Stop")){
            String[] tokenArr = token.split(" : ");
            String command = tokenArr[0];
            String cars = tokenArr[1];

            switch (command){
                case "Drive":
                    int distance = Integer.parseInt(tokenArr[2]);
                    int fuel = Integer.parseInt(tokenArr[3]);
                    if (fuel > fuelMap.get(cars)){
                        System.out.println("Not enough fuel to make that ride");
                    }else {
                       int newDistance =  distanceMap.get(cars) + distance;
                       distanceMap.put(cars, newDistance);
                       fuelMap.put(cars, fuelMap.get(cars) - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",
                                cars, distance, fuel);
                    }

                    if (distanceMap.get(cars) > 100000){
                        distanceMap.remove(cars);
                        fuelMap.remove(cars);
                        System.out.printf("Time to sell the %s!%n", cars);
                    }
                    break;
                case "Refuel":
                    int fuelOfTank = Integer.parseInt(tokenArr[2]);
                    int litersForRefuel = fuelOfTank + fuelMap.get(cars);
                    if (litersForRefuel > 75){
                        int refueled = 75 - fuelMap.get(cars);
                        System.out.printf("%s refueled with %d liters%n", cars, refueled);
                        fuelMap.put(cars, 75);
                    }else {
                        System.out.printf("%s refueled with %d liters%n", cars, fuelOfTank);
                        fuelMap.put(cars, litersForRefuel);
                    }
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(tokenArr[2]);
                    int decreaseKm = distanceMap.get(cars) - kilometers;
                    if (decreaseKm < 10000){
                        distanceMap.put(cars, 10000);
                    }else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", cars, kilometers);
                        distanceMap.put(cars, decreaseKm);
                    }
                    break;
            }
            token = scanner.nextLine();
        }
        distanceMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                        entry.getKey(), entry.getValue(), fuelMap.get(entry.getKey())));
    }
}
