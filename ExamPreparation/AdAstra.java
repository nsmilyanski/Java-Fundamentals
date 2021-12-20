package ExamPreparation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    static class Food{
        private String name;
        private String date;
        private String calories;

        public Food(String name, String date, String calories) {
            this.name = name;
            this.date = date;
            this.calories = calories;
        }

        public String getName() {
            return name;
        }

        public String getDate() {
            return date;
        }

        public String getCalories() {
            return calories;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([\\#\\|])(?<name>[A-Za-z]+[\\s]?[\\w]+)\\1(?<date>[\\d]{2}\\/[\\d]{2}\\/[\\d]{2})\\1(?<calories>[\\d]{1,4})\\1";
        Pattern pattern = Pattern.compile(regex);

        String text = scanner.nextLine();

        Matcher matcher = pattern.matcher(text);
        Map<String, List<String>> foodMap = new LinkedHashMap<>();
        List<Food> foodList = new ArrayList<>();

        int sumCalories = 0;

        while (matcher.find()){
            String name = matcher.group("name");
            String date = matcher.group("date");
            String calories = matcher.group("calories");

           Food currentFood = new Food(name, date, calories);
            foodList.add(currentFood);

            sumCalories += Integer.parseInt(calories);

        }
        sumCalories = sumCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", sumCalories);

        for (Food food: foodList) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n", food.getName(), food.getDate(),
                    food.getCalories());

        }
    }
}
