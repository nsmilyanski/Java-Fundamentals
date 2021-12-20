package testing;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NeedforSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> mileageMap = new TreeMap<>();
        Map<String, Integer> fuelMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] carsInfo = scanner.nextLine().split("\\|");

            String cars = carsInfo[0];
            int mileage = Integer.parseInt(carsInfo[1]);
            int fuel = Integer.parseInt(carsInfo[2]);

            mileageMap.put(cars, mileage);
            fuelMap.put(cars, fuel);

        }

        String commands = scanner.nextLine();

        while (!commands.equals("Stop")){
            String[] tokens = commands.split(" \\: ");
            String commandFirst = tokens[0];
            String cars = tokens[1];

            switch (commandFirst){
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);

                    if (fuel > fuelMap.get(cars)){
                        System.out.println("Not enough fuel to make that ride");
                    }else {
                        fuelMap.put(cars, fuelMap.get(cars) - fuel);
                        mileageMap.put(cars, mileageMap.get(cars) + distance);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", cars,
                                distance, fuel);
                        if (mileageMap.get(cars) > 100000){
                            mileageMap.remove(cars);
                            System.out.printf("Time to sell the %s!%n", cars);
                        }
                    }
                    break;
                case "Refuel":
                    int fuelForRefuel = Integer.parseInt(tokens[2]);
                    int fieldTank = fuelForRefuel + fuelMap.get(cars);

                    if (fieldTank > 75){
                        int leftFuel = 75 - fuelMap.get(cars);
                        fuelMap.put(cars, 75);
                        System.out.printf("%s refueled with %d liters%n", cars, leftFuel);
                    }else {
                        fuelMap.put(cars, fieldTank);
                        System.out.printf("%s refueled with %d liters%n", cars, fuelForRefuel);
                    }

                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(tokens[2]);
                    int decreased = mileageMap.get(cars) - kilometers;
                    if (decreased < 10000){
                        mileageMap.put(cars, 10000);
                    }else {
                        mileageMap.put(cars, decreased);
                        System.out.printf("%s mileage decreased by %d kilometers%n", cars, kilometers);
                    }
                    break;
            }



            commands = scanner.nextLine();
        }
        mileageMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(cars -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                        cars.getKey(), cars.getValue(), fuelMap.get(cars.getKey())));

    }
}
