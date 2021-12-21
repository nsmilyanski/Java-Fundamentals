package testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Astra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text  = scanner.nextLine();

        String regex = "([#|\\|])(?<name>[A-Za-z]+[\\s]*[A-Za-z]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]{1,4})\\1";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        List<String> foodList = new ArrayList<>();

        int sumCalories = 0;

        while (matcher.find()){
            String name = matcher.group("name");
            String date = matcher.group("date");
            String calories = matcher.group("calories");

            sumCalories += Integer.parseInt(calories);

            foodList.add(name);
            foodList.add(date);
            foodList.add(calories);


        }
        System.out.printf("You have food to last you for: %d days!%n", sumCalories/2000);

        for (int i = 0; i < foodList.size(); i+=3) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n", foodList.get(i),
                  foodList.get(i+1), foodList.get(i + 2));

        }
    }
}
