package ExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());;

        String regex = "([@][\\#]+)(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])([@][\\#]+)";
        Pattern pattern = Pattern.compile(regex);


        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            Matcher matcher = pattern.matcher(text);


            if (matcher.find()) {
                String sum = "";
                String regexDigit = "[0-9]";
                Pattern patternDigit = Pattern.compile(regexDigit);
                String barcode = matcher.group("barcode");
                Matcher matcherDigit = patternDigit.matcher(barcode);

                boolean hasDigit = false;
                while (matcherDigit.find()) {
                    hasDigit = true;
                    String digit = matcherDigit.group();
                    sum += digit;
                }
                if (!hasDigit) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.printf("Product group: %s%n", sum);
                }


            }else {
                System.out.println("Invalid barcode");
            }
        }

    }
}
