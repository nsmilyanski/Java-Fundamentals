package DataTypesandVariables.lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumofRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        BigDecimal num = BigDecimal.valueOf(0);

        for (int i = 1; i <= n ; i++) {
            BigDecimal currentNum = new BigDecimal(scanner.nextLine());

            num = num.add(currentNum);
            
        }
        System.out.println(num);
    }
}
