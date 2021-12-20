package testing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "(@[#]+)(?<word>[A-Z][A-Za-z0-9]{4,}[A-Z])(@[#]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = null;

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();

            matcher = pattern.matcher(text);

            StringBuilder sum = new StringBuilder();
            boolean foundDigit = false;
            if (matcher.find()){
                String barcode = matcher.group("word");

                for (int j = 0; j < barcode.length(); j++) {
                    char symbol = barcode.charAt(j);

                    if (Character.isDigit(symbol)){
                        foundDigit = true;
                        sum.append(symbol);
                    }
                }

                if (!foundDigit){
                    System.out.println("Product group: 00");
                }else {
                    System.out.println("Product group: " + sum);
                }

            }else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
