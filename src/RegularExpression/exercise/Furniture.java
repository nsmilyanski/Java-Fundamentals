package RegularExpression.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String text = scanner.nextLine();
        List<String> nameList = new ArrayList<>();
        double sum = 0;
        String regex = ">>(?<name>[A-Za-z]+)<<(?<price>\\d+[.]*[\\d]*)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        while (!text.equals("Purchase")){
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()){
        String name = matcher.group("name");
        double price = Double.parseDouble(matcher.group("price"));
        int quantity = Integer.parseInt(matcher.group("quantity"));
        nameList.add(name);
        sum += quantity * price;

        }
            text = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        nameList.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", sum);


    }
}
