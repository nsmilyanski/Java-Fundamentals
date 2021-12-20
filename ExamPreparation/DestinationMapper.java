package ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([\\=\\/])(?<destination>[A-Z][A-Za-z]{2,})\\1";
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        int sum =0;

        List<String>  destinationList = new ArrayList<>();

        while (matcher.find()){
            String destination = matcher.group("destination");
            int length = destination.length();
            sum += length;
            destinationList.add(destination);
        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ", destinationList));
        System.out.println("Travel Points: " + sum);
    }
}
