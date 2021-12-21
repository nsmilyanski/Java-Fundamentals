package RegularExpression.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "%(?<customer>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>\\d+)\\|[^|$%.\\d]*(?<price>[\\d]+[.]*[\\d]*)\\$";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();
        double totalSum = 0.0;

        while (!input.equals("end of shift")){
        double sum = 0.0;
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String name = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                sum = price * count;
                totalSum += sum;
                System.out.printf("%s: %s - %.2f%n", name, product, sum);
            }
            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", totalSum);
    }
}
